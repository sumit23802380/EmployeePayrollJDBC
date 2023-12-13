package com.bridgelabz.employeepayroll.model.dao;
import com.bridgelabz.employeepayroll.model.entities.Department;
import java.util.List;
public interface DepartmentDao {
    void insert(Department department);
    void update(Department department);
    void deleteBy(int id);
    Department findById(int id);
    List<Department> findAll();
}