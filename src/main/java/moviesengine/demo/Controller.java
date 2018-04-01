package moviesengine.demo;

import lombok.AllArgsConstructor;
import moviesengine.demo.service.DownloadFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class Controller {
    private DownloadFile downloadFile;

    @PostMapping(value = "/test")
    public String GetMovies(){
       return downloadFile.getRespond ();
    }

}
