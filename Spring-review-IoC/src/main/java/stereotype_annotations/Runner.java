package stereotype_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.config.ConfigApp;
import stereotype_annotations.model.DataStructure;
import stereotype_annotations.model.Microservice;

public class Runner {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        DataStructure dataStructure = context.getBean(DataStructure.class);
        dataStructure.getTotalHours();
        Microservice microservice = context.getBean(Microservice.class);
        microservice.getTotalHours();
    }
}
