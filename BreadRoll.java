package Section5.BillsBurgers;

/**
 * Complete Java Masterclass
 *
 * Section 5 - OOP (2) Composition, Encapsulation and Polymorphism
 *
 * This class will represent the bread roll object
 *
 * Each bread roll will be added as part of all burgers
 * within Bill's Burgers
 *
 * @author Ben Silveston
 */
public class BreadRoll {
    private String breadRollType;
    private int cookingTime;
    private int ovenSpringLevel;
    private String doughConditioner;

    /**
     * First basic constructor
     *
     * Containing just the name of the bread roll
     *
     * @param breadRollType The type of bread roll
     */
    public BreadRoll(String breadRollType) {
        this.breadRollType = breadRollType;
    }

    /**
     * Second constructor
     *
     * Containing the type of bread roll along with
     * its cooking time
     *
     * @param breadRollType The type of bread roll
     * @param cookingTime The total cooking time (in hours) for the bread roll
     */
    public BreadRoll(String breadRollType, int cookingTime) {
        this.breadRollType = breadRollType;
        this.cookingTime = cookingTime;
    }

    /**
     * Third constructor
     *
     * Containing the type of bread roll,
     * cooking time and oven spring level
     *
     * @param breadRollType The type of bread roll
     * @param cookingTime The total cooking time (in hours) for the bread roll
     * @param ovenSpringLevel The oven spring level
     */
    public BreadRoll(String breadRollType, int cookingTime, int ovenSpringLevel) {
        this.breadRollType = breadRollType;
        this.cookingTime = cookingTime;
        this.ovenSpringLevel = ovenSpringLevel;
    }

    /**
     * Final and full constructor
     *
     * Containing all fields
     * and their associated variable declarations
     *
     * @param breadRollType The type of bread roll
     * @param cookingTime The total cooking time (in hours)
     * @param ovenSpringLevel The oven spring level
     * @param doughConditioner The dough conditioner
     */
    public BreadRoll(String breadRollType, int cookingTime, int ovenSpringLevel,
                     String doughConditioner) {
        this.breadRollType = breadRollType;
        this.cookingTime = cookingTime;
        this.ovenSpringLevel = ovenSpringLevel;
        this.doughConditioner = doughConditioner;
    }

    /**
     * Get the current bread roll type
     *
     * @return The current bread roll type
     */
    public String getBreadRollType() {
        return breadRollType;
    }

    /**
     * Set the new bread roll type
     *
     * @param breadRollType The new bread roll type
     */
    public void setBreadRollType(String breadRollType) {
        this.breadRollType = breadRollType;
    }

    /**
     * Get the current cooking time (in hours)
     *
     * @return The current cooking time
     */
    public int getCookingTime() {
        return cookingTime;
    }

    /**
     * Set the new cooking time
     *
     * @param cookingTime The new cooking time
     */
    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    /**
     * Get the current oven spring level
     *
     * @return The current oven spring level
     */
    public int getOvenSpringLevel() {
        return ovenSpringLevel;
    }

    /**
     * Set the new oven spring level
     *
     * @param ovenSpringLevel The new oven spring level
     */
    public void setOvenSpringLevel(int ovenSpringLevel) {
        this.ovenSpringLevel = ovenSpringLevel;
    }

    /**
     * Get the currently used dough conditioner
     *
     * @return The current dough conditioner
     */
    public String getDoughConditioner() {
        return doughConditioner;
    }

    /**
     * Set the new dough conditioner
     *
     * @param doughConditioner The new dough conditioner
     */
    public void setDoughConditioner(String doughConditioner) {
        this.doughConditioner = doughConditioner;
    }
}