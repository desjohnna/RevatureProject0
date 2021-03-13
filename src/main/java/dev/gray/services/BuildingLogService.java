package dev.gray.services;

import dev.gray.building_log_models.BuildingLog;
import dev.gray.dao.BuildingLogDao;
import dev.gray.dao.BuildingLogDaoImpl;

import java.util.List;

public class BuildingLogService {

    private final BuildingLogDao buildingLogDao = new BuildingLogDaoImpl();

    public List<BuildingLog> getMasterBuildingLog() {
        return buildingLogDao.getMasterBuildingLog();
    }

    public BuildingLog addNewLog(BuildingLog newLog) {
        return buildingLogDao.addNewLog(newLog);
    }

    public void deleteLog(int logEntryId) {
        buildingLogDao.deleteLog(logEntryId);
    }

    public List<BuildingLog> findLogByUserId(int id) {
        return buildingLogDao.findLogByUserId(id);
    }
//     RETURNING A STREAM THAT FILTERS AND ADDS TO A LIST
//            return (log.stream()
////     FILTERING THE BUILDING LOG OBJECTS FOR ID THAT MATCH THE PASSED IN ID
//                    .filter(log1 -> log1.getUserId() == id)
////     COLLECTING THE LOGS THAT MATCH TO THE LIST CREATED
//                    .collect(Collectors.toList()));

}

