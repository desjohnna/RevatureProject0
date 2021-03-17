package dev.gray.dao;

import dev.gray.building_log_models.BuildingLog;
import dev.gray.util.ConnectionUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BuildingLogDaoImpl implements BuildingLogDao {
    private Logger logger = LoggerFactory.getLogger(BuildingLogDaoImpl.class);

    //    WORKING
    @Override
    public BuildingLog addNewLog(BuildingLog newLog) {
        try (Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into building_log (user_id, log_date, log_time, first_name, last_name) values (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, newLog.getUserId());
            preparedStatement.setInt(2, newLog.getLogDate());
            preparedStatement.setInt(3, newLog.getLogTime());
            preparedStatement.setString(4, newLog.getFirstName());
            preparedStatement.setString(5, newLog.getLastName());
            preparedStatement.executeUpdate();
            logger.info("successfully added new item to the db");
        } catch (SQLException e) {
            logger.error(e.getClass() + " " + e.getMessage());
        }
        return newLog;

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
            ResultSet resultSet = statement.executeQuery("select * from building_master_log");

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
//           //        Add logic if statement logic for Admin access only, throw exception 403 FORBIDDEN
//            log
        }
        return logs;
    }

    //  WORKING
    @Override
    public BuildingLog getLogsByEntryId(int entryId) {

        try (Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from building_master_log where log_entry_id = ?");
            preparedStatement.setInt(1, entryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                int logEntryId = resultSet.getInt("log_entry_id");
                int logDate = resultSet.getInt("log_date");
                int logTime = resultSet.getInt("log_time");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                BuildingLog buildingLog = new BuildingLog(logEntryId, userId, logDate, logTime, firstName, lastName);
                logger.info("Successfully returning log matching Entry Id");
                return buildingLog;
            }
        } catch (SQLException e) {
            logger.error("SQL Exception while trying to implement getLogsById");
        }
        logger.warn("No such matching Id returning null");
        return null;

    }

    //      WORKING
    @Override
    public void deleteLog(int entryId) {
        try (Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from building_log where log_entry_id = ?");
            preparedStatement.setInt(1, entryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                int logEntryId = resultSet.getInt("log_entry_id");
                int logDate = resultSet.getInt("log_date");
                int logTime = resultSet.getInt("log_time");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                logger.info("Successfully deleted log matching Entry Id");
                return;
            }
        } catch (SQLException e) {
            logger.error("SQL Exception while trying to implement getLogsById");
        }
        logger.warn("No such matching Entry Id returning null");
        return;


    }

    //    WORKING
    @Override
    public List<BuildingLog> getLogsByUserId(int id) {

        List<BuildingLog> logsById = new ArrayList<>();

        try (Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from building_master_log where user_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                int logEntryId = resultSet.getInt("log_entry_id");
                int logDate = resultSet.getInt("log_date");
                int logTime = resultSet.getInt("log_time");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                BuildingLog buildingLog = new BuildingLog(logEntryId, userId, logDate, logTime, firstName, lastName);
                logsById.add(buildingLog);


            }
        } catch (SQLException e) {
            logger.error("SQL Exception while trying to implement getLogsById");
        }
        logger.info("Successfully returning all logs matching Id");
        return logsById;
    }
}
