package com.example.airtunisia.Service;

import com.example.airtunisia.Model.Flight;
import com.example.airtunisia.Model.Plane;
import com.example.airtunisia.Repository.FlightRepository;
import com.example.airtunisia.Repository.PlaneRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Service/FlightService")
public class FlightService {

    @Autowired
    FlightRepository flightRepository;


    @GetMapping(value = "/findAllFlights")
    public List findFlights() {
        List flightList = flightRepository.findAll();
        return (flightList);
    }

    @PostMapping(value = "/saveFlight")
    public Flight newFlight(@RequestBody Flight newFlight) {

//        System.out.println("fgfffffff"+newFlight.getPlane().getId());

        flightRepository.save(newFlight);
        return newFlight;
    }

    @DeleteMapping(value = "/deleteFlight/{id}")
    public String deleteFlight(@PathVariable int id) {

        flightRepository.deleteById(id);
        return "OK!";
    }

    @PutMapping(value = "/editFlight/{id}")
    public Flight editFlight(@RequestBody Flight flightInfo, @PathVariable int id) {

        Flight flight = flightRepository.findById(id);
        flight.setDestination(flightInfo.getDestination());
        flightRepository.save(flight);
        return flight;
    }

  /*  @GetMapping(value = "/findFlightsByPlane/{id}")
    public List<Flight> getFlightByPlaneId( @PathVariable int id){

        System.out.println(id);
        return flightRepository.findFlightsByPlaneId(id);
    }*/
}
