Flight Route Finder (Web Application)

This project is a Spring Boot web application that provides flight route-finding functionality via HTTP. It uses the Yaak HTTP framework for handling requests and managing API interactions.

Overview

The application exposes an endpoint to find routes between cities based on predefined flight data.

It utilizes a recursive approach to explore possible paths while considering cost and flight constraints.

Routes are sorted based on the total cost, ensuring that users get the most efficient options.

Technologies Used

Spring Boot – Provides a lightweight framework for building web applications.

Yaak – Simplifies handling HTTP requests and API communication.

Java – The core language for implementing the flight-finding logic.

This web application serves as the backend for a larger system that offers real-time flight route calculations.

