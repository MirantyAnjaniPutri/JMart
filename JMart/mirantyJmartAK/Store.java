package mirantyJmartAK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Write a description of class Store here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */
public class Store extends Recognizable implements FileParser
{
    public static final String REGEX_PHONE = "^[\\d{9-12}]$";
    public static final String REGEX_NAME = "^[[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}]$";
    public String name;
    public String address;
    public String phoneNumber;
    
    public Store (int accountId, String name, String address, String phoneNumber) {
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public Store (Account account, String name, String address, String phoneNumber) {
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public String toString() {
        return ("Name: " + name + "\nAddress: " + address + "\nphoneNumber: " + phoneNumber);
    }
    
    public boolean validate() {
        Pattern formatP = Pattern.compile(REGEX_PHONE);
        Matcher cekPh = formatP.matcher(phoneNumber);
        boolean cekPN = cekPh.find();
        
        Pattern formatN = Pattern.compile(REGEX_NAME);
        Matcher cekName = formatN.matcher(name);
        boolean cekNama = cekName.find();
        
        if (cekPN == true && cekNama == true) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean read (String content) {
        return false;
    }
}
