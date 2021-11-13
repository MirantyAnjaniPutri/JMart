package mirantyJmartAK;

public class PhoneTopUp extends Invoice {
    public String phoneNumber;
    public Invoice.Status status;

    public PhoneTopUp(int buyerId, int productId, String phoneNumber) {
        super(buyerId,productId);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public double getTotalPay() {
        return 0;
    }
 }
