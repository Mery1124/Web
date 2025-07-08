package com.example.demovers1.Repository;

import com.example.demovers1.entity.Dobavka;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DobavkaRepository extends JpaRepository<Dobavka, Long> {
}

