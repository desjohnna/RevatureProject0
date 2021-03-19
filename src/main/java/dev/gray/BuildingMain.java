package dev.gray;

import dev.gray.controllers.BuildingLogController;
import dev.gray.controllers.EmployeeController;
import dev.gray.controllers.UserController;
import dev.gray.repos.UserRepository;
import dev.gray.repos.UserRepositoryImpl;
import dev.gray.services.LoginService;
import dev.gray.services.LoginServiceImpl;
import dev.gray.token.Token;
import dev.gray.token.TokenManager;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class BuildingMain {


    public static void main(String[] args) {


//      CREATING JAVALIN APP TO RUN ON LOCALHOST:7000
        Javalin app = Javalin.create().start(7000);

//      Creating Controllers, Repos and Services to call in routes
        BuildingLogController buildingLogController = new BuildingLogController();
        EmployeeController employeeController = new EmployeeController();
        UserRepository userRepository = new UserRepositoryImpl();
        TokenManager manager = new Token();
        LoginService loginService = new LoginServiceImpl(userRepository, manager);
        UserController userController = new UserController(loginService);


//       Building Log Routes
        app.routes(() ->
                path("/log", () -> {
                    get(buildingLogController::handleGetMasterBuildingLog);
                    post(buildingLogController::handleAddNewLog);
                    path(":id", () -> {
                        get(buildingLogController::handleGetLogsByEntryId);
                        delete(buildingLogController::handleDeleteLog);
                        put(buildingLogController::handleGetLogsByUserId);
                    });

                }));

//        Login Routes
        app.post("/login", userController::login);

//        Employee Routes
        app.routes(() ->
                path("employee", () -> {
                    get(employeeController::getMasterEmployeeList);
                    path(":id", () -> {
                        get(employeeController::getEmployeeByUserId);
                    });
                }));
    }
}

