package mirantyJmartAK;


/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shipment
{
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    
    /*
    //Inner Class ShipmentDuration --> Duration
    public static class Duration
    {
        /*
        public final Duration INSTANT = new Duration.(byteValue(1 << 0)); //0000 0001
        public final Duration SAME_DAY = new Duration.(byteValue(1 << 1)); //0000 0010
        public final Duration NEXT_DAY = new Duration.(1 << 2); //0000 0100
        public final Duration REGULER = new Duration.(1 << 3); //0000 1000
        public final Duration KARGO = new Duration(1 << 4); //0001 0000
        private final byte bit;
    
        private Duration (byte bit) {
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
    
    /*
     * 
     public class MultiDuration {
        public byte bit;
        public MultiDuration(Duration... args) {
            for(int i: bit
        }
    }
    
    public Shipment(String addres, int shipmentCost, Duration duration, String receipt) {
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }*/
}
