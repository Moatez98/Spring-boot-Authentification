package tn.moatez.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.moatez.dto.UserDTO;
import tn.moatez.payload.request.LoginRequest;
import tn.moatez.payload.response.LoginResponse;
import tn.moatez.payload.response.RegistreResponse;
import tn.moatez.repository.AccountRepository;
import tn.moatez.services.AuthService;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final AccountRepository accountRepository;

    public AuthController(AuthService authService, AccountRepository accountRepository) {
        this.authService = authService;
        this.accountRepository = accountRepository;
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(request));
    }
    @PostMapping("/registre")
    public ResponseEntity<RegistreResponse> login(@Valid @RequestBody UserDTO request){
        if(accountRepository.existsByEmail(request.getAccountDTO().getEmail())){
            return ResponseEntity.badRequest().body(new RegistreResponse("Error: Username is already taken!"));
        }
        if(accountRepository.existsByUsername(request.getAccountDTO().getEmail())){
            return ResponseEntity.badRequest().body(new RegistreResponse("Error: Email is already taken!"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(authService.registre(request));
    }
}
