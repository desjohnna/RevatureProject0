package dev.gray.building_log_models;

import java.io.Serializable;
import java.util.Objects;


public class Employee implements Serializable {

    private Integer userId;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean admin;
    private String email;

    public Employee() {
        super();
    }


    public Employee(Integer userId, String password, String email) {
        this.userId = userId;
        this.password = password;
        this.email = email;
    }

    public Employee(Integer userId, String firstName, String lastName, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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


    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return userId.equals(employee.userId) && password.equals(employee.password) && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && admin.equals(employee.admin) && email.equals(employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, password, firstName, lastName, admin, email);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", admin=" + admin +
                ", email=" + email +
                '}';
    }



}
