package com.bank.app.account;


import com.bank.app.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountType;
    private Double balance = 0.0;

    @ManyToOne // Many accounts → one user
    @JoinColumn(name = "user_id") //foreign key
    private User user;

}
