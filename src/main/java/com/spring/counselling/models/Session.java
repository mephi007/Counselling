package com.spring.counselling.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="session")
public class Session extends Auditable{

    @ManyToOne
    private Mentee mentee;

    @ManyToOne
    private Mentor mentor;

//    @ManyToMany(cascade = CascadeType.PERSIST)
//    private Set<Mentor> mentors = new HashSet<>();

    @OneToOne
    private Feedback feedbackbyMentee;

    @OneToOne
    private Feedback feedbackbyMentor;



}
