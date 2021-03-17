package dev.gray.dao;

import dev.gray.building_log_models.Employee;

public interface EmployeeDao {

    public void login(int id, String password);

    public Employee getEmployeeByUserId(int userId);



}
