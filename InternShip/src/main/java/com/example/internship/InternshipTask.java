package com.example.internship;

import java.util.*;



class Flight {
    private final String origin;
    private final String destination;
    private final int price;

    public Flight(String origin, String destination, int price) {
        this.origin = origin;
        this.destination = destination;
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getPrice() {
        return price;
    }
}

class Flights {
    private List<Flight> flights;

    public Flights(List<Flight> flights) {
        this.flights = new ArrayList<>(flights);
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    private void findRoutesHelper(String origin, String destination, String result, int price,
                                  List<Map.Entry<String, Integer>> routes, int maxFlights, Set<String> visited) {
        if (origin.equals(destination)) {
            routes.add(new AbstractMap.SimpleEntry<>(result.substring(0, result.length() - 3), price));
            return;
        }

        if (maxFlights == 0) {
            return;
        }

        for (Flight flight : flights) {
            if (flight.getOrigin().equals(origin) && !visited.contains(flight.getDestination())) {
                visited.add(flight.getDestination());
                findRoutesHelper(flight.getDestination(), destination,
                        result + flight.getDestination() + " , ", price + flight.getPrice(), routes,
                        maxFlights - 1, visited);
                visited.remove(flight.getDestination());
            }
        }
    }

    public List<RoutesRepose> findRoutes(String origin, String destination, int maxFlights) {
        List<Map.Entry<String, Integer>> routes = new ArrayList<>();
        findRoutesHelper(origin, destination, origin + " , ", 0, routes, maxFlights, new HashSet<>(Collections.singleton(origin)));

        routes.sort(Comparator.comparingInt(Map.Entry::getValue));

        var result = new ArrayList<RoutesRepose>();
        for (Map.Entry<String, Integer> route : routes) {
            var item = new RoutesRepose();
            item.setRoute(route.getKey().split(","));
            item.setPrice(route.getValue());

            result.add(item);
        }

        return result;
    }
}

public class InternshipTask {
    public static void main(String[] args) {
        List<Flight> flightsList1 = Arrays.asList(
                new Flight("SOF", "IST", 10),
                new Flight("IST", "CMB", 20),
                new Flight("CMB", "MLE", 40)

        );

        List<Flight> flightsList2 = Arrays.asList(
                new Flight("SOF", "MLE", 70),
                new Flight("SOF", "LON", 10),
                new Flight("LON", "MLE", 20)

        );
        List<Flight> flightsList3 = Arrays.asList(
                new Flight("SOF", "LON", 10),
                new Flight("SOF", "NYC", 20)
        );

        Flights flights1 = new Flights(flightsList1);

        Flights flights2 = new Flights(flightsList2);

        Flights flights3 = new Flights(flightsList3);

        System.out.println("Finding routes from SOF to MLE:");
        flights1.findRoutes("SOF", "MLE", 3);
        System.out.println();

        System.out.println("Finding routes from SOF to MLE:");
        flights2.findRoutes("SOF", "MLE", 3);
        System.out.println();

        System.out.println("Finding routes from SOF to MLE:");
        flights3.findRoutes("SOF", "MLE", 3);
        System.out.println();
    }
}





