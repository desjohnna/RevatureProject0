package dev.gray.dao;

import dev.gray.building_log_models.BuildingLog;
import dev.gray.util.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

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



}
