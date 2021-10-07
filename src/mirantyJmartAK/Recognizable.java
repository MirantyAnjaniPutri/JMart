package mirantyJmartAK;


/**
 * Write a description of class Recognizable here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */
public class Recognizable
{
    public final int id;
    
    protected Recognizable (int id) {
        this.id = id;
    }
    
    public boolean equals (Object recognizable) {
        return (recognizable instanceof Recognizable) && ((Recognizable) recognizable).id == id;
    }
    
    public boolean equals (Recognizable recognizable) {
        if (recognizable.id == id) {
            return true;
        } else {
            return false;
        }       
    }
}
