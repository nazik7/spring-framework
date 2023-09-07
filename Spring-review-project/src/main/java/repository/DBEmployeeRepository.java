package repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.Employee;
import org.springframework.stereotype.Component;
@Component
@AllArgsConstructor
public class DBEmployeeRepository implements EmployeeRepository{

Employee employee;
    @Override
    public int getHourlyRate() {
        return employee.getHourlyRate();
    }
}
