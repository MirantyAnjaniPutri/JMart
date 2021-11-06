package mirantyJmartAK;

import java.util.ArrayList;
import java.util.Date;
import java.text.*;

/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Invoice extends Serializable
{
    Date date;
    public int  buyerId;
    public int productId;
    public Rating rating;
    public Status status;
    public static enum Rating {
        NONE, BAD, NEUTRAL, GOOD;
    }
    public static enum Status {
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED;
    }
    public ArrayList<Record> history = new ArrayList<Record>();
    
    public class Record {
        public Status status;
        public Date date;
        public String message;
    }
    
    protected Invoice() {
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        rating = Rating.NONE;
        status = Status.WAITING_CONFIRMATION;
    }
    
    public abstract double getTotalPay();
}
