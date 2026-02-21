# Microservices Tutorial - Spring Boot

A simple microservices architecture tutorial with 3 microservices, Eureka service discovery, and API Gateway.

## Architecture

- **Service Discovery** (Port 8761): Eureka Server for service registration
- **API Gateway** (Port 8080): Spring Cloud Gateway for routing
- **Microservice A** (Port 8081): User Service with H2 database
- **Microservice B** (Port 8082): Product Service with H2 database
- **Microservice C** (Port 8083): Order Service with H2 database

## Prerequisites

- Java 21 or higher
- Maven 3.6+

## Running the Application

Start services in this order:

1. **Service Discovery**
```bash
cd service-discovery
mvn spring-boot:run
```
Access Eureka Dashboard: http://localhost:8761

2. **API Gateway**
```bash
cd api-gateway
mvn spring-boot:run
```

3. **Microservice A (User Service)**
```bash
cd microservice-a
mvn spring-boot:run
```

4. **Microservice B (Product Service)**
```bash
cd microservice-b
mvn spring-boot:run
```

5. **Microservice C (Order Service)**
```bash
cd microservice-c
mvn spring-boot:run
```

## Testing the APIs

All requests go through the API Gateway at http://localhost:8080

### User Service (Microservice A)
```bash
# Create a user
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","email":"john@example.com"}'

# Get all users
curl http://localhost:8080/users

# Get user by ID
curl http://localhost:8080/users/1
```

### Product Service (Microservice B)
```bash
# Create a product
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Laptop","price":999.99}'

# Get all products
curl http://localhost:8080/products

# Get product by ID
curl http://localhost:8080/products/1
```

### Order Service (Microservice C)
```bash
# Create an order
curl -X POST http://localhost:8080/orders \
  -H "Content-Type: application/json" \
  -d '{"userId":1,"productId":1,"quantity":2}'

# Get all orders
curl http://localhost:8080/orders

# Get order by ID
curl http://localhost:8080/orders/1
```

## H2 Database Console

Each microservice has its own H2 console:
- Microservice A: http://localhost:8081/h2-console (JDBC URL: jdbc:h2:mem:userdb)
- Microservice B: http://localhost:8082/h2-console (JDBC URL: jdbc:h2:mem:productdb)
- Microservice C: http://localhost:8083/h2-console (JDBC URL: jdbc:h2:mem:orderdb)

Username: sa, Password: (leave empty)

## Project Structure

```
microservices-tutorial/
├── service-discovery/     # Eureka Server
├── api-gateway/          # Spring Cloud Gateway
├── microservice-a/       # User Service
├── microservice-b/       # Product Service
└── microservice-c/       # Order Service
```
