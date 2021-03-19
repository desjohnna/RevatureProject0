package dev.gray.dao;

import dev.gray.building_log_models.Employee;

import java.util.List;

public interface EmployeeDao {

    Employee getEmployeeByUserId(int userId);

    List<Employee> getMasterEmployeeList();

    void login(int userId, String password);

}
