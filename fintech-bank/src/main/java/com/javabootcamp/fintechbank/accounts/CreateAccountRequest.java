package com.javabootcamp.fintechbank.accounts;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateAccountRequest(

        @NotNull
        String type,
        @NotNull
        @Size(min = 3, max = 50, message = "name must be between 3 and 50 characters")
        String name,

        @NotNull
        Double balance

        ){
}
