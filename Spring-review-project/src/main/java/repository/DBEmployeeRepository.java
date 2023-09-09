package repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.Employee;
import org.springframework.stereotype.Component;
@Component
@AllArgsConstructor
public class DBEmployeeRepository implements EmployeeRepository{


    @Override
    public int getHourlyRate() {
        Employee employee = new Employee("Jake Philipps","IT", 50);
        return employee.getHourlyRate();
    }
}
