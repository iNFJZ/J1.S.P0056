/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.SalaryHistory;
import entity.Worker;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author iNJZ
 */
public class WorkerManager {

    private List<Worker> workers;
    private List<SalaryHistory> salaryHistories;

    public WorkerManager() {
        workers = new ArrayList<>();
        salaryHistories = new ArrayList<>();
    }

    public boolean addWorker(Worker worker) throws Exception {
        if (worker == null) {
            throw new Exception("Worker cannot be null!");
        }
        if (worker.getId() == null || worker.getId().isEmpty()) {
            throw new Exception("Worker id cannot be null or empty!");
        }
        if (worker.getAge() < 18 || worker.getAge() > 50) {
            throw new Exception("Age must be between 18 and 50!");
        }
        if (worker.getSalary() <= 0) {
            throw new Exception("Salary must be greater than 0!");
        }
        if (isIdExisted(worker.getId())) {
            throw new Exception("Id is already existed!");
        }
        return workers.add(worker);

    }

    public boolean changeSalary(SalaryHistory.SalaryStatus status, String id, double amount) throws Exception {
        if (id == null || id.isEmpty()) {
            throw new Exception("Worker id cannot be null or empty!");
        }
        if (amount <= 0) {
            throw new Exception("Amount must be greater than 0!");
        }
        Worker worker = getWorkerById(id);
        if (worker == null) {
            throw new Exception("Worker not found!");
        }
        double oldSalary = worker.getSalary();
        double newSalary;
        if (status == SalaryHistory.SalaryStatus.UP) {
            newSalary = oldSalary + amount;
        } else {
            if (oldSalary - amount < 0) {
                throw new Exception("New salary cannot be negative!");
            }
            newSalary = oldSalary - amount;
        }
        worker.setSalary(newSalary);
        SalaryHistory history = new SalaryHistory(id, oldSalary, newSalary, new Date(), status);
        salaryHistories.add(history);
        return true;
    }

    public List<SalaryHistory> getInformationSalary() {
        return salaryHistories;
    }

    public Worker getWorkerById(String id) {
        for (Worker worker : workers) {
            if (worker.getId().equals(id)) {
                return worker;
            }
        }
        return null;
    }

    private boolean isIdExisted(String id) {
        return getWorkerById(id) != null;
    }

}
