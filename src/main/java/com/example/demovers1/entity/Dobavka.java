// package com.example.demovers1.entity;

/* import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dobavki")
public class SupplementsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming auto-generation for IDs
    private Integer id;

    private String dobavka;

    @ManyToMany
    @JoinTable(
            name = "supplement_symptom",
            joinColumns = @JoinColumn(name = "supplement_id"),
            inverseJoinColumns = @JoinColumn(name = "symptom_id")
    )
    private Set<SymptomsEntity> symptoms;
    @Override
    public String toString() {
        return dobavka;
    }

 */



//package com.example.demovers1.entity;

//import jakarta.persistence.*;
//import java.util.Set;

/*@Entity
@Table(name = "dobavki")
public class SupplementsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dobavka;

    @ManyToMany
    @JoinTable(
            name = "supplement_symptom",
            joinColumns = @JoinColumn(name = "supplement_id"),
            inverseJoinColumns = @JoinColumn(name = "symptom_id")
    )
    private Set<SymptomsEntity> symptoms;

    // Гетъри и сетъри
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDobavka() {
        return dobavka;
    }

    public void setDobavka(String dobavka) {
        this.dobavka = dobavka;
    }

    public Set<SymptomsEntity> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Set<SymptomsEntity> symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public String toString() {
        return "SupplementsEntity{id=" + id + ", dobavka='" + dobavka + "'}";
    }
}
*/

package com.example.demovers1.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dobavki")
public class Dobavka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dobavka;

    @OneToMany(mappedBy = "dobavka")
    private Set<SupplementSymptom> supplementSymptoms;

    public Long getId() {
        return id;
    }

    public String getDobavka() {
        return dobavka;
    }

    public void setDobavka(String dobavka) {
        this.dobavka = dobavka;
    }

    public Set<SupplementSymptom> getSupplementSymptoms() {
        return supplementSymptoms;
    }

    public void setSupplementSymptoms(Set<SupplementSymptom> supplementSymptoms) {
        this.supplementSymptoms = supplementSymptoms;
    }
}
