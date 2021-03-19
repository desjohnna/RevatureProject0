package dev.gray.dao;

import dev.gray.building_log_models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

    Employee getEmployeeByUserId(int userId);

    public List<Employee> getMasterEmployeeList();

}
