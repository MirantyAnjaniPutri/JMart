package com.mirantyJmartAK.controller;

import com.mirantyJmartAK.Account;
import com.mirantyJmartAK.Store;
import com.mirantyJmartAK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    public static final String REGEX_EMAIL = "";
    public static final String REGEX_PASSWORD = "";
    public static final String REGEX_PATTERN_EMAIL = "";
    public static final String REGEX_PATTERN_PASSWORD = "";
    public static JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable () {
        return accountTable;
    }

    @PostMapping("/login")
    Account login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        if (email.equals(Account.email) && password.equals(Account.password)) {
            return null;
        } else {
            return null;
        }
    }

    /*@GetMapping
    String index() { return "account page"; }*/

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        return new Account(name, email, password, 0);
    }

    @PostMapping("/{id}/storeRegister")
    Store registerStore
            (
                    /*
                    @RequestParam id,
                    @RequestParam name,
                    @RequestParam address,
                    @RequestParam phoneNumber
                     */
            )
    {
        return null;
    }

    boolean topUp (int id, double balance) {
        return true;
    }

    /*
    @GetMapping("/{id}")
    String getById(@PathVariable int id) { return "account id " + id + " not found!"; }
    */
}