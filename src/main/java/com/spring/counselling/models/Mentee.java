package com.spring.counselling.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table(name = "mentee")
public class Mentee extends Person{

    @OneToMany(mappedBy = "mentee")
    private List<Company> companies;

    @OneToMany(mappedBy = "mentee")
    private List<Session> sessions = new ArrayList();

    @OneToOne
    private Session activeSession = null;

    @OneToOne
    private College college;


}
