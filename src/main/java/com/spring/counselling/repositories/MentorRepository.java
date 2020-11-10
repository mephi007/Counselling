package com.spring.counselling.repositories;

import com.spring.counselling.models.Mentor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MentorRepository extends PersonRepository<Mentor, Long> {
}
