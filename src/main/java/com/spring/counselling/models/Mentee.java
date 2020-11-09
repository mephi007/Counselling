package com.spring.counselling.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mentee")
public class Mentee extends Person{

    @OneToMany(mappedBy = "mentor")
    private List<Company> companies;

    @OneToMany(mappedBy = "mentee")
    private List<Session> sessions = new ArrayList();

    @OneToOne
    private Session activeSession = null;

    @OneToOne
    private College college;
}
