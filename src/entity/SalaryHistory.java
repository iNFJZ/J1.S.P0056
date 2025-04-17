/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author iNJZ
 */
public class SalaryHistory {

    private String code;
    private double oldSalary;
    private double newSalary;
    private Date changeDate;
    private SalaryStatus status;

    public enum SalaryStatus {
        UP, DOWN
    }

    public SalaryHistory() {
    }

    public SalaryHistory(String code, double oldSalary, double newSalary, Date changeDate, SalaryStatus status) {
        this.code = code;
        this.oldSalary = oldSalary;
        this.newSalary = newSalary;
        this.changeDate = changeDate;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getOldSalary() {
        return oldSalary;
    }

    public void setOldSalary(double oldSalary) {
        this.oldSalary = oldSalary;
    }

    public double getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(double newSalary) {
        this.newSalary = newSalary;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public SalaryStatus getStatus() {
        return status;
    }

    public void setStatus(SalaryStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SalaryHistory{" + "code=" + code + ", oldSalary=" + oldSalary + ", newSalary=" + newSalary + ", changeDate=" + changeDate + ", status=" + status + '}';
    }

}
