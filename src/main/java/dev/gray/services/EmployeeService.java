package dev.gray.services;

import dev.gray.building_log_models.Employee;
import dev.gray.dao.EmployeeDao;
import dev.gray.dao.EmployeeDaoImpl;

import java.util.List;



public class EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDaoImpl();

//    public void login(int id, String password) {
//        employeeDao.login(id, password);
//    }

    public List<Employee> getMasterEmployeeList(){
        return employeeDao.getMasterEmployeeList();
    }

    public Employee getEmployeeByUserId(int idInput) {
        return employeeDao.getEmployeeByUserId(idInput);
    }
}
