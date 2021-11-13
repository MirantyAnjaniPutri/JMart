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
    public final Date date;
    public int  buyerId;
    public int complaintId;
    public int productId;
    public Rating rating;
    public Status status;
    public static enum Rating {
        NONE, BAD, NEUTRAL, GOOD;
    }

    public enum Status {
        WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, COMPLAINT, FINISHED, FAILED;
    }
    
    protected Invoice(int buyerId, int productId) {
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        rating = Rating.NONE;
    }
    
    public abstract double getTotalPay();
}
