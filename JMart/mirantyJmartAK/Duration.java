package mirantyJmartAK;

import java.util.Calendar;
import java.util.Date;
import java.text.*;

/**
 * Write a description of class ShipmentDuration here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */
public class Duration
{
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy");
    public static final Duration INSTANT = new Duration ((byte)(1 << 0)); //0000 0001
    public static final Duration SAME_DAY = new Duration ((byte)(1 << 1)); //0000 0010
    public static final Duration NEXT_DAY = new Duration ((byte)(1 << 2)); //0000 0100
    public static final Duration REGULER = new Duration ((byte)(1 << 3)); //0000 1000
    public static final Duration KARGO = new Duration ((byte)(1 << 4)); //0001 0000
    private final byte bit;
    
    private Duration (byte bit) {
        this.bit = bit;
    }
    
    public String getEstimatedArrival(Date reference){
        Calendar temp = Calendar.getInstance();
        if(this.bit == 1<<0|| this.bit == 1<<1){
            return ESTIMATION_FORMAT.format(reference.getTime());
        }else if(this.bit == 1<<2){
            temp.setTime(reference);
            temp.add(Calendar.DATE,1);
            return ESTIMATION_FORMAT.format(temp);
        }else if(this.bit == 1<<3){
            temp.setTime(reference);
            temp.add(Calendar.DATE,2);
            return ESTIMATION_FORMAT.format(temp);
        }else{
            temp.setTime(reference);
            temp.add(Calendar.DATE,5);
            return ESTIMATION_FORMAT.format(temp);
        }
    }
    
    /*
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
    }*/
}