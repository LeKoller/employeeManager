package com.lekoller.employeemanager.services;

import java.util.UUID;

import javax.transaction.Transactional;

import com.lekoller.employeemanager.exceptions.UserNotFoundExeption;
import com.lekoller.employeemanager.models.Employee;
import com.lekoller.employeemanager.repos.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString()); 
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    public Employee updatEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployee(Long id) {
        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundExeption("User not found."));
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
        System.out.println("oi");
    }
}
