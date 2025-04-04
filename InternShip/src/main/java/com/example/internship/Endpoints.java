package com.example.internship;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Endpoints {

    private static Flights _flights = new Flights(Arrays.asList(
                new Flight("SOF", "MLE", 70),
                new Flight("SOF", "LON", 10),
                new Flight("LON", "MLE", 20)

        ));

    @PostMapping("/routes")
    public List<RoutesRepose> Routes(@RequestBody RoutesRequest request) {
        return _flights.findRoutes(request.getOrigin(), request.getDestination(), request.getMaxFlights());
    }
}
