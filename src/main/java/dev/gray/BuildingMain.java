package dev.gray;

import dev.gray.controllers.BuildingController;
import dev.gray.controllers.EmployeeController;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class BuildingMain {


    public static void main(String[] args) {
//      CREATING JAVALIN APP TO RUN ON LOCALHOST:7000 AND DISPLAY WELCOME
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Welcome to the Building Log"));

//      CREATING A CONTROLLER
        BuildingController buildingController = new BuildingController();
        EmployeeController employeeController = new EmployeeController();


//        TRYING OUT HANDLER GROUPS
        app.routes(() -> path("/log", () -> {
            get(buildingController::handleGetAllLogs);
            post(buildingController::handleAddNewLog);
            path(":id", () -> {
                get(buildingController::handleFindLogByUserId);
                delete(buildingController::handleDeleteLog);
            });
        }));

    }
}

