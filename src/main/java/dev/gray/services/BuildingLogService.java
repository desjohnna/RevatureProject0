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

    public BuildingLog getLogByEntryId(int id) {
        return buildingLogDao.getLogsByEntryId(id);
    }

    public List<BuildingLog> getLogsByUserId(int id) {
        return buildingLogDao.getLogsByUserId(id);
    }

}

