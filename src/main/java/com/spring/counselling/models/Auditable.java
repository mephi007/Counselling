package com.spring.counselling.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass  // don't create table for Auditable
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class Auditable implements Serializable {
    // sending these entities over network
    // saving them in file
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)  // Jpa
    @CreatedDate // hibernate
    private Date createdAt; // whenever the row is created - automatically set this value

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate // hibernate
    private Date updatedAt; // whenever the row is modified - automatically update this

    // Passenger() <-> row in the database
    // Hibernate will cache things properly
    // that entity comparison is based on the table and id instead of just the memory address

    // when an entity is created - can spring provide the id for it?
    // no - id is provided by the database
    // Booking booking = new Booking();
    // as long as it is just in memory
    // booking.id == null
    // bookingRepository.save(booking);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // memory locations are same
        // first make sure that they belong to the same class
        if (o == null || getClass() != o.getClass()) return false;
        // other object o, interpret as an auditable object
        Auditable auditable = (Auditable) o;
        // if any of the ids is null
        // id = null, o.id = null   - both objects are in memory
        // id = null, ob.id != null - can't be equal
        // id != null, ob.id = null - can't be equal
        if (id == null || auditable.id == null) return false;
        // both ids are non-null
        return id.equals(auditable.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
}
