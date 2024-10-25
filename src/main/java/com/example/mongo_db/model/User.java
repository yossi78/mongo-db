package com.example.mongo_db.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;


@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    private String id; // MongoDB uses String IDs

    private int age;
    private String firstName;
    private String lastName;
    private LocalDateTime creationTime = LocalDateTime.now();
    private Long salary;


}
