package com.hazalcast.example.service;

import com.hazalcast.example.model.Employee;

import java.util.List;

public interface EmployeeService {
    void insertEmployee(Employee emp);

    void insertEmployees(List<Employee> employees);

    List<Employee> getAllEmployee();

    void getEmployeeById(String empid);
}
