package com.bank.app.account;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    private Account createAccount(@RequestParam Long userId,
                                  @RequestParam String accountType,
                                  @RequestParam Double balance) {
        return accountService.createAccount(userId, accountType, balance);

    }
}
