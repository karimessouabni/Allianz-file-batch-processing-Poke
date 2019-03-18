package hello;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BatchConfiguration.class})
class BatchTest {

    @Autowired
    private FlatFileItemReader flatFileItemReader;

    private PersonProcessor personProcessor = new PersonProcessor();

    @Test
    void processor_test() throws Exception {
        Person p = new Person("karim", "essouabni");

        Person res = personProcessor.process(p);
        Assertions.assertEquals("karim", p.getFirstName());
    }


}
