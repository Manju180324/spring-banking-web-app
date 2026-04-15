package com.bank.app.account;

import com.bank.app.user.User;
import com.bank.app.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public Account createAccount(Long userId, String accountType, Double balance) {
        // Get user from DB
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Create account object
        Account account = new Account();

        //LINK account to user
        account.setUser(user);
        account.setAccountType(accountType);
        account.setBalance(balance);

        return accountRepository.save(account);
    }
}
