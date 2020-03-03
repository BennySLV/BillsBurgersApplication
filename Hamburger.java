package Section5.BillsBurgers;

/**
 * Java Programming Masterclass for Software Developers
 *
 * Section 5 - OOP (2) Composition, Encapsulation and Polymorphism
 *
 * This superclass will represent a standard hamburger
 * which is sold at Bills Burgers
 *
 * By default, a standard hamburger will have
 * a certain bread roll type and meat.
 *
 * These can be added straight away or using the system
 * provided.
 *
 * With optional condiments and/or fillings.
 *
 * The standard hamburger will also have its
 * own price, which will be different compared
 * to that of its subclasses (i.e. Healthy Burger and Deluxe Burger)
 *
 * @author Ben Silveston
 */
public class Hamburger extends Burger {

    /**
     * Constructor
     *
     * @param burgerName The name of the burger
     * @param price      The price of the burger
     */
    public Hamburger(String burgerName, double price) {
        super(burgerName, price);
    }
}