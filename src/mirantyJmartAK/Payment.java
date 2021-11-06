package mirantyJmartAK;


/**
 * Write a description of class Payment here.
 *
 * @author Miranty Anjani
 * @version (a version number or a date)
 */
public class Payment extends Invoice
{
    public int productCount;
    public Shipment shipment;

    public Payment (Integer buyerId, Integer productId, Integer productCount, Shipment shipment) {
        super();
        this.productCount = productCount;
        this.shipment = shipment;
    }

    @Override
    public double getTotalPay() {
        return 0.0;
    }
}
