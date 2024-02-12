package tn.moatez.model;

import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.ModelMapper;
import tn.moatez.dto.RoleDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role extends AbstractBaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;

    public Role(String name) {
        this.name=name;
    }

    public static Role mapDTOtoEntity(RoleDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Role.class);
    }
}
