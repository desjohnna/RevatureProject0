package dev.gray.dao;

import dev.gray.building_log_models.BuildingLog;
import dev.gray.building_log_models.Employee;
import dev.gray.util.ConnectionUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class EmployeeDaoImpl implements EmployeeDao {

    private Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
//    private List<Employee> employeeList;

    //    @Override
//    public void login(int id, String password) {
//        try (Connection connection = ConnectionUtility.getConnection()) {
//            PreparedStatement preparedStatement = connection.prepareStatement("select user_id, user_password from employee where user_id=?");
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                int userId = resultSet.getInt("user_id");
//                String userPassword = resultSet.getString("password");
//            }
//        } catch (SQLException e) {
////            log
//        }
//    }
    @Override
    public List<Employee> getMasterEmployeeList() {
        //        Creating a list to add employees to
        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = ConnectionUtility.getConnection()) {

//            Creating a statement object
            Statement statement = connection.createStatement();

//          Creating a ResultSet to hold results from query
            ResultSet resultSet = statement.executeQuery("select * from employee");

            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");

                Employee employee = new Employee(userId, firstName, lastName, email);
                employeeList.add(employee);

            }
        } catch (SQLException e) {
//           //        Add logic if statement logic for Admin access only, throw exception 403 FORBIDDEN
//            log
        }
        return employeeList;
    }

    @Override
    public Employee getEmployeeByUserId(int userIdInput) {

        try (Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select user_id, first_name, last_name, email from employee where user_id = ?");
            preparedStatement.setInt(1, userIdInput);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");

                Employee employee = new Employee(userId, firstName, lastName, email);

                return employee;
            }
        } catch (SQLException e) {
            logger.error("SQL Exception while trying to implement getEmployeeByUserId");
        }
        logger.info("Successfully returning Employee matching Id");

        return null;
    }

}


