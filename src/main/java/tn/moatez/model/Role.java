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
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String name ;
    public static Role mapDTOtoEntity(RoleDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Role.class);
    }
}
