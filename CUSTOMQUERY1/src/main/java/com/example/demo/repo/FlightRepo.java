package com.example.demo.repo;

import com.example.demo.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepo extends JpaRepository <Flight,Integer> {
}