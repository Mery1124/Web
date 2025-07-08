// package com.example.demovers1.entity;

/* import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "symptoms")
public class SymptomsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming auto-generation for IDs
    private Integer id;

    private String symptom;

    @ManyToMany(mappedBy = "symptoms")
    private Set<SupplementsEntity> dobavki;

    // Getters and Setters

*/
//package com.example.demovers1.entity;

//import jakarta.persistence.*;
//import java.util.Set;

/*@Entity
@Table(name = "symptoms")
public class SymptomsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String symptom;

    @ManyToMany(mappedBy = "symptoms")
    private Set<SupplementsEntity> supplements;

    // Гетъри и сетъри
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public Set<SupplementsEntity> getSupplements() {
        return supplements;
    }

    public void setSupplements(Set<SupplementsEntity> supplements) {
        this.supplements = supplements;
    }
}
*/

package com.example.demovers1.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "symptoms")
public class Symptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symptom;

    @OneToMany(mappedBy = "symptom")
    private Set<SupplementSymptom> supplementSymptoms;

    // Getters и Setters
}
