package dev.gray.controllers;


import dev.gray.building_log_models.Employee;
import dev.gray.services.EmployeeService;
import dev.gray.services.LoginService;

import io.javalin.http.Context;
import io.javalin.http.UnauthorizedResponse;


public class EmployeeController {

    private EmployeeService employeeService = new EmployeeService();


    public void login(Context ctx) {

        String userIdInput = ctx.formParam("username");
        String passwordInput = ctx.formParam("password");
//        String admin = ctx.queryParam("admin");

        if (userIdInput != null && userIdInput.equals("username")) {
            if (passwordInput != null && passwordInput.equals("password")) {

                ctx.header("Authorization", "admin-auth-token");
                ctx.status(200);
                return;

            }
            throw new UnauthorizedResponse("Please enter correct Username and Password");
        }
    }

    public void getEmployeeByUserId(Context ctx) {
        String userIdString = ctx.pathParam("id");

        int idInput = Integer.parseInt(userIdString);

        Employee employee = employeeService.getEmployeeByUserId(idInput);
        ctx.json(employee);
        ctx.status(200);

    }

    public void getMasterEmployeeList(Context ctx) {
        ctx.json(employeeService.getMasterEmployeeList());
    }


}
