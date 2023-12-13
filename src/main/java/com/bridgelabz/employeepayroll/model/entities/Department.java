package com.bridgelabz.employeepayroll.model.entities;

public class Department {
    private int departmentId;
    private String departmentName;

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                " departmentName='" + departmentName + '\'' +
                '}';
    }
}
