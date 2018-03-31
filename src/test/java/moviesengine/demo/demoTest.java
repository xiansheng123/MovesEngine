package moviesengine.demo;

import org.assertj.core.condition.Join;
import org.hibernate.validator.constraints.EAN;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RunWith (MockitoJUnitRunner.class)
public class demoTest {

    @Test
    public void  Test() throws Exception{
        List<String> StrList= Arrays.asList ("11","22","33","44","55");
        System.out.println (StrList.stream ().collect (Collectors.joining (",")));
    }

    @Test
    public void fibinacci_Test() {
        System.out.println (fibinacci (1));
        System.out.println (fibinacci (2));
        System.out.println (fibinacci (3));
        System.out.println (fibinacci (4));
        System.out.println (fibinacci (5));
        System.out.println (fibinacci (6));
        System.out.println (fibinacci (7));
        System.out.println (fibinacci (8));
        System.out.println (fibinacci (100));

    }

    @Test
    public void testRemoveList(){
        List<String> StrList= Arrays.asList ("11","22","33","442","55");
        System.out.println (StrList.subList (0,4));
    }

    @Test
    public void testCollect(){
        List<String> StrList= Arrays.asList ("11","22","33","442","55");
        System.out.println (StrList.stream ().map (x->x+"9").collect (toList()));
        System.out.println (StrList);
    }



    private long fibinacci(long number) {
        if (number == 0 || number == 1) {
            return number;
        } else {
            return fibinacci (number - 1) + fibinacci (number - 2);
        }
    }
}
