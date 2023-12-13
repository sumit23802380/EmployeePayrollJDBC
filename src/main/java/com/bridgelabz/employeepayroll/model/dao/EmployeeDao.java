package com.bridgelabz.employeepayroll.model.dao;

import com.bridgelabz.employeepayroll.model.entities.Company;
import com.bridgelabz.employeepayroll.model.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    void insert(Employee employee);
    void update(Employee employee);
    void deleteBy(int id);
    Employee findById(int id);
    List<Employee> findAll();
}
