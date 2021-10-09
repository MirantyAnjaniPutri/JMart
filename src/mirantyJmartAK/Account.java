package mirantyJmartAK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;

/**
 * Write a description of class Account here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */
public class Account extends Recognizable implements FileParser
{
    public final String REGEX_EMAIL = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
    public final String REGEX_PASSWORD = "^\\(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=\\S+$).{8,20}$";
    public String name;
    public String email;
    public String password;
    
    public Account(int id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString() {
        return ("Name: " + name + "\nEmail: " + email + "\nPassword: " + password);
    }
    
    @Override
    public boolean read (String content) {
        return false;
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
    public int compareTo(Recognizable other) {
        if (id == other.id) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
