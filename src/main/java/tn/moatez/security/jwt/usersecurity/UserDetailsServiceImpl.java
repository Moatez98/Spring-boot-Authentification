package tn.moatez.security.jwt.usersecurity;

import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.moatez.model.Account;
import tn.moatez.repository.AccountRepository;

@Service

public class UserDetailsServiceImpl implements UserDetailsService {
    private final AccountRepository accountRepository;

    public UserDetailsServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsernameOrEmail(username,username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserPrinciple.build(account);
    }
}
