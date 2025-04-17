/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ui;

import controller.WorkerManagerController;
import entity.SalaryHistory;
import entity.Worker;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import utils.ValidationAndNormalizingUtil;

/**
 *
 * @author iNJZ
 */
public class WorkerManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WorkerManagerController controller = new WorkerManagerController();
        String menu = """
                      WELCOME TO WORKER MANAGEMENT
                      1. Add Worker
                      2. Increase Salary
                      3. Decrease Salary
                      4. Show Information Salary
                      5. Exit
                      
                      (Please choose 1 to Add Worker, 2 to Increase Salary, 3 to Decrease Salary, 4 to Show Information Salary and 5 to Exit program).
                      Your choice: """;
        while (true) {
            int choice = ValidationAndNormalizingUtil.getInt(menu, "Must input an integer number!", "Must input an integer in range [1,5]", 1, 5);
            switch (choice) {
                case 1:
                    try {
                        controller.addWorker();
                        System.out.println("Add worker successfully!");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    try {
                        controller.adjustSalary(SalaryHistory.SalaryStatus.UP);
                        System.out.println("Increase salary successfully!");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    try {
                        controller.adjustSalary(SalaryHistory.SalaryStatus.DOWN);
                        System.out.println("Decrease salary successfully!");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    List<SalaryHistory> histories = controller.getInformationSalary();
                    if (histories.isEmpty()) {
                        System.out.println("No salary history!");
                    } else {
                        List<SalaryHistory> sortedHistories = new ArrayList<>(histories);
                        Collections.sort(sortedHistories, new Comparator<SalaryHistory>() {
                            @Override
                            public int compare(SalaryHistory h1, SalaryHistory h2) {
                                int codeCompare = h1.getCode().compareTo(h2.getCode());
                                if (codeCompare != 0) {
                                    return codeCompare;
                                }
                                return h1.getChangeDate().compareTo(h2.getChangeDate());
                            }
                        });

                        System.out.println("---------------------------Display Information Salary-------------------------");
                        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-15s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        for (SalaryHistory history : sortedHistories) {
                            Worker worker = controller.getWorkerById(history.getCode());
                            if (worker != null) {
                                System.out.printf("%-10s %-10s %-10d %-10.0f %-10s %-15s\n",
                                        worker.getId(),
                                        worker.getName(),
                                        worker.getAge(),
                                        history.getNewSalary(),
                                        history.getStatus(),
                                        dateFormat.format(history.getChangeDate()));
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
