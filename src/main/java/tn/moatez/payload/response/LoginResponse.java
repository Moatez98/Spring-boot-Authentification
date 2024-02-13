package tn.moatez.payload.response;

import lombok.*;


@Getter
@Setter
public class LoginResponse {
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public LoginResponse() {
    }
}
