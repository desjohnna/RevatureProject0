package dev.gray.repos;

import dev.gray.building_log_models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public class UserRepositoryImpl implements UserRepository {

    private List<Employee> users;

    public UserRepositoryImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public Employee signup(String email, String password) {
        String userId = UUID.randomUUID().toString();
        Employee user = new Employee(Integer.parseInt(userId), email, password);
        users.add(user);
        return user;

    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        Predicate<Employee> query = employee -> employee.getEmail().equalsIgnoreCase(email);
        return users.stream().filter(query).findFirst();
    }

}
