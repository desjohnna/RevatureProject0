package dev.gray.dao;

import dev.gray.building_log_models.BuildingLog;
import dev.gray.building_log_models.Employee;
import dev.gray.util.ConnectionUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    @Override
    public void login(int id, String password) {
        try (Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select user_id, user_password from employee where user_id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String userPassword = resultSet.getString("password");
            }
        } catch (SQLException e) {
//            log
        }
    }

    public List<BuildingLog> ViewOnlyLogsFromId(int userId) {
        return null;

    }

    public Employee getEmployeeByUserId(int userIdInput) {
        Employee employee = new Employee();
        try (Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select user_id, first_name, last_name from employee where user_id = ?");
            preparedStatement.setInt(1, userIdInput);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");

                employee.setUserId(userId);
                employee.setFirstName(firstName);
                employee.setLastName(lastName);


            }
        } catch (SQLException e) {
            logger.error("SQL Exception while trying to implement getEmployeeById");
        }
        logger.info("Successfully returning Employee matching Id");

employee = new Employee(employee.getUserId(), employee.getFirstName(), employee.getLastName());
return employee;
    }
}


