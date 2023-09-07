package model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class Employee {
    private String name;
    private String department;
    private int hourlyRate;
}
