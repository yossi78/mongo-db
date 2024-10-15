package com.example.mongo_db.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "users")
public class User {
    @Id
    private String id; // MongoDB uses String IDs

    private int age;
    private String firstName;
    private String lastName;
    private LocalDateTime creationTime;
    private Long salary;

    // Constructors
    public User() {
        this.creationTime = LocalDateTime.now();
    }

    public User(int age, String firstName, String lastName, Long salary) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.creationTime = LocalDateTime.now();
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    // No setter for ID as it's auto-generated by MongoDB

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()){
            throw new IllegalArgumentException("First name cannot be empty.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()){
            throw new IllegalArgumentException("Last name cannot be empty.");
        }
        this.lastName = lastName;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }


    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        if(salary < 0){
            throw new IllegalArgumentException("Salary cannot be negative.");
        }
        this.salary = salary;
    }
}