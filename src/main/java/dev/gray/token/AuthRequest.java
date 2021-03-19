package dev.gray.token;

import me.geso.tinyvalidator.constraints.Email;
import me.geso.tinyvalidator.constraints.Size;

public class AuthRequest {

    @Email
    private String email;

    @Size(min = 6)
    private String password;

    public AuthRequest() {
        super();
    }

    public AuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
