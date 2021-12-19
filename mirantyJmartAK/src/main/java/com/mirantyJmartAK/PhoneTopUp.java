package com.mirantyJmartAK;

/**
 * This is class functions so user can top-up
 * their balance. Making their shopping experience easier.
 *
 * @author Miranty Anjani
 */

public class PhoneTopUp extends Invoice {
    public String phoneNumber;
    public Invoice.Status status;

    public PhoneTopUp(int buyerId, int productId, String phoneNumber) {
        super(buyerId,productId);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public double getTotalPay(Product product) {
        return product.price * product.discount;
    }
 }
