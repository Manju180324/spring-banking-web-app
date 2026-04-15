package com.bank.app.transaction;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionRepository transactionRepository;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long fromAccountId,
                           @RequestParam Long toAccountId,
                           @RequestParam Double amount) {
        transactionService.transfer(fromAccountId, toAccountId, amount);

        return "Transfer successful";
    }

    @GetMapping("/account")
    public List<TransactionResponseDTO> getTransactionsByAccount(@RequestParam Long accountId) {
        return transactionService.getTransactionsByAccount(accountId);
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam Long accountId,
                          @RequestParam Double amount){
        transactionService.deposit(accountId, amount);
        return "Deposit successful";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam Long accountId,
                           @RequestParam Double amount){
        transactionService.withdraw(accountId, amount);
        return "Withdraw successful";
    }
}
