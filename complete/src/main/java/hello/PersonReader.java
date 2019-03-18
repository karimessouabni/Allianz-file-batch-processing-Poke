package hello;


import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.Field;
import java.util.stream.Stream;

@Configuration
public class PersonReader {

    @Bean
    public FlatFileItemReader<Person> reader() {

        String[] itemFieldNamesTab = Stream.of(Person.class.getDeclaredFields()).map(Field::getName).toArray(String[]::new);
        return new FlatFileItemReaderBuilder<Person>()
                .name("personItemReader")
                .resource(new ClassPathResource("sample-data.csv"))
                .delimited()
                .names(itemFieldNamesTab)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
                    setTargetType(Person.class);
                }})
                .build();
    }

}
