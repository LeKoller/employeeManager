package com.lekoller.employeemanager;

import com.lekoller.employeemanager.services.EmployeeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeResources {
    private final EmployeeService employeeService;

    public EmployeeResources(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
