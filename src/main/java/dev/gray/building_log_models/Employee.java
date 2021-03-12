package dev.gray.building_log_models;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Employee implements Serializable {

    private Integer userId;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean admin;

    private Set<BuildingLog> buildingLogSet;

    public Employee(){
        super();
    }

    public Employee(Integer userId, String password, String firstName, String lastName, Boolean admin) {
        this.userId = userId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = admin;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<BuildingLog> getBuildingLogSet() {
        return buildingLogSet;
    }

    public void setBuildingLog(Set<BuildingLog> buildingLog) {
        this.buildingLogSet = buildingLog;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return userId.equals(employee.userId) && password.equals(employee.password) && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && admin.equals(employee.admin) && Objects.equals(buildingLogSet, employee.buildingLogSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, password, firstName, lastName, admin, buildingLogSet);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", admin=" + admin +
                ", buildingLogSet=" + buildingLogSet +
                '}';
    }
}
