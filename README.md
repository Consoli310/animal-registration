# Animal Registration API

This project is a **REST API** developed in **Java with Spring Boot** for managing the registration of animals in an animal rescue institution. The system allows the institution to keep track of registered animals efficiently.

## 🚀 Technologies Used

- **Backend:** Java, Spring Boot, Spring Data JPA
- **Database:** H2 Database (in-memory for testing and development)
- **API Documentation:** Spring Boot Actuator (optional for monitoring)

## 📌 Features

- **Register new animals** with details such as:
  - Provisional Name
  - Estimated Age
  - Breed
  - Entry Date
  - Adoption Date (if applicable)
  - Arrival Conditions
  - Receiver's Name
  - Death Date (if applicable)
- **Retrieve the list of all registered animals**
- **Retrieve non-adopted animals by type**
- **Retrieve adopted animals by type**
- **Count rescued animals within a date range**

## ⚙️ How to Run the Project

1. Clone the repository:
   ```sh
   git clone https://github.com/Consoli310/animal-registration.git
   ```
2. Navigate to the project directory:
   ```sh
   cd animal-registration
   ```
3. Run the application using Maven:
   ```sh
   mvn spring-boot:run
   ```
4. The API will be available at:
   ```
   http://localhost:8080
   ```

## 🗄️ Database Information

The project uses an **H2 in-memory database**. To access the H2 console:

- URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: (leave blank)

## 📝 API Endpoints

| Method | Endpoint                    | Description                          |
|--------|----------------------------|----------------------------------|
| GET    | `/animais`                  | Get all registered animals       |
| POST   | `/animais`                  | Register a new animal            |
| GET    | `/animais/not-adopted/{tipo}` | Get non-adopted animals by type  |
| GET    | `/animais/adopted/{tipo}`    | Get adopted animals by type      |
| GET    | `/animais/rescates`         | Count rescued animals by date range |
