package com.code.thymeleaf.repo;

import java.util.List;

import com.code.thymeleaf.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    // ordered list<emp>
    public List<Employee> findAllByOrderByFirstNameAsc();
}
