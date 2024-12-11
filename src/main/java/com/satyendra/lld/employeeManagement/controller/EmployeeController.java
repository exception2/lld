package com.satyendra.lld.employeeManagement.controller;

import com.satyendra.lld.employeeManagement.entity.Employee;
import com.satyendra.lld.employeeManagement.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping(value = "/employees")
    public List<Employee> getEmployee() {
        return employeeRepo.findAll();
    }

    @PostMapping(value = "/employees")
    public Employee persistEmployee(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }
}
