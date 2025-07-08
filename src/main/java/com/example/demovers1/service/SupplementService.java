// package com.example.demovers1.service;

/* import com.example.demovers1.model.Dobavka;
import com.example.demovers1.model.Symptom;
import com.example.demovers1.Repository.SupplementRepository;
import com.example.demovers1.entity.SupplementsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class SupplementService {

    private final SupplementRepository repository;

    @Autowired
    public SupplementService(SupplementRepository repository) {
        this.repository = repository;
    }
    public Dobavka mapToDobavka(SupplementsEntity entity) {
        List<Symptom> symptoms = entity.getSymptoms().stream()
                .map(s -> new Symptom(s.getSymptom()))
                .collect(Collectors.toList());
        return new Dobavka(entity.getDobavka(), symptoms);
    }
    public List<SupplementsEntity> findSupplementsBySymptoms(List<String> symptoms) {
        System.out.println("Търсене на добавки за симптоми: " + symptoms);
        List<SupplementsEntity> supplements = repository.findDistinctBySymptoms_SymptomIn(symptoms);
        System.out.println("Намерени добавки: " + supplements.size());
        return supplements;
    }


}
*/


//package com.example.demovers1.service;
/*import com.example.demovers1.Repository.SupplementSymptomRepository;
import com.example.demovers1.entity.Dobavka;
import com.example.demovers1.Repository.DobavkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplementService {

    private final SupplementSymptomRepository supplementSymptomRepository;

    public SupplementService(SupplementSymptomRepository supplementSymptomRepository) {
        this.supplementSymptomRepository = supplementSymptomRepository;
    }

    public List<Dobavka> getSupplementsForSymptoms(List<String> symptoms) {
        return supplementSymptomRepository.findDobavkiBySymptoms(symptoms);
    }
}
*/
package com.example.demovers1.service;

import com.example.demovers1.model.DobavkaResponse;
import com.example.demovers1.entity.Dobavka;
import com.example.demovers1.Repository.SupplementSymptomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplementService {

    private final SupplementSymptomRepository supplementSymptomRepository;

    public SupplementService(SupplementSymptomRepository supplementSymptomRepository) {
        this.supplementSymptomRepository = supplementSymptomRepository;
    }

    public List<DobavkaResponse> getSupplementsForSymptoms(List<String> symptoms) {
        List<Dobavka> dobavki = supplementSymptomRepository.findDobavkiBySymptoms(symptoms);
        return dobavki.stream()
                .map(d -> new DobavkaResponse(d.getDobavka()))
                .collect(Collectors.toList());
    }
}
