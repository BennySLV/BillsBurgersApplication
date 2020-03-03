package Section5.BillsBurgers;

/**
 * Java Programming Masterclass for Software Developers
 *
 * Section 5 - OOP (2) Composition, Encapsulation and Polymorphism
 *
 * This interface will define all the common functionality
 * required for both types of additions (i.e. fillings and condiments)
 * for all burgers within the Bills Burgers menu range.
 *
 * @author Ben Silveston
 */
public interface Additions {

    /**
     * Add the number of fillings as well as
     * actual fillings based on the customer's request
     */
    void addFilling();

    /**
     * Remove a filling from the burger
     */
    void removeFilling();

    /**
     * Add an existing condiment to the burger
     */
    void addCondiment();

    /**
     * Remove the current condiment from the burger
     */
    void removeCondiment();
}
