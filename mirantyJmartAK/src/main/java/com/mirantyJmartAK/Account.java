package com.mirantyJmartAK;

import com.mirantyJmartAK.controller.BasicGetController;
import com.mirantyJmartAK.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Account here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */
public class Account extends Serializable implements BasicGetController
{
    public final String REGEX_EMAIL = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
    public final String REGEX_PASSWORD = "^\\?=.*[0-9]" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=\\S+$).{8,20}$";
    public String name;
    public static String email;
    public static String password;
    
    public Account(String name, String email, String password, int id) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String toString() {
        return ("Name: " + name + "\nEmail: " + email + "\nPassword: " + password);
    }
    
    public boolean validate() {
        Pattern formatE = Pattern.compile(REGEX_EMAIL);
        Matcher cekEm = formatE.matcher(email);
        boolean cekMail = cekEm.find();
        
        Pattern formatP = Pattern.compile(REGEX_PASSWORD);
        Matcher cekPW = formatP.matcher(password);
        boolean cekPass = cekPW.find();
        
        if (cekMail == true && cekPass == true) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Serializable other) {
        if (id == other.id) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
