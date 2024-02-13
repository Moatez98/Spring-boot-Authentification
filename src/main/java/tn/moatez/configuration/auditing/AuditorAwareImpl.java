package tn.moatez.configuration.auditing;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNullApi;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import tn.moatez.model.Account;
import tn.moatez.repository.AccountRepository;
import tn.moatez.security.jwt.usersecurity.UserPrinciple;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    private static final String NOMEN_NESCIO = "N.N.";
    private  AccountRepository accountRepository;



    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated()
        || authentication instanceof AnonymousAuthenticationToken){
            return Optional.of(NOMEN_NESCIO);
        }

        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        return Optional.ofNullable(userPrincipal.getUsername());
    }
}
