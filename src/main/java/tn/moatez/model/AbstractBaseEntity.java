package tn.moatez.model;

import jakarta.persistence.*;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AbstractBaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    @CreatedBy
    @Column(name = "CREATOR", updatable = false)
    private String creator;

    @NotNull
    @CreatedDate
    @Column(name = "CREATED", updatable = false)
    protected LocalDateTime created;

    @NotNull
    @LastModifiedBy
    @Column(name = "MODIFIER")
    private String modifier;

    @NotNull
    @LastModifiedDate
    @Column(name = "MODIFIED")
    private LocalDateTime modified;

    @Version
    @Column(name = "VERSION")
    private Integer version;

}
