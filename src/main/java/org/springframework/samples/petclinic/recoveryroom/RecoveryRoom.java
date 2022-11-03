package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="recoveryroom")
public class RecoveryRoom {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @NotNull
    @Size(min = 3,max = 50)
    @Column(name = "name")
    private String name;

    @PositiveOrZero
    @Column(name="size")
    double size;

    @NotNull
    @Column(name="secure")
    boolean secure;

    @Transient
    //@ManyToOne
    //@JoinColumn(name = "room_type_id")
    RecoveryRoomType roomType;
}
