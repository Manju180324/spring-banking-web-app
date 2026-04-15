package com.bank.app.user;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;
}


// What You Just Built
// Plain class
// Mapped to database table
// Managed by Hibernate/JPA

// So:
// “This is a JPA Entity, not just a POJO”
