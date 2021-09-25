package mirantyJmartAK;


/**
 * Write a description of interface FileParser here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */
public interface FileParser
{
    public boolean read (String content);
    
    public default Object write() {
        return null;
    }
    
    public static Object newInstance(String content) {
        return null;
    }
}
