package tn.moatez.dto;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import tn.moatez.model.User;


import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends AbstractEntityDTO{
    private Long id;
    private String firstname;
    private String lastname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String phone_number;
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
