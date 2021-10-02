package mirantyJmartAK;


/**
 * Write a description of class Transaction here.
 *
 * @author Miranty Anjani Putri
 * @version (a version number or a date)
 */
public interface Transactor
{
    public abstract boolean validate();
    
    public abstract Invoice perform();
}
