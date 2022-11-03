package org.springframework.samples.petclinic.recoveryroom;

import lombok.Getter;
import lombok.Setter;
import org.springframework.samples.petclinic.model.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name="rrtype")
public class RecoveryRoomType {
    @Id
    @Column(nullable =false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Size(min = 5,max = 50)
    @Column(unique=true,name = "name", nullable = false)
    String name;
}
