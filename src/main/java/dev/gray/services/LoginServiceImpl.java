package dev.gray.services;

import dev.gray.building_log_models.Employee;

import dev.gray.repos.UserRepository;
import dev.gray.token.AuthRequest;
import dev.gray.token.AuthResponse;

import dev.gray.token.TokenManager;
import io.javalin.http.ForbiddenResponse;

import java.util.Optional;

public class LoginServiceImpl implements LoginService {
    private UserRepository userRepository;
    private TokenManager manager;

    public LoginServiceImpl(UserRepository userRepository, TokenManager manager) {
        this.userRepository = userRepository;
        this.manager = manager;
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();
        Optional<Employee> result = userRepository.findByEmail(email);
        if (result.isPresent()) {
            Employee employee = result.get();
            String passwordInDatabase = employee.getPassword();
            if (password.equalsIgnoreCase(passwordInDatabase)) {

                int userId = employee.getUserId();

                String token = manager.issueToken(Integer.toString(userId));

                AuthResponse response = new AuthResponse(Integer.toString(userId), token);
                return response;
            } else {
                throw new ForbiddenResponse();
            }
        } else {
            throw new ForbiddenResponse();
        }
    }


    public boolean authorize(String token, String userId) {
        boolean result = manager.authorize(token, userId);
        return result;
    }

    @Override
    public AuthResponse signup(AuthRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();
        Employee user = userRepository.signup(email, password);
        Integer userId = user.getUserId();
        String token = manager.issueToken(Integer.toString(userId));
        AuthResponse response = new AuthResponse(Integer.toString(userId), token);
        return response;
    }

}



