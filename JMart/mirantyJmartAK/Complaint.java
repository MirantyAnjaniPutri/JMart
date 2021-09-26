package mirantyJmartAK;

/**
 * Write a description of class Complaint here.
 *
 * @author Miranty Anjani
 * @version (a version number or a date)
 */
public class Complaint extends Transaction implements FileParser
{
    public int paymentId;
    public String desc;

    
    public Complaint(int id, Payment payment, String desc) {
        super(id, payment.storeId, payment.buyerId);
        this.desc = desc;
    }

    public Complaint(int id, int buyerId, int storeId, int paymentId, String desc) {
        super(id, buyerId, storeId);
        this.paymentId = paymentId;
        this.desc = desc;        
    }

    public boolean read (String content) {
        return false;
    }
}
