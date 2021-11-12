package com.ata.apiBanda.models.banda;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private int number;

    @Column(name = "zipcode")
    private int zipcode;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "created")
    private OffsetDateTime created;

    @Column(name = "updated")
    private OffsetDateTime updated;

    @PreUpdate
    @PrePersist
    public void updateDateFields() {
        if (this.created == null) {
            this.created = OffsetDateTime.now();
        }

        this.updated = OffsetDateTime.now();
    }

}
