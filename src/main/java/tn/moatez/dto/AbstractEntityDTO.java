package tn.moatez.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbstractEntityDTO {

    private String creator;
    protected LocalDateTime created;
    private String modifier;
    private LocalDateTime modified;
    private Integer version;
}
