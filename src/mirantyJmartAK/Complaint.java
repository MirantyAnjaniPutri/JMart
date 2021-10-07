package mirantyJmartAK;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.*;

/**
 * Write a description of class Complaint here.
 *
 * @author Miranty Anjani
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    public Date date;
    public String desc;

    
    public Complaint(int id, String desc) {
        super(id);
        this.desc = desc;
        this.date = new Date();
    }

    @Override
    public boolean read (String content) {
        return false;
    }
    
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");
        String strDate = formatter.format(date);
        return ("Complaint {date= " + strDate + ", desc = '" + desc + "'}");
    }
}
