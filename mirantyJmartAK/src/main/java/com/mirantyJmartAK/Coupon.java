package com.mirantyJmartAK;


import com.mirantyJmartAK.dbjson.Serializable;

/**
 * This class functions as a coupon.
 * It is made so user can apply the coupon,
 * and receives more discount.
 *
 * @author Miranty Anjani Putri
 */
public class Coupon extends Serializable
{

    public static enum Type {
        DISCOUNT, REBATE
    }
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public static double minimum;
    private static boolean used;
    
    public Coupon(String name, int code, Type type, double cut, double minimum) {
        used = false;
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        Coupon.minimum = minimum;
    }
    
    public boolean isUsed () {
        return used;
    }
    
    public boolean canApply(double price, double discount) {
        return (Treasury.getAdjustedPrice(price, discount) < minimum) && used == false;
    }
    
    public double apply (Treasury treasury) {
        used = true;
        double adjustedPrice = Treasury.getAdjustedPrice(treasury.price, treasury.discount);
        switch (type)
        {
            case REBATE:
                if (adjustedPrice <= cut) return 0.0;
                return adjustedPrice - cut;
            case DISCOUNT:
                if (cut >= 100.0) return 0.0;
                return adjustedPrice - adjustedPrice * (cut / 100);
        }
        return 0.0;
    }
}
