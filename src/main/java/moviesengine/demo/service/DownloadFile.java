package moviesengine.demo.service;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;


@Service
public class DownloadFile {

    //https://www.dy2018.com/i/99050.html
    public String getRespond(String webSite, List<String> seekUrls) {
        StringBuilder stringBuilder = new StringBuilder ();
        try {
            HttpClient httpClient = new HttpClient ();
            GetMethod getMethod = new GetMethod (webSite);
            getMethod.addRequestHeader ("Content-Type", "text/html;charset=UTF-8");
            getMethod.addRequestHeader ("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299");

            int responseCode = httpClient.executeMethod (getMethod);

            if (responseCode == 200) {
                //IO stream
                InputStream inputStream = getMethod.getResponseBodyAsStream ();
                InputStreamReader streamReader = new InputStreamReader (inputStream, "GB2312");
                BufferedReader reader = new BufferedReader (streamReader);
                String str;
                while ((str = reader.readLine ()) != null) {
                    stringBuilder.append (str + "\n");
                    String seek = extractSeedUrl (str);
                    if (seek != null) {
                        seekUrls.add (seek);
                    }
                    System.out.println (str + "\n");
                }
                inputStream.close ();
            } else {
                return "" + responseCode + '\n' + getMethod.getResponseBodyAsString ();
            }
        } catch (Exception ex) {
            System.out.println ("获取不到网页源码：" + ex);
        }
        return stringBuilder.toString ();
    }


    private String extractSeedUrl(String oneLineContent) {
        int begin = 0;
        int end = 0;
        if (oneLineContent.contains ("thunder://")) {
            begin = oneLineContent.indexOf ("thunder://");
            String beginStr = oneLineContent.substring (begin);
            end = beginStr.indexOf ("\"");
            return oneLineContent.substring (begin, begin + end + 1);
        }
        if (oneLineContent.contains ("magnet:?")) {
            begin = oneLineContent.indexOf ("magnet:?");
            String beginStr = oneLineContent.substring (begin);
            end = beginStr.indexOf ("\"");
            return oneLineContent.substring (begin, begin + end + 1);
        }
        return null;
    }

    private List<String> extractWebUrl(String webContent) {
        return null;
    }
}
