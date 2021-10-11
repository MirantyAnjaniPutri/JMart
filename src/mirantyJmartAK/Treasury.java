package mirantyJmartAK;

/**
 * @author Miranty Anjani Putri
 */

// + = public
// - = private
// underlined = static

public class Treasury {
    public static double COMMISSION_MULTIPLIER = 0.05;
    public static double BOTTOM_PRICE = 20000;
    public static double BOTTOM_FEE = 1000;

    public double price, discount;

    private double getDiscountedPrice(double price, double discount) {
        if (discount >= 100) {
            discount = 100.0;
            return price = 0.0;
        }
        else {
            price = price - (price * discount / 100);
            return price;
        }
    }
    
    public double getAdjustedPrice (double price, double discount) {
        return price + getAdminFee(price,discount);
    }
    
    public double getAdminFee (double price, double discount) {
        if (price < BOTTOM_PRICE) {
            return BOTTOM_FEE;
        }
        else {
            return price - (price * COMMISSION_MULTIPLIER);
        }
    }
}
