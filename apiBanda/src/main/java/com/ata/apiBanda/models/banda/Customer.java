package com.ata.apiBanda.models.banda;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    @Email(message = "Email inválido")
    private String email;

    @OneToMany
    @JoinColumn(name = "fk_phone_contact")
    private Set<PhoneContact> phoneContact;

    @CPF
    @Column(name = "cpf")
    private String cpf;

    @OneToMany
    @JoinColumn(name = "fk_id_address")
    private Set<Address> address;

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
