package dev.gray.services;

import dev.gray.dao.EmployeeDao;
import dev.gray.dao.EmployeeDaoImpl;



public class EmployeeService {

private EmployeeDao employeeDao = new EmployeeDaoImpl();

public void login(int id, String password){
    employeeDao.login(id,password);
}


}
