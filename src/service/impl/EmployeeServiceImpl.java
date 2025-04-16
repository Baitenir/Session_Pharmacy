package service.impl;
import db.Database;
import enums.Gender;
import enums.Position;
import generatorId.GenerateId;
import models.Employee;
import models.Pharmacy;
import service.EmployeeService;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    Scanner scannerForNum = new Scanner(System.in);
    Scanner scannerForLine = new Scanner(System.in);

    @Override
    public void addEmployee() {
        Employee employee = new Employee();
        employee.setId(GenerateId.generatorIdForEmployee());
        System.out.println("Write name:");
        employee.setFullName(scannerForLine.nextLine());
        System.out.println("Write email:");
        employee.setEmail(scannerForLine.nextLine());
        System.out.println("Write phone number:");
        employee.setPhoneNumber(scannerForLine.nextLine());
        System.out.println("Write experience:");
        while (true) {
            try {
                employee.setExperience(scannerForNum.nextDouble());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Write number!");
                scannerForNum.nextLine();
            }
        }
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Select position:");
            int c = 0;
            for (Position value : Position.values()) {
                System.out.println(++c + ". " + value);
            }
            try {
                switch (scannerForNum.nextInt()) {
                    case 1: employee.setPosition(Position.ADMIN); isTrue = false; break;
                    case 2: employee.setPosition(Position.PHARMACIST); isTrue = false; break;
                    case 3: employee.setPosition(Position.TELLER); isTrue = false; break;
                    default: System.out.println("Invalid choice! Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please choice correct value! (1,2,3) ");
                scannerForNum.nextLine();
            }
        }
        boolean isTrue2 = true;
        while (isTrue2) {
            System.out.println("Select gender:");
            System.out.println("1. Male\n2. Female");
            try {
                switch (scannerForNum.nextInt()) {
                    case 1: employee.setGender(Gender.MALE); isTrue2 = false; break;
                    case 2: employee.setGender(Gender.FEMALE); isTrue2 = false; break;
                    default: System.out.println("Invalid choice, try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("(Please write number 1/2) ");
                scannerForNum.nextLine();
            }
        }
        Database.employees.add(employee);
        System.out.println("New employee added!");
    }

    @Override
    public Employee getEmployeeById() {
        System.out.println("Write employee id: ");
        long employeeId = -1;
        while (true) {
            try {
                employeeId = scannerForNum.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Write id!");
                scannerForNum.nextLine();
            }
        }
            for (Employee employee : Database.employees) {
                if (employee.getId() == employeeId) {
                    return employee;
                }
            }
        System.out.println("Employee not founded!");
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return Database.employees;
    }

    @Override
    public Employee updateEmployeeById() {
        System.out.println("Write employee id:");
        long employeeId = -1;
        while (true) {
            try {
                employeeId = scannerForNum.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Write number!");
                scannerForNum.nextLine();
            }
        }
        for (Employee employee : Database.employees) {
            if (employee.getId() == employeeId){
                    System.out.println("Write name:");
                    employee.setFullName(scannerForLine.nextLine());
                    System.out.println("Write phone number:");
                    employee.setPhoneNumber(scannerForLine.nextLine());
                    System.out.println("Write email:");
                    employee.setEmail(scannerForLine.nextLine());
                    System.out.println("Select position:");
                    boolean isTrue = true;
                    while (isTrue) {
                        int c = 0;
                        for (Position value : Position.values()) {
                            System.out.println(++c + ". " +value);
                        }
                        try {
                            switch (scannerForNum.nextInt()) {
                                case 1:
                                    employee.setPosition(Position.ADMIN);
                                    isTrue = false;
                                    break;
                                case 2:
                                    employee.setPosition(Position.PHARMACIST);
                                    isTrue = false;
                                    break;
                                case 3:
                                    employee.setPosition(Position.TELLER);
                                    isTrue = false;
                                    break;
                                default:
                                    System.out.println("Invalid choice! Try again!");
                            }
                        } catch (InputMismatchException e){
                            System.err.println("Write number please!");
                            scannerForNum.nextLine();
                        }
                    }
                    while (true) {
                        System.out.println("Write experience:");
                        try {
                            employee.setExperience(scannerForNum.nextDouble());
                            System.out.println("Successfully updated!");
                            return employee;
                        } catch (InputMismatchException e){
                            System.out.println("Write number!");
                            scannerForNum.nextLine();
                        }
                    }
            }
        }
        System.out.println("Employee not founded!");
        return null;
    }

    @Override
    public void deleteEmployeeById() {
        System.out.println("Write id:");
        long emplId = -1;
        int c =0;
        boolean isTrue = true;
        while (isTrue) {
            try {
                emplId = scannerForNum.nextLong();
                isTrue = false;
            } catch (InputMismatchException e) {
                System.out.println("Write number!");
                scannerForNum.nextLine();
            }
        }
        for (Employee employee : Database.employees) {
            if (employee.getId() == emplId){
                Database.employees.remove(employee);
                System.out.println("Successfully deleted!");
                c++;
                break;
            }
        }
        if (c == 0) {
            System.out.println("Employee not founded!");
        }
    }

    @Override
    public void assignEmployeeToPharmacy() {
        Employee employee = getEmployeeById();
        if (employee != null){
            Database.pharmacy.setEmployees(new ArrayList<>(List.of(employee)));
            System.out.println("Successfully assigned!");
        } else {
            System.out.println("Check database!");
        }

    }
}
