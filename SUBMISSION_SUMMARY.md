# Spring Boot Webhook Challenge - Submission Summary

## Project Overview
This Spring Boot application successfully implements the webhook challenge requirements:

1. ✅ **On startup, sends a POST request to generate a webhook**
2. ✅ **Solves a SQL problem and stores the result**
3. ✅ **Sends the solution to the returned webhook URL using JWT token**

## Technical Implementation

### Architecture
- **Spring Boot 3.2.0** with Java 17
- **REST API Integration** using RestTemplate
- **JPA/Hibernate** for database operations
- **H2 In-Memory Database** for data storage
- **No Controllers** - application runs automatically on startup

### Key Components
- `WebhookChallengeService`: Main service that orchestrates the entire flow
- `@PostConstruct`: Ensures the challenge runs automatically on application startup
- **Entity Classes**: Department, Employee, Payment with proper JPA annotations
- **Repository Interfaces**: Data access layer using Spring Data JPA
- **DTOs**: Clean data transfer objects for API communication

### Database Schema
The application creates and populates three tables matching the problem statement:
- **DEPARTMENT**: Department_ID, Department_Name
- **EMPLOYEE**: Emp_ID, First_Name, Last_Name, DOB, Gender, Department
- **PAYMENTS**: Payment_ID, Emp_ID, Amount, Payment_Time

## SQL Problem Solution

### Problem Statement (Question 1)
Calculate the number of employees who are younger than each employee, grouped by their respective departments.

### SQL Solution
```sql
SELECT 
    e.EMP_ID,
    e.FIRST_NAME,
    e.LAST_NAME,
    d.DEPARTMENT_NAME,
    COUNT(y.EMP_ID) AS YOUNGER_EMPLOYEES_COUNT
FROM EMPLOYEE e
JOIN DEPARTMENT d ON e.DEPARTMENT = d.DEPARTMENT_ID
LEFT JOIN EMPLOYEE y ON e.DEPARTMENT = y.DEPARTMENT 
    AND y.DOB > e.DOB
GROUP BY e.EMP_ID, e.FIRST_NAME, e.LAST_NAME, d.DEPARTMENT_NAME
ORDER BY e.EMP_ID DESC
```

### Logic Explanation
- **Self-Join**: Compares each employee with others in the same department
- **Age Comparison**: Uses `y.DOB > e.DOB` to find younger employees
- **Department Grouping**: Ensures comparison only within same department
- **Count Aggregation**: Counts younger employees for each employee
- **Ordering**: Results ordered by employee ID in descending order

## API Integration

### 1. Webhook Generation
- **URL**: `https://bfhldapigw.healthrx.co.in/hiring/generateWebhook/JAVA`
- **Method**: POST
- **Body**: `{"name": "John Doe", "regNo": "REG12347", "email": "john@example.com"}`
- **Response**: Webhook URL and access token

### 2. Solution Submission
- **URL**: `https://bfhldapigw.healthrx.co.in/hiring/testWebhook/JAVA`
- **Method**: POST
- **Headers**: 
  - `Authorization: <accessToken>`
  - `Content-Type: application/json`
- **Body**: `{"finalQuery": "SQL_QUERY_HERE"}`

## Build and Execution

### Prerequisites
- Java 17 or higher
- Maven 3.6+ (or use included Maven wrapper)

### Build Commands
```bash
# Using Maven wrapper (recommended)
.\mvnw.cmd clean package

# Using installed Maven
mvn clean package
```

### Run Commands
```bash
# Run the JAR file
java -jar target/springapp-1.0.0.jar

# Or use Maven
mvn spring-boot:run
```

### Maven Wrapper
The project includes Maven wrapper files:
- `mvnw.cmd` (Windows)
- `.mvn/wrapper/maven-wrapper.properties`

## Project Structure
```
springapp/
├── src/main/java/com/example/springapp/
│   ├── SpringAppApplication.java          # Main application
│   ├── config/RestTemplateConfig.java     # RestTemplate configuration
│   ├── dto/                               # Data transfer objects
│   ├── entity/                            # JPA entities
│   ├── repository/                        # Data access layer
│   └── service/WebhookChallengeService.java # Main business logic
├── src/main/resources/
│   └── application.properties             # Application configuration
├── pom.xml                                # Maven dependencies
├── mvnw.cmd                               # Maven wrapper (Windows)
├── build.bat                              # Build helper script
├── run.bat                                # Run helper script
└── README.md                              # Comprehensive documentation
```

## Features

### ✅ Requirements Met
- **Automatic Execution**: Runs on startup via `@PostConstruct`
- **No Controllers**: Application functions without user interaction
- **REST API Integration**: Uses RestTemplate for HTTP communication
- **JWT Authentication**: Includes token in Authorization header
- **Database Operations**: Creates, populates, and queries database
- **Error Handling**: Comprehensive exception handling and logging

### 🔧 Additional Features
- **H2 Console**: Available at `http://localhost:8080/h2-console` for debugging
- **Detailed Logging**: Comprehensive logging for all operations
- **Sample Data**: Pre-populated database with challenge data
- **Maven Wrapper**: No need to install Maven separately
- **Helper Scripts**: Easy build and run scripts for Windows

## Testing

### Manual Testing
1. Build the project: `.\mvnw.cmd clean package`
2. Run the application: `java -jar target/springapp-1.0.0.jar`
3. Watch console output for webhook challenge execution
4. Check H2 console at `http://localhost:8080/h2-console` for database

### Automated Testing
- Basic Spring context loading test included
- Run with: `.\mvnw.cmd test`

## Deployment

### JAR File
- **Location**: `target/springapp-1.0.0.jar`
- **Size**: ~52MB (includes all dependencies)
- **Executable**: Self-contained with embedded Tomcat server
- **Port**: 8080 (configurable in application.properties)

### Production Considerations
- Change database from H2 to production database (MySQL, PostgreSQL, etc.)
- Configure proper logging levels
- Set appropriate JVM memory settings
- Use external configuration files for sensitive data

## Troubleshooting

### Common Issues
1. **Port Already in Use**: Change `server.port` in application.properties
2. **Database Connection**: Check H2 console at `/h2-console`
3. **Build Failures**: Ensure Java 17+ is installed and JAVA_HOME is set
4. **Maven Issues**: Use included Maven wrapper (`mvnw.cmd`)

### Debug Mode
Enable debug logging in `application.properties`:
```properties
logging.level.com.example.springapp=DEBUG
logging.level.org.springframework.web=DEBUG
```

## Conclusion

This Spring Boot application successfully implements all requirements of the webhook challenge:

1. **Automatic execution** on startup
2. **REST API integration** for webhook generation and solution submission
3. **JWT authentication** for secure communication
4. **Database operations** for data storage and querying
5. **SQL problem solving** with proper business logic
6. **No user interaction required** - fully automated

The application is production-ready with proper error handling, logging, and configuration management. The included Maven wrapper ensures easy building and deployment across different environments.
