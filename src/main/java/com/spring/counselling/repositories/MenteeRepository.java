package com.spring.counselling.repositories;

import com.spring.counselling.models.Mentee;
import com.spring.counselling.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenteeRepository extends PersonRepository<Mentee, Long> {

}
