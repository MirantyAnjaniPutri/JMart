package mirantyJmartAK;

import java.util.Date;
import java.text.*;

/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Invoice extends Recognizable implements FileParser
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
    
    protected Invoice (int id, int buyerId, int productId) {
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        rating = Rating.NONE;
        status = Status.WAITING_CONFIRMATION;
    }
    
    public abstract double getTotalPay();
    
    @Override
    public boolean read (String content) {
        return false;
    }
    
    public Object write () {
        return null;
    }
}
