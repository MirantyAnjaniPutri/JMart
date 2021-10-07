package mirantyJmartAK;


/**
 * Write a description of class Product here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */

public class Product extends Recognizable implements FileParser
{    
    public int storeId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public Shipment.MultiDuration multiDuration;

    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration) {
        // main -> Product new Product = new Product(blablabla);
        super(id);
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
        this.multiDuration = multiDuration;
    }
    
    /*
    public Product (int id, Store store, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category) {
        super(id);
        this.storeId = store.id;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = new ProductRating();
    }*/
    
    public String toString() {
        return ("Name: " + name + "\nWeight: " + weight + "\nconditionUsed: " + conditionUsed + "\npriceTag: " + priceTag + "\ncategory: " + category + "\nrating: " + rating + "\nstoreId: " + storeId);
    }
    
    @Override
    public boolean read (String blabla) {
        return false;
    }
}