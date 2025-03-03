package com.mirantyJmartAK;

import com.mirantyJmartAK.dbjson.Serializable;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class stores the information of
 * user's needed data, such as name, email, password,
 * balance, and their store.
 *
 * @author Miranty Anjani Putri
 */
public class Account extends Serializable
{
    /**
     * Regex is used so the user's email can accept any alphabet and numerical characters before @
     * needs @ then domain, dot (.) and another co-domain.
     * Regex password is used so it can accept any alphabet and numerical characters, as long as the
     * first character is a capital alphabet. Minimum length is 8.
     */
    private static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";
    private static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    /**
     * Data variables stored in Account class.
     */
    public double balance;
    public String name;
    public String email;
    public String password;
    public Store store;
    
    public Account(String name, String email, String password, double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public boolean validate() {
        Pattern formatE = Pattern.compile(REGEX_EMAIL);
        Matcher cekEm = formatE.matcher(email);
        boolean cekMail = cekEm.find();
        boolean hasilMail = cekMail ? true : false;
        
        Pattern formatP = Pattern.compile(REGEX_PASSWORD);
        Matcher cekPW = formatP.matcher(password);
        boolean cekPass = cekPW.find();
        boolean hasilPass = cekPass ? true : false;
        
        if (hasilMail == true && hasilPass == true) {
            return true;
        } else {
            return false;
        }
    }
}
