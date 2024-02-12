package tn.moatez.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import tn.moatez.dto.UserDTO;
import tn.moatez.enums.EGenre;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "_user")
public class User extends AbstractBaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    @Column(nullable = false)
    private String phone_number;
    @Enumerated(EnumType.STRING)
    private EGenre genre;
    @OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private Account account;
    public static User mapDTOtoEntity(UserDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        User entity = modelMapper.map(dto, User.class);
        if(dto.getAccountDTO()!=null){
            entity.setAccount(Account.mapDTOtoEntity(dto.getAccountDTO()));
        }
        return entity;
    }

}
