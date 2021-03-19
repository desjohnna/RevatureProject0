package dev.gray.repos;

import dev.gray.building_log_models.Employee;

import java.util.Optional;



public interface UserRepository {

    Employee signup (String email, String password);

    Optional<Employee> findByEmail (String email);

}
