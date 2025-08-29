@echo off
echo Building Spring Boot Application...
echo.

echo Checking if Maven is available...
mvn --version >nul 2>&1
if %errorlevel% neq 0 (
    echo Maven not found. Please install Maven or use the following alternatives:
    echo.
    echo Option 1: Install Maven from https://maven.apache.org/download.cgi
    echo Option 2: Use Maven Wrapper (mvnw) if available
    echo Option 3: Use an IDE like IntelliJ IDEA or Eclipse
    echo.
    pause
    exit /b 1
)

echo Maven found. Building project...
mvn clean package -DskipTests

if %errorlevel% equ 0 (
    echo.
    echo Build successful! JAR file created at: target/springapp-1.0.0.jar
    echo.
    echo To run the application:
    echo java -jar target/springapp-1.0.0.jar
    echo.
    pause
) else (
    echo.
    echo Build failed! Please check the error messages above.
    echo.
    pause
    exit /b 1
)
