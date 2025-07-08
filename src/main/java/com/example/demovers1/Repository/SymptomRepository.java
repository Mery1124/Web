//package com.example.demovers1.Repository;

/* import com.example.demovers1.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SymptomRepository extends JpaRepository<Symptom, Long> {
    Optional<Symptom> findBySymptom(String symptom);
}
*/
package com.example.demovers1.Repository;

import com.example.demovers1.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SymptomRepository extends JpaRepository<Symptom, Long> {
    Optional<Symptom> findBySymptom(String symptom);
}
