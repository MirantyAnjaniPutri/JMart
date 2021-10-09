package mirantyJmartAK;


/**
 * Write a description of class Recognizable here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */
public class Recognizable implements Comparable<Recognizable>
{
    public final int id;
    
    protected Recognizable (int id) {
        this.id = id;
    }

    public static <T> int setClosingId(Class<T> clazz, int id) {
        return 0;
    }

    public static <T> int getClosingId(Class<T> clazz) {
        return 0;
    }

    public boolean equals (Object other) {
        return (other instanceof Recognizable) && ((Recognizable) other).id == id;
    }
    
    public boolean equals (Recognizable other) {
        return other.id == id;
    }

    public int compareTo(Recognizable other) {
        if (id == other.id) {
            return 1;
        }
        else {
            return 0;
        }
    }
}