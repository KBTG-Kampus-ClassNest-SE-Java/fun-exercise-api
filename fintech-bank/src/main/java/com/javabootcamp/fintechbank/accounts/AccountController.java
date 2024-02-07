package com.javabootcamp.fintechbank.accounts;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/accounts")
@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(summary = "list all accounts")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "list all accounts",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = AccountResponse.class)))
                    })
    })

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<AccountResponse> getAccounts() {
        return accountService.getAccounts();
    }


    @Operation(summary = "deposits an amount to the account")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "withdraw money from specific account",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = AccountResponse.class))
                    })
    })
    @RequestMapping(value = "/{accountNo}/deposit", method = RequestMethod.POST)
    public AccountResponse depositAccount(
            @PathVariable(name = "accountNo") Integer accountNo,
            @RequestBody @Valid DepositRequest depositRequest
    ) {
        return accountService.depositAccount(accountNo, depositRequest);
    }

    @Operation(summary = "creates an account")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "create an account",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = AccountResponse.class))
                    })
    })
    @RequestMapping(value = "", method = RequestMethod.POST)
    public AccountResponse createAccount(@RequestBody @Valid CreateAccountRequest createAccountRequest){

        return accountService.createAccount(createAccountRequest);
    }
}

