package tn.moatez.dto;

import lombok.*;
import org.modelmapper.ModelMapper;
import tn.moatez.model.User;


import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private Date birthday;
    private String phone_number;
    private boolean verified;
    private boolean enabled;
    private String genre;
    private AccountDTO accountDTO;
    public static UserDTO mapEntityToDTO(User entity){
        ModelMapper modelMapper = new ModelMapper();
        UserDTO dto = modelMapper.map(entity, UserDTO.class);
        if(entity.getAccount()!=null){
            dto.setAccountDTO(AccountDTO.mapEntityToDTO(entity.getAccount()));
        }
        return dto ;
    }
}