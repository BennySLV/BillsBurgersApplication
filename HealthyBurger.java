package Section5.BillsBurgers;

import java.util.Scanner;

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
 * Also only specific meat types can be added
 * as well as specific fillings and condiments.
 * This is to ensure that all aspects of the "Healthy
 * Burger" are indeed healthier than the standard hamburger.
 *
 * @author Ben Silveston
 */
public class HealthyBurger extends Hamburger {
    private Filling filling;
    private Condiment condiment;

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Constructor
     *
     * Inherited from the hamburger
     * superclass
     *
     * @param burgerName The name of the burger
     * @param price The price of the burger
     */
    public HealthyBurger(String burgerName, double price) {
        super(burgerName, price);
    }

    /**
     * Remove the bread roll type from the burger
     */
    @Override
    protected void removeBreadRoll() {
        super.removeBreadRoll();
    }

    /**
     * Remove the type of meat from the burger
     */
    @Override
    protected void removeMeat() {
        super.removeMeat();
    }

    /**
     * Add the number of fillings as well as
     * actual fillings based on the customer's request
     */
    @Override
    public void addFilling() {
        super.addFilling();

        int maxNumberOfAdditionalFillings = 2;
        int numberOfAdditionalFillingsAdded = 0;

        System.out.println("Please note that with the Healthy Burger, you can add an additional two fillings.");
        System.out.print("How many additional fillings would you like to add? (max. 2): ");
        int numberOfAdditionalFillingsToAdd = SCANNER.nextInt();

        while(numberOfAdditionalFillingsAdded < numberOfAdditionalFillingsToAdd) {
            System.out.print("Please add your filling: ");
            String fillingToAdd = SCANNER.next();

            if(numberOfAdditionalFillingsToAdd <= maxNumberOfAdditionalFillings) {
                for(int i = 0; i < numberOfAdditionalFillingsToAdd; i++) {
                    this.filling = new Filling(fillingToAdd);
                }
                this.getAddedFillings().add(this.filling);
            }
            numberOfAdditionalFillingsAdded++;
            this.currentNumberOfFillings++;
        }
    }

    /**
     * Remove a filling from the burger
     */
    @Override
    public void removeFilling() {
        super.removeFilling();
    }

    /**
     * Add an existing condiment to the burger
     */
    @Override
    public void addCondiment() {
        super.addCondiment();

        int maxNumberOfAdditionalCondiments = 1;
        int numberOfAdditionalCondimentsAdded = 0;

        System.out.println("Please note that with the Healthy Burger, you can add an additional two fillings.");
        System.out.print("How many additional fillings would you like to add? (max. 2): ");
        int numberOfAdditionalCondimentsToAdd = SCANNER.nextInt();

        while(numberOfAdditionalCondimentsAdded < numberOfAdditionalCondimentsToAdd) {
            System.out.print("Please add your filling: ");
            String condimentToAdd = SCANNER.next();

            if(numberOfAdditionalCondimentsToAdd <= maxNumberOfAdditionalCondiments) {
                for(int i = 0; i < numberOfAdditionalCondimentsToAdd; i++) {
                    this.condiment = new Condiment(condimentToAdd);
                }
                this.getAddedCondiments().add(this.condiment);
            }
            numberOfAdditionalCondimentsAdded++;
            this.currentNumberOfCondiments++;
        }
    }

    /**
     * Remove the current condiment from the burger
     */
    @Override
    public void removeCondiment() {
        super.removeCondiment();
    }

    /**
     * Calculate the final cost of the
     * burger (i.e. burger + filling + condiment)
     * <p>
     * Should a filling and condiment be added in the first place
     */
    @Override
    public void displayOrderDetails() {
        super.displayOrderDetails();
    }
}