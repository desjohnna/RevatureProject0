package dev.gray.controllers;

import io.javalin.http.Context;
import io.javalin.http.UnauthorizedResponse;


public class EmployeeController {

    public void employeeLogin(Context ctx) {

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


}
