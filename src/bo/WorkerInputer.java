/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Worker;
import utils.ValidationAndNormalizingUtil;

/**
 *
 * @author iNJZ
 */
public class WorkerInputer {
    
    public void inputWorkerInformation(Worker worker) {
        worker.setId(ValidationAndNormalizingUtil.getNonEmptyString("Enter Worker Id: "));
        worker.setName(ValidationAndNormalizingUtil.getStringByRegex("Enter Worker Name: ", "Please enter character only!", "[A-Za-z ]+"));
        worker.setAge(ValidationAndNormalizingUtil.getInt("Enter Age: ", "Please enter a valid number!", "Age must be between 18 and 50!", 18, 50));
        worker.setSalary(ValidationAndNormalizingUtil.getDouble("Enter Worker Salary: ", "Please enter a valid number!", "Salary must be greater than 0!", 0, Double.MAX_VALUE));
        worker.setWorkLocation(ValidationAndNormalizingUtil.getNonEmptyString("Enter Worker Work Location: "));
    }
}
