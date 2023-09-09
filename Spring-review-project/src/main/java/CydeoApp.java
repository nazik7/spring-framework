import config.ConfigClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.OverTimeSalaryService;
import service.SalaryService;

public class CydeoApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
        SalaryService salaryService = context.getBean(SalaryService.class);
        salaryService.calculateRegularSalary();

        OverTimeSalaryService overTimeSalaryService = context.getBean(OverTimeSalaryService.class);
        overTimeSalaryService.getOverTimeSalary();
    }
}
