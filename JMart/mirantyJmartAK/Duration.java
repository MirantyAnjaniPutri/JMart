package mirantyJmartAK;


/**
 * Write a description of class ShipmentDuration here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */
public class Duration
{
    public static final Duration INSTANT = new Duration(1 << 0); //0000 0001
    public static final Duration SAME_DAY = new Duration(1 << 1); //0000 0010
    public static final Duration NEXT_DAY = new Duration(1 << 2); //0000 0100
    public static final Duration REGULER = new Duration(1 << 3); //0000 1000
    public static final Duration KARGO = new Duration(1 << 4); //0001 0000
    private final int bit;
    
    private Duration (int bit) {
        this.bit = bit;
    }
    
    public Duration(Duration... args) {
        int bits = 0;
        for (Duration arg : args) {
            bits |= arg.bit;
        }
        this.bit = bits;
    }
        
    public boolean isDuration (Duration reference) {
        if ((bit & reference.bit) != 0) {
            return true;
        }
        else {
            return false;
        }
    }
}