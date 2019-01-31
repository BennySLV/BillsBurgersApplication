package Section5.BillsBurgers;

/**
 * Complete Java Masterclass
 *
 * Section 5 - OOP (2) Composition, Encapsulation and Polymorphism
 *
 * This class represents the meat that will be used in all burgers
 * , characterised by meat type and its cooking type. The latter will
 * only apply to certain meats. Such as beef/steak.
 *
 * @author Ben Silveston
 */
public class Meat {
    private String meatType;
    private String cookingType;

    /**
     * Constructor
     *
     * @param meatType The type of meat used in the burger
     */
    public Meat(String meatType) {
        this.meatType = meatType;
    }

    /**
     * Overloaded constructor
     *
     * For use with meats that
     * are either beef or steak
     *
     * @param meatType The type of meat used in the burger (i.e. beef or steak)
     * @param cookingType The cooking type for the beef or steak
     */
    public Meat(String meatType, String cookingType) {
        this.meatType = meatType;
        this.cookingType = cookingType;
    }

    /**
     * Get the type of meat for the burger
     *
     * @return The type of meat
     */
    public String getMeatType() {
        return meatType;
    }

    /**
     * Set the type of meat for the burger
     *
     * @param meatType The new type of meat
     */
    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }

    /**
     * Get the cooking type of the meat
     * should the meat be beef or steak
     *
     * @return The current cooking type
     */
    public String getCookingType() {
        return cookingType;
    }

    /**
     * Set the new cooking type
     * for the meat
     *
     * @param cookingType The new cooking type
     */
    public void setCookingType(String cookingType) {
        this.cookingType = cookingType;
    }
}