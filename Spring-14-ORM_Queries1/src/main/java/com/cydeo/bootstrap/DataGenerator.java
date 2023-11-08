package com.cydeo.bootstrap;

import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class DataGenerator implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository,
                         EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------Region Start-----------");
        System.out.println(regionRepository.findByCountry("United States"));
        System.out.println("findDistinctByCountry: "+ regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainingOrderByCountry: "+ regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println("findTop2ByCountry: " + regionRepository.findTop2ByCountry("Canada"));
        System.out.println("--------Region End---------------");
        System.out.println("--------Department Start--------------");
        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Toys"));
        System.out.println("findByDivisionEquals: "+ departmentRepository.findByDivisionEquals("Health"));
        System.out.println("indDistinctTopByDivisionContaining: "+ departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
        System.out.println("--------Department End--------------");
        System.out.println("-----------EMPLOYEE START---------------");
        System.out.println("getEmployeeDetail: " + employeeRepository.getEmployeeDetail());
        System.out.println("getEmployeeSalary: " + employeeRepository.getEmployeeSalary());
        System.out.println("-----------EMPLOYEE END---------------");
        System.out.println("-----------COURSE START---------------");
        courseRepository.findByCategory("Spring").forEach(System.out::println);
        courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);
        System.out.println(courseRepository.existsByName("Rapid Spring Boot Application Development"));
        System.out.println(courseRepository.existsByName("Java Course for beginners"));
        System.out.println(courseRepository.countByCategory("Spring"));
        courseRepository.findByNameStartingWith("Scalable").forEach(System.out::println);
        courseRepository.streamByCategory("Spring").forEach(System.out::println);
        System.out.println("-----------COURSE END---------------");
    }
}
