package moviesengine.demo.service;

import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collection;

import static org.junit.Assert.*;


public class DownloadFileTest {
    @Test
    public void StringTest() {
        String oneLineContent = "<a title=\"迅雷专用高速下载\" onclick=\"return OnDownloadClick_Simple(this,2)\" oncontextmenu=\"ThunderNetwork_SetHref(this)\" href=\"#\" target=\"_self\" thunderrestitle=\"\" thundertype=\"\" thunderpid=\"00000\" yzqqsoqz=\"thunder://QUFmdHA6Ly9kOmRAZHlnb2RqOC5jb206MTIzMTEvW+eUteW9seWkqeWggnd3dy5keTIwMTguY29tXXlk6L+35a6rM++8muatu+S6oeino+iNr0hE6Z+p54mI5Lit5a2XLm1wNFpa\">ftp://d:d@dygodj8.com:12311/[电影天堂www.dy2018.com]yd迷宫3：死亡解药HD韩版中字.mp4</a>";
        int begin = oneLineContent.indexOf ("thunder://");
        String beginStr = oneLineContent.substring (begin);
        int end = beginStr.indexOf ("\"");
        System.out.println (oneLineContent.substring (begin, begin + end + 1));
    }

    @Test
    public void FileLoading() throws Exception {
        Collection<File> cc = FileUtils.listFiles (
                new File ("C:\\Users\\luxuda\\workspace\\demo_web\\src\\main\\java\\com\\example\\demo_web"),
                new String[]{"java"}, true);
        cc.forEach (x -> {
            try {
                new File ("C:\\Users\\luxuda\\workspace\\gg" + "\\" + x.getName ()).createNewFile ();
            } catch (Exception ex) {
                System.out.println (ex.getMessage ());
            }
            ;
        });
    }

}