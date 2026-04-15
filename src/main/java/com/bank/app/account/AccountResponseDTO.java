package com.bank.app.account;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseDTO {

    private Long id;
    private String accountType;
    private Double balance;

    // Instead of sending full user object
    private Long userId;
}
