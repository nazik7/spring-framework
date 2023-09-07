package bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class CydeoApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigClass.class);
        FullTimeEmployee fullTimeEmployee = context.getBean(FullTimeEmployee.class);
        fullTimeEmployee.createAccount();

        PartTimeEmployee partTimeEmployee = context.getBean(PartTimeEmployee.class);
        partTimeEmployee.createAccount();

        String str = context.getBean("str",String.class);
        System.out.println(str);
        String str1 = context.getBean("str1",String.class);
        System.out.println(str1);
    }


}
