package com.spring.counselling.service;

import com.spring.counselling.models.Mentee;
import com.spring.counselling.models.Person;
import com.spring.counselling.repositories.MenteeRepository;
import com.spring.counselling.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenteeService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    MenteeRepository menteeRepository;

    public Mentee createOrUpdateMentee(Mentee mentee){
        Optional<Person> person = menteeRepository.findFirstByUsername(mentee.getUsername());
        if(person.isPresent()){
            Mentee newMentee = (Mentee) person.get();
            if(mentee.getCollege() != null){
                newMentee.setCollege(mentee.getCollege());
            }
            if(mentee.getCompanies() != null){
                newMentee.setCompanies(mentee.getCompanies());
            }
            if(mentee.getAddress() != null){
                newMentee.setAddress(mentee.getAddress());
            }
            if(mentee.getDob() != null){
                newMentee.setDob(mentee.getDob());
            }
            if(mentee.getEmail() != null){
                newMentee.setEmail(mentee.getEmail());
            }
            if(mentee.getPhoneNumber() != null){
                newMentee.setPhoneNumber(mentee.getPhoneNumber());
            }
            if(mentee.getGender() != null){
                newMentee.setGender(mentee.getGender());
            }

            return (Mentee) menteeRepository.save(newMentee);

        }else{
            return  (Mentee) menteeRepository.save(mentee);

        }

    }

    public Mentee getMenteeByUserName(String username) {
        Optional<Mentee> mentee = personRepository.findFirstByUsername(username);
        if(mentee.isPresent()){
            return mentee.get();
        }else{
            return null;
        }
    }

    public boolean deleteMentee(String username) {
        Optional<Mentee> mentee = personRepository.findFirstByUsername(username);
        if(mentee.isPresent()){

            personRepository.delete((Mentee) mentee.get());
            return true;
        }

        return false;
    }
}
