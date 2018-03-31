package moviesengine.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MovieInfoTest {

    @Test
    public void classTest() {
        Person a1 = new Person ("xiaoming", 12);
        Adult a2 = new Adult ("lumeng", 3, "kid");
        Person cc = a2;
        List<? super Adult> mm =new ArrayList<Person> (){
            {
                add (a1);
                add (a2);
            }
        };
        System.out.println (mm);
    }

}


@Data
 class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.age = age;
        this.name = name;
    }
}

@Data
 class Adult extends Person{
    private String occupation;

    Adult(String name, int age, String occupation) {
        super (name, age);
        this.occupation = occupation;
    }


}
