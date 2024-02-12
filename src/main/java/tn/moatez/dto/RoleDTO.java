package tn.moatez.dto;
import lombok.*;
import org.modelmapper.ModelMapper;
import tn.moatez.model.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO extends AbstractEntityDTO{
    private Long id ;
    private String name ;
    public static RoleDTO mapEntityToDTO(Role entity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity,RoleDTO.class);
    }

}
