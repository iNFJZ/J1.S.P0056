/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import bo.WorkerInputer;
import bo.WorkerManager;
import entity.SalaryHistory;
import entity.Worker;
import java.util.List;
import utils.ValidationAndNormalizingUtil;

/**
 *
 * @author iNJZ
 */
public class WorkerManagerController {

    private WorkerManager workerManager;
    private WorkerInputer workerInputer;

    public WorkerManagerController() {
        workerManager = new WorkerManager();
        workerInputer = new WorkerInputer();
    }

    public void addWorker() throws Exception {
        Worker worker = new Worker();
        workerInputer.inputWorkerInformation(worker);
        workerManager.addWorker(worker);
    }

    public void adjustSalary(SalaryHistory.SalaryStatus status) throws Exception {
        String id = ValidationAndNormalizingUtil.getNonEmptyString("Enter Worker Id: ");
        double amount = ValidationAndNormalizingUtil.getDouble("Enter Amount Of Salary: ", "Please enter a valid number!", "Amount must be greater than 0", 0, Double.MAX_VALUE);
        workerManager.changeSalary(status, id, amount);
    }

    public List<SalaryHistory> getInformationSalary(){
        return workerManager.getInformationSalary();
    }
    
    public Worker getWorkerById(String id){
        return workerManager.getWorkerById(id);
    }
}
