package com.bridgelabz.employeepayroll.model.entities;

/**
 * @desc : Department Class
 */
public class Department {
    private int departmentId;
    private String departmentName;

    /**
     * @desc : Method to get the department id
     * @return : departmentId
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * @desc : Method to set the department id
     * @param : departmentId
     */
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * @desc : Method to get the name of the department
     * @return : departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @desc : Method to set the department name
     * @param : departmentName
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * @desc : Method to return the formatted string object of Department
     * @return : formatted string object of department
     */
    @Override
    public String toString() {
        return "Department{" +
                " departmentName='" + departmentName + '\'' +
                '}';
    }
}
