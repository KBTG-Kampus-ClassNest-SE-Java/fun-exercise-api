package com.javabootcamp.fintechbank.accounts;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/accounts")
@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "" ,method = RequestMethod.GET)
    public List<AccountResponse> getAccounts() {
        return accountService.getAccounts();
    }

    @RequestMapping(value = "/{accountNo}/deposit" ,method = RequestMethod.POST)
    public AccountResponse depositAccount(
            @PathVariable(name = "accountNo") Integer accountNo,
            @RequestBody @Valid DepositRequest depositRequest
    ) {
        return accountService.depositAccount(accountNo, depositRequest);
    }
}
