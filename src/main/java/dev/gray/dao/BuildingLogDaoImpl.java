package dev.gray.dao;

import dev.gray.building_log_models.BuildingLog;
import dev.gray.util.ConnectionUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuildingLogDaoImpl implements BuildingLogDao {
    @Override
    public BuildingLog addNewLog(BuildingLog newLog) {
        return null;
    }

    @Override
    public List<BuildingLog> getMasterBuildingLog() {
        List<BuildingLog> logs = new ArrayList<>();

        try (Connection connection = ConnectionUtility.getConnection()) {
            Statement preparedStatement = connection.createStatement();
            ResultSet resultSet = preparedStatement.executeQuery("select employee.user_id,building_log.log_entry_id, building_log.log_date, building_log.log_time, building_log.first_name, building_log.last_name\n" +
                    "from employee\n" +
                    "join building_log on building_log.user_id=employee.user_id;");


            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                int logEntryId = resultSet.getInt("log_entry_id");
                int logDate = resultSet.getInt("log_date");
                int logTime = resultSet.getInt("log_time");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                BuildingLog buildingLog = new BuildingLog(logEntryId, userId, logDate, logTime, firstName, lastName);
                logs.add(buildingLog);
                return logs;
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
