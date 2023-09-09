import config.ConfigClass;
import config.ConfigService;
import model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.DBEmployeeRepository;
import service.SalaryService;

public class CydeoApp {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setDepartment("Software Engineering");
        employee.setName("Dakota Johnson");
        employee.setHourlyRate(50);
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
        DBEmployeeRepository dbEmployeeRepository = context.getBean(DBEmployeeRepository.class);
        //dbEmployeeRepository(employee);
        SalaryService salaryService = context.getBean(SalaryService.class);
        salaryService.calculateRegularSalary();
    }
}
