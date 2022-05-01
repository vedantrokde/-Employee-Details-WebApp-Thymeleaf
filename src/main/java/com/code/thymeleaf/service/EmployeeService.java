package com.code.thymeleaf.service;

import java.util.List;

import com.code.thymeleaf.model.Employee;
import com.code.thymeleaf.repo.EmployeeRepo;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private EmployeeRepo repo;

    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public List<Employee> getEmployees() {
        return repo.findAllByOrderByFirstNameAsc();
    }

    public Employee getEmployee(int id) {
        return repo.findById(id).orElseThrow();
    }

    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);
    }

    public void deleteEmployee(int id) {
        repo.deleteById(id);;
    }
    
}
