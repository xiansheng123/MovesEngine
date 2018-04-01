package moviesengine.demo.service;

import org.springframework.stereotype.Service;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class DownloadFile {

    public String getRespond() {
        String r = "";
        StringBuilder text=new   StringBuilder ();
        try {
            URL url = new URL ("https://www.dy2018.com/i/99050.html");

            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection ();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty ("User-Agent","Mozilla/5.0 (compatible; MSIE 9.0; Windows NT; DigExt)");
            int responseCode = urlConnection.getResponseCode ();

            if (responseCode == 200) {
                //IO stream
                InputStream inputStream=urlConnection.getInputStream ();
                InputStreamReader inputStreamReader =new InputStreamReader (inputStream, "GB2312");
                BufferedReader reader = new BufferedReader (inputStreamReader);

                while ((r = reader.readLine ()) != null) {
                    System.out.println (r);
                    text.append (r).append ('\n');
                }
            } else return ""+ responseCode +'\n'+urlConnection.getResponseMessage ();
        } catch (Exception ex) {
            System.out.println ("获取不到网页源码：" + ex);
        }
        return text.toString ();
    }
}
