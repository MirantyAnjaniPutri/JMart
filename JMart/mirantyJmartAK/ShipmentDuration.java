package mirantyJmartAK;


/**
 * Write a description of class ShipmentDuration here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */
public class ShipmentDuration
{
    public enum shipmentDuration {
        INSTANT, SAME_DAY, NEXT_DAY, REGULER, KARGO;
    }
    public static int INSTANT = 1; //0000 0001
    public static int SAME_DAY = 2; //0000 0010
    public static int NEXT_DAY = 4; //0000 0100
    public static int REGULER = 8; //0000 1000
    public static int KARGO = 16; //0001 0000
    private int bit;
    /*
    public static ShipmentDuration shipmentDuration (ShipmentDuration shipmentDuration, int bit) {
        if ((bit & INSTANT) == INSTANT) {
            return shipmentDuration.INSTANT;
        }
        else if ((bit & SAME_DAY) == SAME_DAY) {
            return shipmentDuration.SAME_DAY;
        }
        else if ((bit & NEXT_DAY) == NEXT_DAY) {
            return shipmentDuration.NEXT_DAY;
        }
        else if ((bit & REGULER) == REGULER) {
            return shipmentDuration.REGULER;
        }
        else if ((bit & KARGO) == KARGO) {
            return shipmentDuration.KARGO;
        }

    private ShipmentDuration (int bit) {
        
    }
    
    public ShipmentDuration shipmentDuration (ShipmentDuration[]) {
        
    }
    
    public boolean isDuration (ShipmentDuration) {
        
    }
    } */
}
