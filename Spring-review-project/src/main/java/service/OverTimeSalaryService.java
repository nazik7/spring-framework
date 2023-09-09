package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import repository.EmployeeRepository;
import repository.HoursRepository;

@Component

public class OverTimeSalaryService {
    EmployeeRepository employeeRepository;

    HoursRepository hoursRepository;
    public OverTimeSalaryService(EmployeeRepository employeeRepository, @Qualifier("overtime") HoursRepository hoursRepository){
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void getOverTimeSalary(){
        System.out.println("Overtime salary: " + employeeRepository.getHourlyRate() * hoursRepository.getHours());
    }
}
