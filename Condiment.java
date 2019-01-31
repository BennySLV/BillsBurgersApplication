package Section5.BillsBurgers;

/**
 * Complete Java Masterclass
 *
 * Section 5 - OOP (2) Composition, Encapsulation and Polymorphism
 *
 * This class will represent a condiment within a standard burger
 *
 * @author Ben Silveston
 */
public class Condiment {
    private String condimentType;
    private double price;

    /**
     * Constructor
     *
     * @param condimentType The type of condiment
     */
    public Condiment(String condimentType) {
        this.condimentType = condimentType;
        this.price = 0.25;
    }

    /**
     * Get the current condiment type
     *
     * @return The current condiment type
     */
    public String getCondimentType() {
        return condimentType;
    }

    /**
     * Set a new condiment type
     *
     * @param condimentType The new condiment type
     */
    public void setCondimentType(String condimentType) {
        this.condimentType = condimentType;
    }

    /**
     * Get the current price for each condiment
     *
     * @return The current price
     */
    public double getCondimentPrice() {
        return price;
    }

    /**
     * Set a new price for each condiment
     *
     * @param price The new price
     */
    public void setCondimentPrice(double price) {
        this.price = price;
    }
}