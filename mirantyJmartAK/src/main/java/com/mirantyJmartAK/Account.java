package com.mirantyJmartAK;

import com.mirantyJmartAK.dbjson.Serializable;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Account here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */
public class Account extends Serializable
{
    private static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";
    private static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
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
