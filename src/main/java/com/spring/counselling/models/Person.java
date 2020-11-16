package com.spring.counselling.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "person")
public abstract class Person extends Auditable {

    @Column(unique = true, nullable = false)
    private String username;
    private String password;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(unique = true, nullable = false)
    private  String phoneNumber;

    @Column(unique = true, nullable = false)
    private String email;

    @Temporal(value = TemporalType.DATE)
    private Date dob;

    @OneToOne
    private Address address;


}
