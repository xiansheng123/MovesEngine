package moviesengine.demo.service;

import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class DownloadFile {

    //https://www.dy2018.com/i/99050.html
    public String getRespond(String webSite, List<String> seekUrls) {
        StringBuilder stringBuilder = new StringBuilder ();
        try {
            URL url = new URL (webSite);

            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection ();
            urlConnection.setRequestMethod ("GET");
            urlConnection.setRequestProperty ("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT; DigExt)");
            int responseCode = urlConnection.getResponseCode ();

            if (responseCode == 200) {
                //IO stream
                InputStream inputStream = urlConnection.getInputStream ();
                InputStreamReader streamReader = new InputStreamReader (inputStream, "GB2312");
                BufferedReader reader = new BufferedReader (streamReader);
                String str;
                while ((str = reader.readLine ()) != null) {
                    stringBuilder.append (str+"xuda\n");
                    String seek = extractSeedUrl (str);
                    if (seek != null) {
                        seekUrls.add (seek);
                    }
                }
                inputStream.close ();
                urlConnection.disconnect ();
            } else {
                return "" + responseCode + '\n' + urlConnection.getResponseMessage ();
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
            System.out.println (oneLineContent.substring (begin, begin + end + 1));
        }
        if (oneLineContent.contains ("magnet:?")) {
            begin = oneLineContent.indexOf ("magnet:?");
            String beginStr = oneLineContent.substring (begin);
            end = beginStr.indexOf ("\"");
            System.out.println (oneLineContent.substring (begin, begin + end + 1));
        }
        return null;
    }

    private List<String> extractWebUrl(String webContent) {
        return null;
    }
}
