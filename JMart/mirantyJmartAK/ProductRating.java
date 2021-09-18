package mirantyJmartAK;


/**
 * Write a description of class ProductRating here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */

public class ProductRating
{
    private long total;
    private long count;
    
    public ProductRating () {
        this.total = 0;
        this.count = 0;
    }
    
    public void insert (int rating) {
        this.total += rating;
        this.count++;
    }
    
    public double getAverage() {
        if (this.count == 0) {
            System.out.println("Operasi divide by zero tidak bisa dilakukan.");
        }
        return (double) this.total / this.count;
    }
    
    public long getCount() {
        return this.count;
    }
    
    public long getTotal() {
        return this.total;
    }
}
