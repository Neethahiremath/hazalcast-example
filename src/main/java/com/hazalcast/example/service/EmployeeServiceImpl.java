package com.hazalcast.example.service;

import java.util.List;

import com.hazalcast.example.dao.EmployeeDao;
import com.hazalcast.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "employees")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public void insertEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        employeeDao.insertEmployees(employees);
    }

    @Override
    @Cacheable()
    public List<Employee> getAllEmployee() {
        System.out.println("Inside the com.hazalcast.example.service layer");
        return employeeDao.getAllEmployees();

    }

    @Override
    public void getEmployeeById(String empId) {
        Employee employee = employeeDao.getEmployeeById(empId);
        System.out.println(employee);
    }
}
