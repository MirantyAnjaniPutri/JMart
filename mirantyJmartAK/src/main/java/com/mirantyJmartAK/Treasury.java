package com.mirantyJmartAK;

/**
 * @author Miranty Anjani Putri
 */

// + = public
// - = private
// underlined = static

public class Treasury {
    public static double COMMISSION_MULTIPLIER = 0.05;
    public static double BOTTOM_PRICE = 20000.0;
    public static double BOTTOM_FEE = 1000.0;

    public double price, discount;

    private double getDiscountedPrice(double price, double discount) {
        if (discount >= 100) {
            return 0.0;
        }
        else {
            return price - (price * discount / 100);
        }
    }
    
    public static double getAdjustedPrice(double price, double discount) {
        return price + getAdminFee(price,discount);
    }
    
    public static double getAdminFee(double price, double discount) {
        if (price < BOTTOM_PRICE) {
            return BOTTOM_FEE;
        }
        else {
            return price - (price * COMMISSION_MULTIPLIER);
        }
    }
}
