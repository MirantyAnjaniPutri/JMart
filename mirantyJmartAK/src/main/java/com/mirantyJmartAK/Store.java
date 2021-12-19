package com.mirantyJmartAK;

import com.mirantyJmartAK.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * This is class for representing a store.
 *
 * @author Miranty Anjani Putri
 */
public class Store extends Serializable
{
    public static final String REGEX_PHONE = "^[\\^[0-9]{10,12}$]";
    public static final String REGEX_NAME = "^[[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}]$";
    public String name;
    public String address;
    public String phoneNumber;
    public double balance;
    
    public Store (String name, String address, String phoneNumber, double balance) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
    
    public String toString() {
        return ("Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nBalance: " + balance);
    }
    
    public boolean validate() {
        Pattern formatP = Pattern.compile(REGEX_PHONE);
        Matcher cekPh = formatP.matcher(phoneNumber);
        boolean cekPN = cekPh.find();
        boolean hasilPN = cekPN ? true : false;
        
        Pattern formatN = Pattern.compile(REGEX_NAME);
        Matcher cekName = formatN.matcher(name);
        boolean cekNama = cekName.find();
        boolean hasilNama = cekNama ? true : false;
        
        if (hasilPN == true && hasilNama == true) {
            return true;
        } else {
            return false;
        }
    }
}
