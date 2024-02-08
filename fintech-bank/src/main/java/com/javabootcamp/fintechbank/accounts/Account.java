package com.javabootcamp.fintechbank.accounts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "accounts")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // If we found an error try to replace this with GenerationType.IDENTITY
    private Integer no;
    private String type;
    private String name;
    private Double balance;
}
