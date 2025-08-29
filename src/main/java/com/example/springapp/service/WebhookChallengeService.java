package com.example.springapp.service;

import com.example.springapp.dto.SolutionRequest;
import com.example.springapp.dto.WebhookRequest;
import com.example.springapp.dto.WebhookResponse;
import com.example.springapp.entity.Department;
import com.example.springapp.entity.Employee;
import com.example.springapp.entity.Payment;
import com.example.springapp.repository.DepartmentRepository;
import com.example.springapp.repository.EmployeeRepository;
import com.example.springapp.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WebhookChallengeService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    private static final String WEBHOOK_GENERATION_URL = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";
    private static final String SOLUTION_SUBMISSION_URL = "https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA";

    @PostConstruct
    public void runChallenge() {
        try {
            System.out.println("Starting webhook challenge...");
            
            // Step 1: Generate webhook
            WebhookResponse webhookResponse = generateWebhook();
            if (webhookResponse == null) {
                System.out.println("Failed to generate webhook. Exiting...");
                return;
            }
            
            System.out.println("Webhook generated successfully!");
            System.out.println("Webhook URL: " + webhookResponse.getWebhook());
            
            // Step 2: Initialize database with sample data
            initializeDatabase();
            
            // Step 3: Solve the SQL problem
            String sqlSolution = solveSqlProblem();
            System.out.println("SQL Solution generated: " + sqlSolution);
            
            // Step 4: Submit solution
            boolean submissionSuccess = submitSolution(webhookResponse.getAccessToken(), sqlSolution);
            if (submissionSuccess) {
                System.out.println("Solution submitted successfully!");
            } else {
                System.out.println("Failed to submit solution.");
            }
            
        } catch (Exception e) {
            System.err.println("Error during webhook challenge: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private WebhookResponse generateWebhook() {
        try {
            WebhookRequest request = new WebhookRequest("John Doe", "REG12347", "john@example.com");
            
            HttpEntity<WebhookRequest> entity = new HttpEntity<>(request);
            ResponseEntity<WebhookResponse> response = restTemplate.postForEntity(
                WEBHOOK_GENERATION_URL, entity, WebhookResponse.class);
            
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return response.getBody();
            }
            
            System.err.println("Failed to generate webhook. Status: " + response.getStatusCode());
            return null;
            
        } catch (Exception e) {
            System.err.println("Error generating webhook: " + e.getMessage());
            return null;
        }
    }

    private void initializeDatabase() {
        try {
            // Clear existing data
            paymentRepository.deleteAll();
            employeeRepository.deleteAll();
            departmentRepository.deleteAll();
            
            // Insert departments
            List<Department> departments = List.of(
                new Department(1L, "HR"),
                new Department(2L, "Finance"),
                new Department(3L, "Engineering"),
                new Department(4L, "Sales"),
                new Department(5L, "Marketing"),
                new Department(6L, "IT")
            );
            departmentRepository.saveAll(departments);
            
            // Insert employees
            List<Employee> employees = List.of(
                new Employee(1L, "John", "Williams", LocalDate.of(1980, 5, 15), "Male", 3L),
                new Employee(2L, "Sarah", "Johnson", LocalDate.of(1990, 7, 20), "Female", 2L),
                new Employee(3L, "Michael", "Smith", LocalDate.of(1985, 2, 10), "Male", 3L),
                new Employee(4L, "Emily", "Brown", LocalDate.of(1992, 11, 30), "Female", 4L),
                new Employee(5L, "David", "Jones", LocalDate.of(1988, 9, 5), "Male", 5L),
                new Employee(6L, "Olivia", "Davis", LocalDate.of(1995, 4, 12), "Female", 1L),
                new Employee(7L, "James", "Wilson", LocalDate.of(1983, 3, 25), "Male", 6L),
                new Employee(8L, "Sophia", "Anderson", LocalDate.of(1991, 8, 17), "Female", 4L),
                new Employee(9L, "Liam", "Miller", LocalDate.of(1979, 12, 1), "Male", 1L),
                new Employee(10L, "Emma", "Taylor", LocalDate.of(1993, 6, 28), "Female", 5L)
            );
            employeeRepository.saveAll(employees);
            
            // Insert payments
            List<Payment> payments = List.of(
                new Payment(1L, 2L, new BigDecimal("65784.00"), LocalDateTime.of(2025, 1, 1, 13, 44, 12, 824000000)),
                new Payment(2L, 4L, new BigDecimal("62736.00"), LocalDateTime.of(2025, 1, 6, 18, 36, 37, 892000000)),
                new Payment(3L, 1L, new BigDecimal("69437.00"), LocalDateTime.of(2025, 1, 1, 10, 19, 21, 563000000)),
                new Payment(4L, 3L, new BigDecimal("67183.00"), LocalDateTime.of(2025, 1, 2, 17, 21, 57, 341000000)),
                new Payment(5L, 2L, new BigDecimal("66273.00"), LocalDateTime.of(2025, 2, 1, 11, 49, 15, 764000000)),
                new Payment(6L, 5L, new BigDecimal("71475.00"), LocalDateTime.of(2025, 1, 1, 7, 24, 14, 453000000)),
                new Payment(7L, 1L, new BigDecimal("70837.00"), LocalDateTime.of(2025, 2, 3, 19, 11, 31, 553000000)),
                new Payment(8L, 6L, new BigDecimal("69628.00"), LocalDateTime.of(2025, 1, 2, 10, 41, 15, 113000000)),
                new Payment(9L, 4L, new BigDecimal("71876.00"), LocalDateTime.of(2025, 2, 1, 12, 16, 47, 807000000)),
                new Payment(10L, 3L, new BigDecimal("70098.00"), LocalDateTime.of(2025, 2, 3, 10, 11, 17, 341000000)),
                new Payment(11L, 6L, new BigDecimal("67827.00"), LocalDateTime.of(2025, 2, 2, 19, 21, 27, 753000000)),
                new Payment(12L, 5L, new BigDecimal("69871.00"), LocalDateTime.of(2025, 2, 5, 17, 54, 17, 453000000)),
                new Payment(13L, 2L, new BigDecimal("72984.00"), LocalDateTime.of(2025, 3, 5, 9, 37, 35, 974000000)),
                new Payment(14L, 1L, new BigDecimal("67982.00"), LocalDateTime.of(2025, 3, 1, 6, 9, 51, 983000000)),
                new Payment(15L, 6L, new BigDecimal("70198.00"), LocalDateTime.of(2025, 3, 2, 10, 34, 35, 753000000)),
                new Payment(16L, 4L, new BigDecimal("74998.00"), LocalDateTime.of(2025, 3, 2, 9, 27, 26, 162000000))
            );
            paymentRepository.saveAll(payments);
            
            System.out.println("Database initialized with sample data.");
            
        } catch (Exception e) {
            System.err.println("Error initializing database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String solveSqlProblem() {
        // Based on the problem statement, we need to calculate the number of employees 
        // who are younger than each employee, grouped by their respective departments.
        // The regNo ends with "47" which is odd, so we use Question 1.
        
        return """
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
            """;
    }

    private boolean submitSolution(String accessToken, String sqlSolution) {
        try {
            SolutionRequest request = new SolutionRequest(sqlSolution);
            
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", accessToken);
            headers.set("Content-Type", "application/json");
            
            HttpEntity<SolutionRequest> entity = new HttpEntity<>(request, headers);
            ResponseEntity<String> response = restTemplate.exchange(
                SOLUTION_SUBMISSION_URL, HttpMethod.POST, entity, String.class);
            
            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Solution submission response: " + response.getBody());
                return true;
            } else {
                System.err.println("Failed to submit solution. Status: " + response.getStatusCode());
                return false;
            }
            
        } catch (Exception e) {
            System.err.println("Error submitting solution: " + e.getMessage());
            return false;
        }
    }
}
