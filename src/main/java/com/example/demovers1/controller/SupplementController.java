// package com.example.demovers1.controller;
/* import com.example.demovers1.entity.SupplementsEntity;
import com.example.demovers1.service.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;  // Импортиране на Collectors
@Controller
public class SupplementController {



    @Autowired
    private SupplementService supplementService;

    // GET метод за началната страница
    @GetMapping("/")
    public String showSearchPage() {
        return "index"; // показва шаблона index.html
    }

    // POST метод за търсене на добавки по симптоми
    @PostMapping("/search")
    public String searchSupplements(@RequestParam("symptom") String symptomInput, Model model) {
        // Разделяне на въведените симптоми по запетая и премахване на допълнителни интервали
        List<String> symptoms = Arrays.stream(symptomInput.split(","))
                .map(String::trim)
                .map(String::toLowerCase) // За да се игнорират разлики в главни и малки букви
                .collect(Collectors.toList());




        // Вземане на добавките от базата данни, свързани със симптомите
        List<SupplementsEntity> dobavki = supplementService.findSupplementsBySymptoms(symptoms);

        // Ако няма намерени добавки
        if (dobavki.isEmpty()) {
            model.addAttribute("message", "Няма препоръчани добавки за тези симптоми.");
        } else {
            model.addAttribute("dobavki", dobavki);
        }
        return "index";
    }
}
*/


//package com.example.demovers1.controller;

/*import com.example.demovers1.model.Dobavka;
import com.example.demovers1.service.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demovers1.entity.*;
import com.example.demovers1.model.SymptomRequest;

import java.util.List;

@RestController
@RequestMapping("/api/supplements")
public class SupplementController {

    private final SupplementService supplementService;

    @Autowired
    public SupplementController(SupplementService supplementService) {
        this.supplementService = supplementService;
    }

    // GET метод за търсене на добавки по симптоми
    @GetMapping("/search")
    public List<Dobavka> getSupplementsBySymptoms(@RequestParam List<String> symptoms) {
        System.out.println("Received symptoms: " + symptoms); // Логиране на симптомите
        List<Dobavka> supplements = supplementService.getSupplementsBySymptoms(symptoms); // Извикване на метода от сервиза
        System.out.println("Supplements found: " + supplements); // Логиране на намерените добавки
        return supplements; // Връщане на намерените добавки
    }

    // POST метод за търсене на добавки по симптоми
    @PostMapping("/search")
    public List<Dobavka> searchSupplementsBySymptomsPost(@RequestBody List<String> symptoms) {
        List<Dobavka> supplements = supplementService.getSupplementsBySymptoms(symptoms); // Извикване на метода от сервиза
        System.out.println("Received symptoms via POST: " + symptoms);
        return supplements; // Връщане на намерените добавки
    }
}
*/
 /* package com.example.demovers1.controller;

import com.example.demovers1.entity.Dobavka;
import com.example.demovers1.model.DobavkaResponse;
import com.example.demovers1.model.SymptomRequest;
import com.example.demovers1.service.SupplementService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/supplements")
public class SupplementController {

    private final SupplementService supplementService;

    public SupplementController(SupplementService supplementService) {
        this.supplementService = supplementService;
    }

    @PostMapping("/by-symptoms")
    @ResponseBody
    public List<DobavkaResponse> getSupplements(@RequestBody SymptomRequest symptomRequest) {
        List<String> symptoms = symptomRequest.getSymptoms();
        return supplementService.getSupplementsForSymptoms(symptoms);
    }
/*
@GetMapping("/by-symptoms")
public ResponseEntity<List<DobavkaResponse>> getSupplements(@RequestParam String symptoms) {
    List<String> symptomList = Arrays.stream(symptoms.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    return ResponseEntity.ok(supplementService.getSupplementsForSymptoms(symptomList));
}





    @GetMapping("/")
   public String showForm() {
       return "index";

   }

    @PostMapping("/by-symptoms")
    public String getSupplements(@RequestParam String symptoms, Model model) {
        List<DobavkaResponse> result = supplementService.getSupplementsForSymptoms(Collections.singletonList(symptoms));
        model.addAttribute("index", result);
        return "index"; // връщаме същия html, но с резултатите
    }



}


*/


package com.example.demovers1.controller;

import com.example.demovers1.model.DobavkaResponse;
import com.example.demovers1.service.SupplementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/supplements")
public class SupplementController {

    private final SupplementService supplementService;

    public SupplementController(SupplementService supplementService) {
        this.supplementService = supplementService;
    }

    @PostMapping("/by-symptoms")
    public List<DobavkaResponse> getSupplementsBySymptoms(@RequestBody Map<String, List<String>> payload) {
        List<String> symptoms = payload.get("symptoms");
        return supplementService.getSupplementsForSymptoms(symptoms);
    }
}
