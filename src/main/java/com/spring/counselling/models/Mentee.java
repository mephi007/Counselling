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
@Table(name = "mentee")
public class Mentee extends Auditable {
    @OneToOne
    private Account account;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "mentee")
    private List<Session> sessions = new ArrayList();

    @OneToOne
    private Session activeSession =null;

    private  String phoneNumber;

    @Temporal(value = TemporalType.DATE)
    private Date dob;

    @OneToOne
    private Address address;

    @OneToOne
    private College college;

    @OneToMany(mappedBy = "mentee")
    private List<Company> companies;

    @OneToOne
    private Feedback feedback;

}
