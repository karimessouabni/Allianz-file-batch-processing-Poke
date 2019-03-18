package hello;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        PersonReader.class})
public class BatchTest {


    @Autowired
    private FlatFileItemReader<Person> personReader;


    private PersonProcessor personProcessor = new PersonProcessor();

    @Test
    public void processor_test() throws Exception {
        Person p = new Person("karim", "essouabni");

        Person res = personProcessor.process(p);
        Assert.assertEquals("karim", p.getFirstName());
    }


}
