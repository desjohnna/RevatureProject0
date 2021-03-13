package dev.gray.data;

import dev.gray.building_log_models.BuildingLog;
import dev.gray.util.ConnectionUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BuildingLogData {

    private List<BuildingLog> log = new ArrayList<>();


    public BuildingLogData() {
        super();

//        log.add(new BuildingLog(9209, 527727, "17122020", 506, "Anabal", "Andreas"));
//        log.add(new BuildingLog(30246, 124787, "09022021", 959, "Janot", "Penhallurick"));
//        log.add(new BuildingLog(9, 974727, "03082020", 442, "Tiebold", "Peattie"));
//        log.add(new BuildingLog(6871, 771787, "17072020", 848, "Job", "Edmons"));
//        log.add(new BuildingLog(90331, 100777, "25122020", 1502, "Lori", "Sims"));
    }


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
        return null;
    }


    public BuildingLog addNewLog(BuildingLog newLog) {
        log.add(newLog);
        return newLog;
    }

    public void deleteLog(int logEntryId) {
        log.removeIf(buildingLog -> buildingLog != null && logEntryId == buildingLog.getLogEntryId());
    }

    public List<BuildingLog> findLogByUserId(int id) {


//     RETURNING A STREAM THAT FILTERS AND ADDS TO A LIST
        return (log.stream()
//     FILTERING THE BUILDING LOG OBJECTS FOR ID THAT MATCH THE PASSED IN ID
                .filter(log1 -> log1.getUserId() == id)
//     COLLECTING THE LOGS THAT MATCH TO THE LIST CREATED
                .collect(Collectors.toList()));


    }

}
