# Spring Boot Webhook Challenge - Quick Overview

## 🎯 Challenge Requirements Met
- ✅ **Automatic execution** on application startup
- ✅ **Webhook generation** via REST API
- ✅ **SQL problem solving** (Question 1 - odd regNo ending)
- ✅ **Solution submission** with JWT authentication
- ✅ **No controllers/endpoints** required

## 🚀 Quick Start

### Build
```bash
.\mvnw.cmd clean package
```

### Run
```bash
java -jar target/springapp-1.0.0.jar
```

## 📁 Key Files
- **Main Application**: `SpringAppApplication.java`
- **Core Logic**: `WebhookChallengeService.java`
- **Configuration**: `application.properties`
- **Dependencies**: `pom.xml`
- **Executable**: `target/springapp-1.0.0.jar`

## 🔧 Technology Stack
- **Java 17** + **Spring Boot 3.2.0**
- **RestTemplate** for HTTP communication
- **JPA/Hibernate** for database operations
- **H2 In-Memory Database**
- **Maven** for dependency management

## 📊 SQL Solution
```sql
SELECT 
    e.EMP_ID, e.FIRST_NAME, e.LAST_NAME, d.DEPARTMENT_NAME,
    COUNT(y.EMP_ID) AS YOUNGER_EMPLOYEES_COUNT
FROM EMPLOYEE e
JOIN DEPARTMENT d ON e.DEPARTMENT = d.DEPARTMENT_ID
LEFT JOIN EMPLOYEE y ON e.DEPARTMENT = y.DEPARTMENT AND y.DOB > e.DOB
GROUP BY e.EMP_ID, e.FIRST_NAME, e.LAST_NAME, d.DEPARTMENT_NAME
ORDER BY e.EMP_ID DESC
```

## 🌐 API Endpoints
- **Webhook Generation**: `POST /hiring/generateWebhook/JAVA`
- **Solution Submission**: `POST /hiring/testWebhook/JAVA`

## 📝 Notes
- Application runs automatically on startup
- Database is populated with sample data
- H2 console available at `http://localhost:8080/h2-console`
- Comprehensive logging and error handling
- Production-ready with proper configuration
