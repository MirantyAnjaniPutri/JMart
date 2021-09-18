package mirantyJmartAK;

/**
 * @author Miranty Anjani Putri
 */

// + = public
// - = private
// underlined = static

public class PriceTag
{
    public static double COMMISSION_MULTIPLIER = 0.05;
    public static double BOTTOM_PRICE = 20000;
    public static double BOTTOM_FEE = 1000;
    
    public double discount;
    public double price;
    
    public PriceTag (double price) {
        this.price = price;
        this.discount = 0.0;
    }
    
    public PriceTag (double price, double discount) {
        this.price = price;
        this.discount = discount;
    }
    
    private double getDiscountedPrice() {
        if (this.discount >= 100) {
            this.discount = 100.0;
            return this.price = 0.0;
        }
        else {
            this.price = this.price - (this.price * this.discount / 100);
            return this.price;
        }
    }
    
    public double getAdjustedPrice () {
        return this.price + getAdminFee();
    }
    
    public double getAdminFee () {
        if (this.price < BOTTOM_PRICE) {
            return BOTTOM_FEE;
        }
        else {
            return this.price - (this.price * COMMISSION_MULTIPLIER);
        }
    }
}
