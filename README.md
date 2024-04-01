# spring-cloud-gateway-cb

- The project repo has 2 modules - a gateway and customer-service

### To start the app:

#### customer-service:

- Run the ` ./gradlew :bootRun` in customer-service that starts app under port 8080
  - This should start up h2 with 4 DB entries
  - the endpoint http://locahost:8080/customer returns all the person details
  - the endpoint http://localhost:8080/customer/error throws an explicit exception
 
#### gateway
- Run the ` ./gradlew :bootRun` in gateway that starts under port 8088
- the URL http://localhost:8088/customer and http://localhost:8088/customer/error will route to customer-service's endpoints as configured in `RouterConfig.java`
- Observe the circuit breaker states toggling when you switch between `/customer` and `/customer/error` under actuator metrics
  - http://localhost:8088/actuator/metrics/resilience4j.circuitbreaker.state?tag=state:open&tag=name:customerCircuitBreaker (gives info about OPEN state)
  - http://localhost:8088/actuator/metrics/resilience4j.circuitbreaker.state?tag=state:closed&tag=name:customerCircuitBreaker (gives info about CLOSED state)


To note:
- Currently there seems to be an issue with yaml based `CircuitBreaker` filter
- Thus the router function has been created and exposed as bean to resolve issue in `RouterConfig.java`.
