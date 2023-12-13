package com.bridgelabz.employeepayroll.model.dao;
import com.bridgelabz.employeepayroll.model.entities.Payroll;
import java.util.List;
public interface PayrollDao {
    void insert(Payroll payroll);
    void update(Payroll payroll);
    void deleteBy(int id);
    Payroll findById(int id);
}