package tn.moatez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.moatez.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
