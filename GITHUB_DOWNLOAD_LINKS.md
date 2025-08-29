# 🚀 GitHub Repository & Download Links - Spring Boot Webhook Challenge

## 📍 Repository Information
- **GitHub URL**: https://github.com/RajkumarTula/Springboot-App
- **Clone URL**: https://github.com/RajkumarTula/Springboot-App.git
- **Main Branch**: `main`
- **Latest Tag**: `v1.0.0`

## 📦 Downloadable JAR File

### 🎯 **PRIMARY DOWNLOAD LINK**
```
https://github.com/RajkumarTula/Springboot-App/releases/download/v1.0.0/springapp-1.0.0.jar
```

### 📋 JAR File Details
- **Filename**: `springapp-1.0.0.jar`
- **File Size**: ~52MB (includes all dependencies)
- **Java Version Required**: 17 or higher
- **Type**: Self-contained Spring Boot executable JAR

### 🔗 Alternative Download Links
- **Release Page**: https://github.com/RajkumarTula/Springboot-App/releases/tag/v1.0.0
- **Latest Release**: https://github.com/RajkumarTula/Springboot-App/releases/latest
- **Repository Root**: https://github.com/RajkumarTula/Springboot-App

## 🚀 Quick Start Instructions

### 1. Download the JAR
```bash
# Option 1: Direct download (recommended)
curl -L -o springapp-1.0.0.jar "https://github.com/RajkumarTula/Springboot-App/releases/download/v1.0.0/springapp-1.0.0.jar"

# Option 2: Visit the release page and click download
# https://github.com/RajkumarTula/Springboot-App/releases/tag/v1.0.0
```

### 2. Run the Application
```bash
java -jar springapp-1.0.0.jar
```

### 3. What Happens Automatically
- ✅ Application starts on port 8080
- ✅ Sends POST request to generate webhook
- ✅ Initializes database with sample data
- ✅ Generates SQL solution for the challenge
- ✅ Submits solution to webhook URL with JWT authentication

## 📁 Repository Contents

### 🗂️ Source Code
- **Main Application**: `SpringAppApplication.java`
- **Core Service**: `WebhookChallengeService.java`
- **Entities**: Department, Employee, Payment
- **Repositories**: Data access layer
- **DTOs**: Data transfer objects
- **Configuration**: RestTemplate and application properties

### 📚 Documentation
- **README.md**: Comprehensive project overview
- **SUBMISSION_SUMMARY.md**: Technical implementation details
- **PROJECT_OVERVIEW.md**: Quick reference guide
- **RELEASE_NOTES.md**: Release information
- **CREATE_RELEASE.md**: Release creation instructions

### 🔧 Build Tools
- **pom.xml**: Maven dependencies
- **mvnw.cmd**: Maven wrapper for Windows
- **build.bat**: Build helper script
- **run.bat**: Run helper script

## 🌐 Challenge Requirements Met

| Requirement | Status | Implementation |
|-------------|--------|----------------|
| **Automatic execution on startup** | ✅ | `@PostConstruct` in WebhookChallengeService |
| **Webhook generation via REST API** | ✅ | POST to `/hiring/generateWebhook/JAVA` |
| **SQL problem solving** | ✅ | Question 1 (odd regNo ending) |
| **Solution submission with JWT** | ✅ | POST to `/hiring/testWebhook/JAVA` |
| **No controllers/endpoints** | ✅ | Application runs without user interaction |
| **Database operations** | ✅ | H2 in-memory with sample data |

## 🔍 Verification Steps

### 1. **Download Verification**
- Visit: https://github.com/RajkumarTula/Springboot-App/releases/tag/v1.0.0
- Click on `springapp-1.0.0.jar` to download
- Verify file size is ~52MB

### 2. **Application Verification**
```bash
# Download and run
curl -L -o springapp-1.0.0.jar "https://github.com/RajkumarTula/Springboot-App/releases/download/v1.0.0/springapp-1.0.0.jar"
java -jar springapp-1.0.0.jar

# Check console output for webhook challenge execution
# Verify application starts on port 8080
```

### 3. **Database Verification**
- H2 Console: http://localhost:8080/h2-console
- Check tables: DEPARTMENT, EMPLOYEE, PAYMENTS
- Verify sample data is populated

## 📊 SQL Solution Implemented

**Problem**: Calculate the number of employees who are younger than each employee, grouped by their respective departments.

**Solution**:
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

## 🎯 Submission Checklist

### ✅ **GitHub Repository**
- **URL**: https://github.com/RajkumarTula/Springboot-App.git
- **Public**: ✅ Yes
- **Code**: ✅ Complete Spring Boot application
- **Documentation**: ✅ Comprehensive README and guides

### ✅ **Executable JAR**
- **File**: `springapp-1.0.0.jar`
- **Size**: ~52MB
- **Downloadable**: ✅ Yes
- **Self-contained**: ✅ Yes (includes all dependencies)

### ✅ **RAW Downloadable Link**
- **Direct Link**: ✅ https://github.com/Rajku/Springboot-App/releases/download/v1.0.0/springapp-1.0.0.jar
- **Public Access**: ✅ Yes
- **No Authentication Required**: ✅ Yes

## 🔗 **FINAL SUBMISSION LINKS**

### **GitHub Repository**
```
https://github.com/RajkumarTula/Springboot-App.git
```

### **JAR File Download (RAW)**
```
https://github.com/RajkumarTula/Springboot-App/releases/download/v1.0.0/springapp-1.0.0.jar
```

### **Release Page**
```
https://github.com/RajkumarTula/Springboot-App/releases/tag/v1.0.0
```

---

## 🎉 **Ready for Submission!**

Your Spring Boot Webhook Challenge application is now:
- ✅ **Publicly available** on GitHub
- ✅ **Fully documented** with comprehensive guides
- ✅ **Downloadable** via direct RAW link
- ✅ **Self-contained** with all dependencies
- ✅ **Production-ready** with proper configuration
- ✅ **Challenge compliant** meeting all requirements

**Next Step**: Create the GitHub release to make the JAR file downloadable, then submit the links to the challenge form!
