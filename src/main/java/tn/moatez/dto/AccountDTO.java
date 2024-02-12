package tn.moatez.dto;

import lombok.*;
import org.modelmapper.ModelMapper;
import tn.moatez.model.Account;

import java.util.Set;
import java.util.stream.Collectors;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO extends AbstractEntityDTO{
    private Long id ;
    private String email;
    private String username ;
    private String password ;
    private boolean verified ;
    private boolean enabled ;
    private Set<RoleDTO> roleDTO;

    public static AccountDTO mapEntityToDTO(Account entity){
        ModelMapper modelMapper = new ModelMapper();
        AccountDTO dto = modelMapper.map(entity, AccountDTO.class);
        if(!entity.getRoles().isEmpty()){
            dto.setRoleDTO(entity.getRoles().stream()
                    .map(RoleDTO::mapEntityToDTO).collect(Collectors.toSet()));
        }
        return dto;
    }
}
