@echo off
echo Running Spring Boot Application...
echo.

if exist "target\springapp-1.0.0.jar" (
    echo JAR file found. Starting application...
    java -jar target\springapp-1.0.0.jar
) else (
    echo JAR file not found. Please build the project first using:
    echo mvnw.cmd clean package
    echo.
    echo Or if you have Maven installed:
    echo mvn clean package
    echo.
    pause
)
