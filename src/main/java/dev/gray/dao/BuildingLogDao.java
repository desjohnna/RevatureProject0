package dev.gray.dao;

import dev.gray.building_log_models.BuildingLog;
import java.util.List;

public interface BuildingLogDao {


    BuildingLog addNewLog(BuildingLog newLog);
//    get list of employee

    //Admin Only Methods
    List<BuildingLog> getMasterBuildingLog();

    BuildingLog getLogsByEntryId(int id);

    void deleteLog(int id);

    List<BuildingLog> findLogByUserId(int id);
//    get employee by user id
//    create new employee
//    delete employee
//    update employee


}
