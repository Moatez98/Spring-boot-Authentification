package tn.moatez.services;

import tn.moatez.dto.UserDTO;
import tn.moatez.payload.request.LoginRequest;
import tn.moatez.payload.response.LoginResponse;
import tn.moatez.payload.response.RegistreResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
    RegistreResponse registre(UserDTO request);
}
