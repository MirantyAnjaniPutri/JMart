package mirantyJmartAK;


/**
 * Write a description of class Coupon here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */
public class Coupon
{
    public static enum Type {
        DISCOUNT, REBATE
    }
    public static String name;
    public static int code;
    public static double cut;
    public static Type type;
    public static double minimum;
    private boolean used;
    
    public Coupon(String name, int code, Type type, double cut, double minimum) {
        this.used = false;
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
    }
    
    public boolean isUsed () {
        return used;
    }
    
    public boolean canApply(PriceTag priceTag) {
        if (priceTag.getAdjustedPrice() >= minimum && used == false) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public double apply (PriceTag priceTag) {
        this.used = true;
        if (type == Type.DISCOUNT) {
            if (cut >= 100) {
                return (double) priceTag.getAdjustedPrice() - (priceTag.getAdjustedPrice() * 100/100); //potongan diskon 100%
            }
            else if (cut <= 0) {
                return (double) priceTag.getAdjustedPrice() - (priceTag.getAdjustedPrice() * 0/100); //tidak ada potongan harga
            }
            else {
                return (double) priceTag.getAdjustedPrice() - (priceTag.getAdjustedPrice() * cut/100); //potongan harga sesuai nilai cut
            }
        }
        return (double) priceTag.getAdjustedPrice() - cut;
    }
    
}
