package repository;

import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository {
    int getHourlyRate();
}
