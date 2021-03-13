package dev.gray.dao;

import dev.gray.building_log_models.BuildingLog;

import java.util.ArrayList;
import java.util.List;

public class BuildingLogData implements BuildingLogDao {

    private List<BuildingLog> logs = new ArrayList<>();



    @Override
    public BuildingLog addNewLog(BuildingLog newLog) {
        return null;
    }

    @Override
    public List<BuildingLog> getMasterBuildingLog() {
        return new ArrayList<>(logs);
    }

    @Override
    public List<BuildingLog> getLogsByEntryId(int id) {
        return null;
    }

    @Override
    public void deleteLog(int id) {

    }

    @Override
    public List<BuildingLog> findLogByUserId(int id) {
        return null;
    }
}
