package mirantyJmartAK;


/**
 * Write a description of class ShipmentDuration here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */
public class ShipmentDuration
{
    public static final ShipmentDuration INSTANT = new ShipmentDuration(1 << 0); //0000 0001
    public static final ShipmentDuration SAME_DAY = new ShipmentDuration(1 << 1); //0000 0010
    public static final ShipmentDuration NEXT_DAY = new ShipmentDuration(1 << 2); //0000 0100
    public static final ShipmentDuration REGULER = new ShipmentDuration(1 << 3); //0000 1000
    public static final ShipmentDuration KARGO = new ShipmentDuration(1 << 4); //0001 0000
    private final int bit;
    
    private ShipmentDuration (int bit) {
        this.bit = bit;
    }
    
    public ShipmentDuration(ShipmentDuration... args) {
        int bits = 0;
        for (ShipmentDuration arg : args) {
            bits |= arg.bit;
        }
        this.bit = bits;
    }
        
    public boolean isDuration (ShipmentDuration reference) {
        if ((bit & reference.bit) != 0) {
            return true;
        }
        else {
            return false;
        }
    }
}