# Release v1.0.0 - Spring Boot Webhook Challenge Application

## 🎯 Release Overview
This is the initial release of the Spring Boot Webhook Challenge Application that successfully implements all requirements of the webhook challenge.

## ✨ Features
- **Automatic Execution**: Runs webhook challenge on application startup
- **REST API Integration**: Generates webhook and submits solutions
- **JWT Authentication**: Secure communication with JWT tokens
- **Database Operations**: H2 in-memory database with sample data
- **SQL Problem Solving**: Implements Question 1 (odd regNo ending)
- **No Controllers**: Fully automated without user interaction

## 📦 Download Links

### Executable JAR File
**Direct Download**: [springapp-1.0.0.jar](https://github.com/RajkumarTula/Springboot-App/releases/download/v1.0.0/springapp-1.0.0.jar)

**File Size**: ~52MB (includes all dependencies)

**SHA256 Hash**: `[Will be provided after release creation]`

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- No additional dependencies required (self-contained JAR)

### Run the Application
```bash
java -jar springapp-1.0.0.jar
```

### What Happens
1. Application starts automatically
2. Sends POST request to generate webhook
3. Initializes database with sample data
4. Generates SQL solution for the challenge
5. Submits solution to webhook URL with JWT authentication

## 🔧 Configuration
- **Port**: 8080 (configurable via application.properties)
- **Database**: H2 in-memory (accessible at http://localhost:8080/h2-console)
- **Logging**: Comprehensive logging for all operations

## 📊 SQL Solution Implemented
The application solves: *"Calculate the number of employees who are younger than each employee, grouped by their respective departments"*

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

## 🌐 API Endpoints Used
- **Webhook Generation**: `POST /hiring/generateWebhook/JAVA`
- **Solution Submission**: `POST /hiring/testWebhook/JAVA`

## 📁 Project Structure
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
└── README.md                              # Comprehensive documentation
```

## 🔍 Verification
- **Build Status**: ✅ Successfully compiled with Maven
- **Dependencies**: ✅ All Spring Boot dependencies included
- **Testing**: ✅ Basic Spring context loading test passed
- **Documentation**: ✅ Complete README and technical documentation

## 📝 Release Notes
- **Initial Release**: Complete Spring Boot application
- **Architecture**: Clean layered architecture with proper separation of concerns
- **Error Handling**: Comprehensive exception handling and logging
- **Production Ready**: Proper configuration and error handling

## 🆘 Support
- **Documentation**: See README.md for detailed setup instructions
- **Issues**: Report issues on GitHub repository
- **Questions**: Check SUBMISSION_SUMMARY.md for technical details

## 📋 Requirements Met
- ✅ **Automatic execution** on application startup
- ✅ **Webhook generation** via REST API
- ✅ **SQL problem solving** with proper database schema
- ✅ **Solution submission** with JWT authentication
- ✅ **No controllers/endpoints** required
- ✅ **Production-ready** configuration

---
**Release Date**: August 29, 2025  
**Version**: 1.0.0  
**Java Version**: 17  
**Spring Boot Version**: 3.2.0  
**Author**: RajkumarTula
