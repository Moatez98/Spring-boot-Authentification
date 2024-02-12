package tn.moatez.configuration.utils;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import tn.moatez.model.Role;
import tn.moatez.repository.RoleRepository;

import java.util.List;
@Component
public class SaveRoles {
    private final RoleRepository roleRepository;

    public SaveRoles(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @PostConstruct
    public void init(){
        saveRoles();
    }

    private void saveRoles() {
        List<Role> roleSet = roleRepository.findAll();
        if(roleSet.isEmpty()){
            roleRepository.save(new Role("client"));
            roleRepository.save(new Role("admin"));
        }
    }
}
