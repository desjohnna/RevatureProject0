package dev.gray.token;

public interface TokenManager {


    String issueToken (String userId);

    boolean authorize (String token, String userId);
}
