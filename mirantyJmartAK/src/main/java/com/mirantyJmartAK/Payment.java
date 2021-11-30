package com.mirantyJmartAK;


import java.util.ArrayList;
import java.util.Date;

/**
 * Write a description of class Payment here.
 *
 * @author Miranty Anjani
 * @version (a version number or a date)
 */
public class Payment extends Invoice
{
    public int productCount;
    public Shipment shipment;
    public ArrayList<Record> history = new ArrayList<Record>();

    public Payment (Integer buyerId, Integer productId, Integer productCount, Shipment shipment) {
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }

    public static class Record {
        public Status status;
        public final Date date;
        public String message;

        public Record(Status status, String message) {
            this.status = status;
            this.message = message;
            this.date = java.util.Calendar.getInstance().getTime();
        }
    }

    @Override
    public double getTotalPay(Product product) {
        return product.price * product.discount * productCount;
    }
}
