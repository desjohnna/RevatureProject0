package dev.gray.data;

import dev.gray.building_log_models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {

    private List<Employee> employeeList = new ArrayList<>();


    public EmployeeData(){
        super();

        employeeList.add(new Employee(4538,"1fY1fQqztn","Randy","Mosdall",true));
        employeeList.add(new Employee(9096,"nUzgPpWqN","Aubert","Headly",false));
        employeeList.add(new Employee(131,"muRxsa8","Andros","Jellyman",false));
        employeeList.add(new Employee(160,"FOLWQWGiKL","Drusilla","Carff",false));
        employeeList.add(new Employee(33079,"C5qAElGidUnF","Vanna","Janout",true));
    }


}
