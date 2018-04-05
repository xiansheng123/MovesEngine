package moviesengine.demo;

import lombok.AllArgsConstructor;
import moviesengine.demo.service.DownloadFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class Controller {
    private DownloadFile downloadFile;

    @PostMapping(value = "/test")
    public List<String> GetMovies() {
        String url = "https://www.dy2018.com/i/99050.html";
        List<String> seekUrl = new ArrayList<> ();
        downloadFile.getRespond (url, seekUrl);
        return seekUrl;
    }

}
