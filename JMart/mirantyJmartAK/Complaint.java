package mirantyJmartAK;

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
    Date date;
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
}
