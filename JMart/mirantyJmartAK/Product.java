package mirantyJmartAK;


/**
 * Write a description of class Product here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */

public class Product
{
    private static int idCounter;
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    PriceTag priceTag;
    ProductCategory category;
    ProductRating rating; 
}

/**
public class Product(String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category) {

}
*/
