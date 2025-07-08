// package com.example.demovers1.Repository;

/*
import com.example.demovers1.entity.SupplementsEntity;
import com.example.demovers1.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface SupplementRepository extends CrudRepository<SupplementsEntity, Integer> {

    // Извличане на добавки по множество симптоми
    @Query("SELECT s FROM SupplementsEntity s JOIN s.symptoms sym WHERE sym.symptom IN :symptoms")
    List<SupplementsEntity> findDistinctBySymptoms_SymptomIn(@Param("symptoms") List<String> symptoms);

    @Query("SELECT s FROM SupplementsEntity s JOIN s.symptoms sym WHERE LOWER(TRIM(sym.symptom)) IN :symptoms")
    List<SupplementsEntity> findSupplementsBySymptoms(List<String> symptoms);

    @Query("""
    SELECT s FROM Dobavka s 
    JOIN s.symptoms sym 
    WHERE LOWER(sym.name) IN :symptoms
""")
    List<Dobavka> findBySymptomsInIgnoreCase(@Param("symptoms") List<String> symptoms);


}
*/

//package com.example.demovers1.Repository;

/* import com.example.demovers1.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SupplementSymptomRepository extends JpaRepository<SupplementSymptom, Long> {
    @Query("SELECT DISTINCT ss.dobavka FROM SupplementSymptom ss WHERE ss.symptom.symptom IN :symptoms")
    List<Dobavka> findDobavkiBySymptoms(@Param("symptoms") List<String> symptoms);
}
*/

package com.example.demovers1.Repository;

import com.example.demovers1.entity.Dobavka;
import com.example.demovers1.entity.SupplementSymptom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplementSymptomRepository extends JpaRepository<SupplementSymptom, Long> {

    @Query("SELECT DISTINCT ss.dobavka FROM SupplementSymptom ss WHERE ss.symptom.symptom IN :symptoms")
    List<Dobavka> findDobavkiBySymptoms(@Param("symptoms") List<String> symptoms);
}
