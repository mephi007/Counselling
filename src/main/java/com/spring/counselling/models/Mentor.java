package com.spring.counselling.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mentor")
public class Mentor extends Person {

    @OneToMany(mappedBy = "mentor")
    private List<Company> companies;

    @OneToMany(mappedBy = "mentor")
    private List<Session> sessions = new ArrayList();

    @OneToOne
    private Session activeSession = null;
}
