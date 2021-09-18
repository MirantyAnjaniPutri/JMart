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
    public int getPromo() {
        return 0;
    }
    
    public static String getCustomer() {
        return "oop";
    }
    
    public static float getDiscountPercentage(int before, int after) {
        float hasil;
        if (before >= after) {
            hasil = (before - after) / 100;
            return hasil;
        }
        else {
            return 0.0f;
        }
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage) {
        int discountedPrice;
        int discountPercent = (int)discountPercentage;
        if (discountPercent > 100) {
            discountPercent = 100;
            return 0;
        }
        else {
            discountedPrice = price - ((discountPercent / 100) * price);
            return discountedPrice;
        }
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage) {
        int discountPercent = (int) discountPercentage;
        int originalPrice;
        if (discountPercentage > 0) {
            originalPrice = (discountedPrice / (100 - discountPercent)) * 100;
            return originalPrice;
        }
        else {
            return discountedPrice;
        }
    }
    
    public static float getCommisionMultiplier() {
        return 0.05f;
    }
    
    public static int getAdjustedPrice(int price) {
        float price1 = (float) price;
        float adjustedPrice1 = price1 + (price1 * getCommisionMultiplier());
        int adjustedPrice = (int) adjustedPrice1;
        return adjustedPrice;
    }
    
    public static int getAdminFee(int price) {
        float price1 = (float) price;
        float adminFee1 = price1 * getCommisionMultiplier();
        int adminFee = (int) adminFee1;
        return adminFee;
    }
        
    /**
     * Constructor for objects of class Jmart
     */
    public static void main(String[] args) {
        
    }
    
    public static Product create() {
        return null;
    }
}
