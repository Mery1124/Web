//package com.example.demovers1.entity;

//import jakarta.persistence.*;

/*@Entity
@Table(name = "supplement_symptom")
public class SupplementSymptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dobavka_id")
    private Dobavka dobavka;

    @ManyToOne
    @JoinColumn(name = "symptom_id")
    private Symptom symptom;
}
*/

package com.example.demovers1.entity;
import javax.persistence.*;
import java.util.*;
@Entity
@Table(name = "supplement_symptom")
public class SupplementSymptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "supplement_id")
    private Dobavka dobavka;
    @ManyToOne
    @JoinColumn(name = "symptom_id", nullable = false)
    private Symptom symptom;
    public Long getId() {
        return id;
    }
    public Dobavka getDobavka() {
        return dobavka;
    }
    public void setDobavka(Dobavka dobavka) {
        this.dobavka = dobavka;
    }
    public Symptom getSymptom() {
        return symptom;
    }
    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }
}
