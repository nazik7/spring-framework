package bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigClass {
    @Bean("str")
    //@Primary
    String str(){
        return "Welcome to Cydeo App";
    }
    @Bean(name = "str1")
    String str1(){
        return "Spring Core Practice";
    }
}
