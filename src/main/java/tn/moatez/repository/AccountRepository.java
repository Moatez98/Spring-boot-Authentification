package tn.moatez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.moatez.model.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
