package com.mirantyJmartAK;

import com.mirantyJmartAK.dbjson.Serializable;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class functions as an invoice.
 * It will record the date, buyerId, complaintId,
 * productId, rating, status of the order.
 *
 * @author Miranty Anjani Putri
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
        BAD, GOOD, NEUTRAL, NONE;
    }

    public enum Status {
        CANCELLED, COMPLAINT, FAILED, FINISHED, ON_DELIVERY, ON_PROGRESS, WAITING_CONFIRMATION;
    }

    /**
     * Invoice constructor
     * @param buyerId
     * @param productId
     */
    protected Invoice(int buyerId, int productId) {
        this.buyerId = buyerId;
        this.productId = productId;
        this.complaintId = -1;
        this.date = java.util.Calendar.getInstance().getTime();
        rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
    }

    public class Record {
        public Status status;
        public Date date;
        public String message;
    }
    
    public abstract double getTotalPay(Product product);
}
