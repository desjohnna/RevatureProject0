package dev.gray.controllers;

import dev.gray.building_log_models.BuildingLog;
import dev.gray.services.BuildingLogService;
import io.javalin.http.Context;


import java.util.List;


public class BuildingLogController {

    private final BuildingLogService buildingLogService = new BuildingLogService();

    public BuildingLogController() {
        super();
    }

    public void handleGetAllLogs(Context ctx) {
//        Add logic if statement logic for Admin access only, throw exception 403 FORBIDDEN
        ctx.json(buildingLogService.getMasterBuildingLog());
    }


    public void handleAddNewLog(Context ctx) {
//    Add logic to allow access during specific times of day only if/else throw IllegalArgumentException
        BuildingLog log = ctx.bodyAsClass(BuildingLog.class);
        ctx.json(buildingLogService.addNewLog(log));
        ctx.status(201);
    }

    public void handleDeleteLog(Context ctx) {
//        Declaring and Parsing the String id into an int
        String idString = ctx.pathParam("id");
        int idInput = Integer.parseInt(idString);
        buildingLogService.deleteLog(idInput);
//            Send GONE status to confirm deletion
        ctx.status(410);
    }


    public void handleFindLogByUserId(Context ctx) {
//      CREATING A VARIABLE TO HOLD THE PATH PARAMETER ID IN
        String idString = ctx.pathParam("id");
//      PARSING ID FROM A STRING TO AN INT
        int idInput = Integer.parseInt(idString);
//      CREATING A LIST TO PUT THE LOGS MATCHING THE USER ID IN
        List<BuildingLog> userLog = buildingLogService.findLogByUserId(idInput);
//      DISPLAYING THE LIST OF LOGS IN JSON FORMAT
        ctx.json(userLog);
    }
}
