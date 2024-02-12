package tn.moatez.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import tn.moatez.dto.AccountDTO;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String email ;
    private String username ;
    private String password ;
    private boolean verified;
    private boolean enabled;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(  name = "account_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    public static Account mapDTOtoEntity(AccountDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        Account entity = modelMapper.map(dto, Account.class);
        if(!dto.getRoleDTO().isEmpty()){
            entity.setRoles(dto.getRoleDTO().stream()
                    .map(Role::mapDTOtoEntity).collect(Collectors.toSet()));
        }
        return entity;
    }
}
