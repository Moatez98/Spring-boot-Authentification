package tn.moatez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.moatez.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
