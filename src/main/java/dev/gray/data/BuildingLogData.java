package dev.gray.data;

import dev.gray.building_log_models.BuildingLog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BuildingLogData {

    private List<BuildingLog> log = new ArrayList<>();


    public BuildingLogData() {
        super();

        log.add(new BuildingLog(9209, 527727, "17122020", 506, "Anabal", "Andreas"));
        log.add(new BuildingLog(30246, 124787, "09022021", 959, "Janot", "Penhallurick"));
        log.add(new BuildingLog(9, 974727, "03082020", 442, "Tiebold", "Peattie"));
        log.add(new BuildingLog(6871, 771787, "17072020", 848, "Job", "Edmons"));
        log.add(new BuildingLog(90331, 100777, "25122020", 1502, "Lori", "Sims"));


    }


    public List<BuildingLog> getMasterBuildingLog() {
        return new ArrayList<>(log);
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
