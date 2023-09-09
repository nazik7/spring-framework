package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import repository.DBEmployeeRepository;
import repository.EmployeeRepository;
import repository.HoursRepository;
import repository.RegularHours;
@Component
public class SalaryService {
    EmployeeRepository employeeRepository;
    HoursRepository hoursRepository;

    public SalaryService(EmployeeRepository employeeRepository,@Qualifier("regular") HoursRepository hoursRepository){
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }
    public void calculateRegularSalary(){
        System.out.println("Regular salary: " + employeeRepository.getHourlyRate() * hoursRepository.getHours());

    }
}
