package dev.gray.services;

import dev.gray.token.AuthRequest;
import dev.gray.token.AuthResponse;

public interface LoginService {

    AuthResponse signup(AuthRequest request);

    AuthResponse login(AuthRequest request);

    boolean authorize(String token, String userId);
}
