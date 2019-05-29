package Section5.BillsBurgers;

/**
 * Complete Java Masterclass
 *
 * Section 5 - OOP (2) Composition, Encapsulation and Polymorphism
 *
 * This subclass will represent the "Healthy Burger"
 * version of the standard hamburger provided by
 * Bill's Burgers.
 *
 * The Healthy Burger option will provide
 * a burger with a specific bread roll type
 * and with two exclusive additions, which
 * are not provided with the standard hamburger
 * option.
 *
 * @author Ben Silveston
 */
public class HealthyBurger extends Hamburger {
    private BreadRoll breadRoll;
    private Meat meat;
    private Filling filling;
    private Condiment condiment;

    /**
     * Default constructor
     *
     * Includes the name and price of the burger
     *
     * Adds all of the main ingredients to the burger
     * (i.e. the bread roll type and meat type)
     *
     * @param breadRollType The type of bread roll used for the burger
     * @param meatType The type of meat used in the burger
     */
    public HealthyBurger(BreadRoll breadRollType, Meat meatType) {
        
    }

}
