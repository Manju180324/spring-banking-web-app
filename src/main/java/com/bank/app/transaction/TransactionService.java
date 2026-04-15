package com.bank.app.transaction;

import com.bank.app.account.Account;
import com.bank.app.account.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final AccountRepository accountRepository;
    private final  TransactionRepository transactionRepository;

    @Transactional
    public void transfer(Long fromAccountId, Long toAccountId, Double amount) {

        // STEP 1: Fetch accounts
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("Sender account not found"));

        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new RuntimeException("Receiver account not found"));

        // STEP 2: Check balance
        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        // STEP 3: Deduct from sender
        fromAccount.setBalance(fromAccount.getBalance() - amount);

        // STEP 4: Add to receiver
        toAccount.setBalance(toAccount.getBalance() + amount);

        // STEP 5: Save updated accounts
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        // STEP 6: Record transaction
        Transaction tx = new Transaction();
        tx.setAmount(amount);
        tx.setType("TRANSFER");
        tx.setTimestamp(LocalDateTime.now());
        tx.setFromAccount(fromAccount);
        tx.setToAccount(toAccount);

        transactionRepository.save(tx);
    }
}
