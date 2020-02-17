package com.hazalcast.example;

import com.hazalcast.example.model.Employee;
import com.hazalcast.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableCaching
public class SpringBootJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);


        Employee emp = new Employee();
        emp.setEmpId("emp");
        emp.setEmpName("emp");

        Employee emp1 = new Employee();
        emp1.setEmpId("emp1");
        emp1.setEmpName("emp1");

        Employee emp2 = new Employee();
        emp2.setEmpId("emp2");
        emp2.setEmpName("emp2");


        employeeService.insertEmployee(emp);

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employeeService.insertEmployees(employees);


        System.out.println("Inside the main class making call to com.hazalcast.example.service first time");
        List<Employee> employeeList1 = employeeService.getAllEmployee();
        for (Employee employee : employeeList1) {
            System.out.println(employee.toString());
        }


        System.out.println("Inside the main class making call to com.hazalcast.example.service second time where it will use hazelcast");
        List<Employee> employeeList2 = employeeService.getAllEmployee();
        for (Employee employee : employeeList2) {
            System.out.println(employee.toString());
        }

    }
}
