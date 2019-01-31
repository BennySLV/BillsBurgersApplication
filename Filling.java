package Section5.BillsBurgers;

/**
 * Complete Java Masterclass
 *
 * Section 5 - OOP (2) Composition, Encapsulation and Polymorphism
 *
 * This class will represent a filling that
 * will be used in a standard burger
 *
 * @author Ben Silveston
 */
public class Filling {
    private String fillingType;
    private double price;

    /**
     * Constructer
     *
     * @param fillingType The type of filling
     */
    public Filling(String fillingType) {
        this.fillingType = fillingType;
        this.price = 0.5;
    }

    /**
     * Get the type of filling
     *
     * @return The type of filling
     */
    public String getFillingType() {
        return fillingType;
    }

    /**
     * Set a new type of filling
     *
     * @param fillingType The new type of filling
     */
    public void setFillingType(String fillingType) {
        this.fillingType = fillingType;
    }

    /**
     * Get the current price of the filling
     *
     * @return The current price
     */
    public double getFillingPrice() {
        return price;
    }

    /**
     * Set a new price for all of the fillings
     *
     * @param price The new price
     */
    public void setFillingPrice(double price) {
        this.price = price;
    }
}