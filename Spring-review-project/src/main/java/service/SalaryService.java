package service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import repository.DBEmployeeRepository;
import repository.RegularHours;
@Component
@AllArgsConstructor
public class SalaryService {
    DBEmployeeRepository dbEmployeeRepository;
    RegularHours regularHours;
    public void calculateRegularSalary(){
        System.out.println("Regular salary: " + dbEmployeeRepository.getHourlyRate() * regularHours.getHours());

    }
}
