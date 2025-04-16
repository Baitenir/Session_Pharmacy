package service;

import models.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee();
    Employee getEmployeeById();
    List<Employee> getAllEmployees();
    Employee updateEmployeeById ();
    void deleteEmployeeById();
    void assignEmployeeToPharmacy();
}
