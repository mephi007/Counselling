package com.spring.counselling.repositories;

import com.spring.counselling.models.Mentee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenteeRepository extends JpaRepository<Mentee, Long> {
    Optional<Mentee> findFirstByAcount_Username(String username);
}
