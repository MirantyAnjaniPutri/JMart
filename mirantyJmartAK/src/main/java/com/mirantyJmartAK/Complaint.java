package com.mirantyJmartAK;

import com.mirantyJmartAK.dbjson.Serializable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class controls the complaints of the user.
 * It stores the description, and the date when the complaint
 * is made.
 *
 * @author Miranty Anjani
 */
public class Complaint extends Serializable
{
    public Date date;
    public String desc;

    
    public Complaint(String desc) {
        this.desc = desc;
        this.date = new Date();
    }
    
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");
        String strDate = formatter.format(date);
        return ("Complaint {date= " + strDate + ", desc = '" + desc + "'}");
    }
}
