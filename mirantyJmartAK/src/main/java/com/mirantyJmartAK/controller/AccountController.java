package com.mirantyJmartAK.controller;

import com.mirantyJmartAK.Account;
import com.mirantyJmartAK.Coupon;
import com.mirantyJmartAK.Store;
import com.mirantyJmartAK.dbjson.JsonAutowired;
import com.mirantyJmartAK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
// Post-Test Modul 8
import javax.accessibility.AccessibleIcon;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.io.IOException;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    public static final String REGEX_EMAIL = "";
    public static final String REGEX_PASSWORD = "";
    public static final String REGEX_PATTERN_EMAIL = "";
    public static final String REGEX_PATTERN_PASSWORD = "";

    public static @JsonAutowired
            (value = Account.class, filepath = "C:\\Users\\Lenovo\\OneDrive\\Documents\\randomPaymentList.json")
    JsonTable<Account> accountTable;

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
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(password.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            password = hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
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

    /*@GetMapping("/{id}")
    String getById(@PathVariable int id) { return "account id " + id + " not found!"; }*/
}