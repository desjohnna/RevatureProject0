package dev.gray.controllers;

import dev.gray.building_log_models.BuildingLog;
import dev.gray.data.BuildingLogData;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class BuildingController {

    private final BuildingLogData data = new BuildingLogData();

    public void handleGetAllLogs(@NotNull Context ctx) {
//        Add logic if statement logic for Admin access only, throw exception 403 FORBIDDEN
        ctx.json(data.getMasterBuildingLog());
    }

    public void handleAddNewLog(@NotNull Context ctx) {

//    Add logic to allow access during specific times of day only if/else throw IllegalArgumentException
        BuildingLog log = ctx.bodyAsClass(BuildingLog.class);
        ctx.json(data.addNewLog(log));
        ctx.status(201);
    }

    public void handleDeleteLog(@NotNull Context ctx) {
        String idString = ctx.pathParam("id");
        {
            int idInput = Integer.parseInt(idString);

            data.deleteLog(idInput);

//            Send GONE status to confirm deletion
            ctx.status(410);
        }
    }

    public void handleFindLogByUserId(Context ctx) {

//      CREATING A VARIABLE TO HOLD THE PATH PARAMETER ID IN
        String idString = ctx.pathParam("id");

//      PARSING ID FROM A STRING TO AN INT
        int idInput = Integer.parseInt(idString);

//      CREATING A LIST TO PUT THE LOGS MATCHING THE USER ID IN
        List<BuildingLog> userLog = data.findLogByUserId(idInput);

//      DISPLAYING THE LIST OF LOGS IN JSON FORMAT
        ctx.json(userLog);
    }


}
