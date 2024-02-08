package com.javabootcamp.fintechbank.accounts;

import com.javabootcamp.fintechbank.exceptions.BadRequestException;
import com.javabootcamp.fintechbank.exceptions.InternalServerException;
import com.javabootcamp.fintechbank.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountResponse> getAccounts() {
        return accountRepository
                .findAll()
                .stream()
                .map(acc -> new AccountResponse(acc.getNo(), acc.getType(), acc.getName(), acc.getBalance()))
                .toList();
    }

    public AccountResponse depositAccount(Integer accountNo, DepositRequest depositRequest) {
        Optional<Account> optionalAccount = accountRepository.findById(accountNo);
        if (optionalAccount.isEmpty()) {
            throw new NotFoundException("Account not found");
        }

        Account account = optionalAccount.get();
        Double newBalance = account.getBalance() + depositRequest.amount();
        account.setBalance(newBalance);

        try {
            accountRepository.save(account);
        } catch (Exception e) {
            throw new InternalServerException("Failed to deposit");
        }
        return new AccountResponse(account.getNo(), account.getType(), account.getName(), account.getBalance());
    }

    @Transactional
    public AccountResponse createAccount(CreateAccountRequest createAccountRequest) {

        String checkType = createAccountRequest.type();
        if (checkType.equals("SAVING") || checkType.equals("Checking") || checkType.equals("CURRENT")) {
            System.out.println("Valid account type");
        }
        else {
            throw new BadRequestException("Invalid account type");
        }

        Optional<Account> optionalAccount = accountRepository.findByName(createAccountRequest.name());

        if (optionalAccount.isPresent()) {
            throw new BadRequestException("Account name already exists");
        }

        Account newAccount = new Account();
        newAccount.setType(createAccountRequest.type());
        newAccount.setName(createAccountRequest.name());
        newAccount.setBalance(createAccountRequest.balance());

        try {
            accountRepository.save(newAccount);
        } catch (Exception e) {
            throw new InternalServerException("Failed to create account");
        }
        return new AccountResponse(newAccount.getNo(), newAccount.getType(), newAccount.getName(), newAccount.getBalance());
    }
}