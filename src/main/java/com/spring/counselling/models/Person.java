package com.spring.counselling.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person extends Auditable {
    @OneToOne
    private Account account;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private  String phoneNumber;

    private String email;

    @Temporal(value = TemporalType.DATE)
    private Date dob;

    @OneToOne
    private Address address;


}
