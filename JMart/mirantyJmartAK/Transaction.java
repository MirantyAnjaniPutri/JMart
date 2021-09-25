package mirantyJmartAK;


/**
 * Write a description of class Transaction here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */
public class Transaction extends Recognizable
{
    public static enum Rating {
        NONE, BAD, NEUTRAL, GOOD;
    }
    public String time = null;
    public int buyerId;
    public int storeId;
    public ProductRating rating;
    
    protected Transaction (int id, int buyerId, int storeId) {
        super(id);
        this.buyerId = buyerId;
        this.storeId = storeId;
    }
    
    
    protected Transaction (int id, Account buyer, Store store) {
        super(id);
        this.buyerId = buyer.id;
        this.storeId = store.id;
    }
    
    
    public boolean validate() {
        return true;
    }
    
    public Transaction perform () {
        return null;
    }
}
