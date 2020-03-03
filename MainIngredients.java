package Section5.BillsBurgers;

/**
 * Java Programming Masterclass for Software Developers
 *
 * Section 5 - OOP (2) Composition, Encapsulation and Polymorphism
 *
 * This interface will define all the common functionality
 * required for the main ingredients (i.e. bread roll and meat)
 * for all burgers within the Bills Burgers menu range.
 *
 * @author Ben Silveston
 */
public interface MainIngredients {

    /**
     * Add an existing bread roll to the burger
     */
    void addBreadRoll();

    /**
     * Remove the bread roll from the burger
     */
    void removeBreadRoll();

    /**
     * Add an existing meat to the burger
     */
    void addMeat();

    /**
     * Remove the meat from the burger
     */
    void removeMeat();
}
