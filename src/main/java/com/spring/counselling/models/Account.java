package com.spring.counselling.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="account")
public class Account extends Auditable {
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
