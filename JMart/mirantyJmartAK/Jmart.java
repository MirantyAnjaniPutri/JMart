package mirantyJmartAK;


/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
public class Jmart
{        
    /**
     * Constructor for objects of class Jmart
     */
    public static void main(String[] args) {
        
    }
    
    public static Product create() {
        return new Product(123, 456, "PC Yunho Kawinan", 50, true, new PriceTag(350.0), ProductCategory.TOYS);
    }
    
    
    public static Coupon createCoupun() {
        return null;
    }
    
    public static Shipment createShipment() {
        return null;
    }
}
