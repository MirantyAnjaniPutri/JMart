package com.mirantyJmartAK;


/**
 * Write a description of class ProductRating here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */

public class ProductRating
{
    private static long total;
    private static long count;
    
    public ProductRating () {
        ProductRating.total = 0;
        ProductRating.count = 0;
    }
    
    public void insert (int rating) {
        total += rating;
        count++;
    }
    
    public double getAverage() {
        if (count == 0) {
            System.out.println("No rating.");
            return 0.0;
        }
        else{
            return (double) total / count;
        }
    }
    
    //Getter variable Count
    public long getCount() {
        return count;
    }
    
    //Getter variable Total
    public long getTotal() {
        return total;
    }
}
