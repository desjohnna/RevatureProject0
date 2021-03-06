package dev.gray.controllers;

import dev.gray.services.LoginService;
import dev.gray.token.AuthRequest;
import dev.gray.token.AuthResponse;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.Context;
import io.javalin.http.ForbiddenResponse;
import me.geso.tinyvalidator.ConstraintViolation;
import me.geso.tinyvalidator.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class UserController {

    private LoginService service;

    public UserController() {
        super();
    }

    public UserController(LoginService service) {
        this.service = service;
    }

    public void login(Context context) {
        Validator validator = new Validator();
        AuthRequest request = context.bodyAsClass(AuthRequest.class);
        List<ConstraintViolation> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            String message = violations.stream()
                    .map(v -> v.getName().concat(": ").concat(v.getMessage()))
                    .collect(Collectors.joining(", "));
            throw new BadRequestResponse(message);
        }
        AuthResponse result = service.login(request);
        context.json(result);
    }

//    public void login(Context context) {
//        Validator validator = new Validator();
//        AuthRequest request = context.bodyAsClass(AuthRequest.class);
//        List<ConstraintViolation> violations = validator.validate(request);
//        if (!violations.isEmpty()) {
//            String message = violations.stream()
//                    .map(v -> v.getName().concat(": ").concat(v.getMessage()))
//                    .collect(Collectors.joining(", "));
//            throw new BadRequestResponse(message);
//        }
//        AuthResponse result = LoginService.login(request);
//        context.json(result);
//
//    }

//    public void signup (Context context){
//        AuthRequest request = context.bodyAsClass(AuthRequest.class);
//        Validator validator = new Validator();
//        List<ConstraintViolation> violations = validator.validate(request);
//        if (!violations.isEmpty()) {
//            String message = violations.stream()
//                    .map(v -> v.getName().concat(": ").concat(v.getMessage()))
//                    .collect(Collectors.joining(", "));
//            throw new BadRequestResponse(message);
//        }
//        AuthResponse result = service.signup(request);
//        context.json(result);
//    }

    public void authorize (Context context){
        String token = context.header("Authorization");
        String userId = context.header("X-User-ID");
        if (token == null){
            throw new ForbiddenResponse();
        }
        boolean result = service.authorize(token, userId);
        if (!result){
            throw new ForbiddenResponse();
        }
    }
}
