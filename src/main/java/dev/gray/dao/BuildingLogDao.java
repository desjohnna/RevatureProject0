package dev.gray.dao;

import dev.gray.building_log_models.BuildingLog;

import java.util.List;

public interface BuildingLogDao {


    BuildingLog addNewLog(BuildingLog newLog);

    //Admin Only Methods
    List<BuildingLog> getMasterBuildingLog();

    List<BuildingLog> getLogsByEntryId(int id);

    void deleteLog(int id);

    List<BuildingLog> findLogByUserId(int id);

}
