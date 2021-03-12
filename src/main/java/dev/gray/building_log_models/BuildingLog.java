package dev.gray.building_log_models;

import java.io.Serializable;
import java.util.Objects;

public class BuildingLog implements Serializable {


    private Integer logEntryId;
    private Integer userId;
    private String logDate;
    private Integer logTime;
    private String firstName;
    private String lastName;

    public BuildingLog(){
        super();
    }

    public BuildingLog(Integer logEntryId, Integer userId, String logDate, Integer logTime, String firstName, String lastName) {
        this.logEntryId = logEntryId;
        this.userId = userId;
        this.logDate = logDate;
        this.logTime = logTime;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getLogEntryId() {
        return logEntryId;
    }

    public void setLogEntryId(Integer logEntryId) {
        this.logEntryId = logEntryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public Integer getLogTime() {
        return logTime;
    }

    public void setLogTime(Integer logTime) {
        this.logTime = logTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildingLog that = (BuildingLog) o;
        return logEntryId.equals(that.logEntryId) && userId.equals(that.userId) && logDate.equals(that.logDate) && logTime.equals(that.logTime) && firstName.equals(that.firstName) && lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logEntryId, userId, logDate, logTime, firstName, lastName);
    }

    @Override
    public String toString() {
        return "BuildingLog{" +
                "logEntryId=" + logEntryId +
                ", userId=" + userId +
                ", logDate='" + logDate + '\'' +
                ", logTime=" + logTime +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
