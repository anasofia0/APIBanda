package com.ata.apiBanda.models.banda;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.time.OffsetDateTime;
import java.util.List;
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

    private String name;

    @Email(message = "Email inválido")
    private String email;

    @CPF
    private String cpf;

    private OffsetDateTime created;

    private OffsetDateTime updated;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "customer_address",
            joinColumns =
            @JoinColumn(name = "customer_id",
                    referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "address_id",
                    referencedColumnName = "id"))
    private Set<Address> addresses;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<MobilePhone> mobilePhones;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_local_phone_id")
    private LocalPhone localPhone;

    @PreUpdate
    @PrePersist
    public void updateDateFields() {
        if (this.created == null) {
            this.created = OffsetDateTime.now();
        }

        this.updated = OffsetDateTime.now();
    }
}
