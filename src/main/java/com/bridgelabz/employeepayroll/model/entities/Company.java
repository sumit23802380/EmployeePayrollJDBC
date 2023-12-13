package com.bridgelabz.employeepayroll.model.entities;

/**
 * @desc : Company Class
 */
public class Company {

    private int companyId;
    private String companyName;

    /**
     * @desc : Method to get the company id
     * @return : companyId
     */
    public int getCompanyId() {
        return companyId;
    }

    /**
     * @desc : Method to set the company id
     * @param : companyId
     */
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    /**
     * @desc : Method to get the company name
     * @return : companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @desc : Method to set the company Name
     * @param : companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @desc : Method to return formatted object of the company as string
     * @return : formatted string object of company
     */
    @Override
    public String toString() {
        return "Company{" +
                " companyName='" + companyName + '\'' +
                '}';
    }
}
