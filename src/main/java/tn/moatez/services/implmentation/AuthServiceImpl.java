package tn.moatez.services.implmentation;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.moatez.dto.UserDTO;
import tn.moatez.model.Role;
import tn.moatez.model.User;
import tn.moatez.payload.request.LoginRequest;
import tn.moatez.payload.response.LoginResponse;
import tn.moatez.payload.response.RegistreResponse;
import tn.moatez.repository.AccountRepository;
import tn.moatez.repository.RoleRepository;
import tn.moatez.repository.UserRepository;
import tn.moatez.security.jwt.JwtProvider;
import tn.moatez.security.jwt.usersecurity.UserPrinciple;
import tn.moatez.services.AuthService;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;


    public AuthServiceImpl(AccountRepository accountRepository, RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        var account = accountRepository.findByUsernameOrEmail(request.getUsername(), request.getUsername()).orElse(null);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        assert account != null;
        var jwtToken = jwtProvider.generateToken(UserPrinciple.build(account));
        return new LoginResponse(jwtToken);
    }

    @Override
    public RegistreResponse registre(UserDTO request) {
        Set<Role> role = new HashSet<>();
        role.add(roleRepository.findByName("client"));
        request.getAccountDTO().setPassword(passwordEncoder.encode(request.getAccountDTO().getPassword()));
        request.getAccountDTO().setEnabled(true);
        request.getAccountDTO().setVerified(false);
        User entity = User.mapDTOtoEntity(request);
        entity.getAccount().setRoles(role);
        if(userRepository.save(entity)!=null)
            return new RegistreResponse("User save successful");
        return  new RegistreResponse("User not save");
    }
}
