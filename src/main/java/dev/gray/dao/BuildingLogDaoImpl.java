package dev.gray.dao;

import dev.gray.building_log_models.BuildingLog;
import dev.gray.util.ConnectionUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuildingLogDaoImpl implements BuildingLogDao {
    @Override
    public BuildingLog addNewLog(BuildingLog newLog) {
        return null;
    }


//    WORKING
    @Override
    public List<BuildingLog> getMasterBuildingLog() {

//        Creating a list to add all logs to
        List<BuildingLog> logs = new ArrayList<>();

        try (Connection connection = ConnectionUtility.getConnection()) {

//            Creating a statement object
            Statement statement = connection.createStatement();

//          Creating a ResultSet to hold all statements that come back from query
//            ResultSet resultSet = statement.executeQuery("select * from building_log");
            ResultSet resultSet = statement.executeQuery("select e.user_id,b.log_entry_id, b.log_date, b.log_time, b.first_name, b.last_name from employee e, building_log b where e.user_id = b.user_id" );


            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                int logEntryId = resultSet.getInt("log_entry_id");
                int logDate = resultSet.getInt("log_date");
                int logTime = resultSet.getInt("log_time");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                BuildingLog buildingLog = new BuildingLog(logEntryId, userId, logDate, logTime, firstName, lastName);
                logs.add(buildingLog);

            }
        } catch (SQLException e) {
//            log here
        }
        return logs;
    }

    @Override
    public List<BuildingLog> getLogsByEntryId(int id) {
        return new ArrayList<>();
    }

    @Override
    public void deleteLog(int id) {
//will add delete later
    }

    @Override
    public List<BuildingLog> findLogByUserId(int id) {
        return new ArrayList<>();
    }
}
