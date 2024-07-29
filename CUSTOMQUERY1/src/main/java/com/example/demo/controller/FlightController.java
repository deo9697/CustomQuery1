package com.example.demo.controller;

import com.example.demo.entities.Flight;
import com.example.demo.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepo flightRepo;

    @PostMapping("/provision")
    public List<Flight> FlightList(){
        Random random = new Random();
        List<Flight> flights = IntStream.range(0,50).mapToObj(i ->{
            Flight flight = new Flight();
            flight.setDescription("flight " + random.nextInt(10000));
            flight.setFromAirport("Airport " + random.nextInt(100) );
            flight.setToAirport("Airport " + random.nextInt(100));
            return flight;
        }).collect(Collectors.toList());
        return flightRepo.saveAll(flights);
    }
    @GetMapping
    public List<Flight> tuttiVoli(){
        return flightRepo.findAll();
    }
}
