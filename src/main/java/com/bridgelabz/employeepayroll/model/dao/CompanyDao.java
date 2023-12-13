package com.bridgelabz.employeepayroll.model.dao;
import com.bridgelabz.employeepayroll.model.entities.Company;
import java.util.List;
public interface CompanyDao {
    void insert(Company company);
    void update(Company company);
    void deleteBy(int id);
    Company findById(int id);
    List<Company> findAll();
}