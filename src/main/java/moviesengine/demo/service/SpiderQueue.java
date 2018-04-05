package moviesengine.demo.service;

import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Component
public class SpiderQueue {
    private static Set<String> visitedUrl  =new HashSet<> ();
    public static void addVisitedUrl(String url){
        visitedUrl.add (url);
    }
    public static void removeVisitedUrl(String url){
        visitedUrl.remove (url);
    }

    public static int getVisitedUrlNum(){
        return visitedUrl.size ();
    }
}
