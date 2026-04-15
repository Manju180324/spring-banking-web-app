package com.bank.app.transaction;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDTO {

    private Long id;
    private Double amount;
    private String type;
    private LocalDateTime timestamp;

    private Long fromAccountId;
    private Long toAccountId;
}