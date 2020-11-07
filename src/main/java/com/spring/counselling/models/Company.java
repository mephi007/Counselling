package com.spring.counselling.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class Company extends Auditable {
    @ManyToOne
    private Mentee mentee;

    @ManyToOne
    private Mentor Mentee;

    private String name;
    private int expYear;
    private int expMonth;
}
