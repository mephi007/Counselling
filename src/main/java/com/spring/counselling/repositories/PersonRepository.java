package com.spring.counselling.repositories;

import com.spring.counselling.models.Account;
import com.spring.counselling.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository<M extends Person, L extends Number> extends JpaRepository<Account, Long> {
    Optional<Person> findFirstByUsername(String username);
}
