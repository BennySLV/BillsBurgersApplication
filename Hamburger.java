package Section5.BillsBurgers;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Complete Java Masterclass
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
 * With optional condiments and/or fillings
 *
 * The standard burger will also have its
 * own price, which will be different compared
 * to that of its subclasses (i.e. Healthy Burger and Deluxe Burger)
 *
 * @author Ben Silveston
 */
public class Hamburger {
    private String burgerName;
    private BreadRoll breadRollType;
    private Meat meatType;
    private Filling filling;
    private Condiment condiment;
    private int currentNumberOfFillings = 0;
    private int currentNumberOfCondiments = 0;
    private double price;

    private ArrayList<Filling> ADDED_FILLINGS = new ArrayList<>();
    private ArrayList<Condiment> ADDED_CONDIMENTS = new ArrayList<>();

    private static final Scanner SCANNER = new Scanner(System.in);

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
    public Hamburger(BreadRoll breadRollType, Meat meatType) {
        this.burgerName = "Hamburger";
        this.price = 5.00;
        this.breadRollType = breadRollType;
        this.meatType = meatType;;
    }

    /**
     * Advanced constructor
     *
     * Adds all of the main ingredients
     * to the burger as well as the
     * option to add one filling
     * and one condiment.
     *
     * @param breadRollType The type of bread roll used for the burger
     * @param meatType The type of meat used in the burger
     * @param filling The type of filling used in the burger
     * @param condiment The type of condiment used in the burger
     */
    public Hamburger(BreadRoll breadRollType, Meat meatType, Filling filling, Condiment condiment) {
        this.breadRollType = breadRollType;
        this.meatType = meatType;
        this.filling = filling;
        this.condiment = condiment;
    }

    /**
     * Get the current bread roll
     * for the burger
     *
     * @return The current bread roll type
     */
    public BreadRoll getBreadRollType() {
        return breadRollType;
    }

    /**
     * Set the bread roll type
     * for the burger
     *
     * @param breadRollType The new bread roll type
     */
    public void setBreadRollType(BreadRoll breadRollType) {
        this.breadRollType = breadRollType;
    }

    /**
     * Get the current meat
     * for the burger
     *
     * @return The current meat type
     */
    public Meat getMeatType() {
        return meatType;
    }

    /**
     * Set the new meat type
     * for the burger
     *
     * @param meatType The new meat type
     */
    private void setMeatType(Meat meatType) {
        this.meatType = meatType;
    }

    /**
     * Get the current price
     * of the burger
     *
     * @return The current price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get the current number of fillings
     * in the burger
     *
     * @return The current number of fillings
     */
    public int getCurrentNumberOfFillings() {
        return currentNumberOfFillings;
    }

    /**
     * Get the current number of condiments
     * in the burger
     *
     * @return The current number of condiments
     */
    public int getCurrentNumberOfCondiments() {
        return currentNumberOfCondiments;
    }

    /**
     * Add the bread roll type to the burger
     *
     * @param breadRoll The type of breadroll to add
     */
    public void addBreadRoll(BreadRoll breadRoll) {
        this.setBreadRollType(breadRoll);
    }

    /**
     * Remove the bread roll type from the burger
     */
    public void removeBreadRoll() {
        this.setBreadRollType(null);
    }

    /**
     * Add the meat type to the burger
     *
     * @param meatType The type of meat to add
     */
    public void addMeat(Meat meatType) {
        this.setMeatType(meatType);
    }

    /**
     * Remove the type of meat from the burger
     */
    public void removeMeat() {
        this.setMeatType(null);
    }

    /**
     * Add the number of fillings as well as
     * actual fillings based on the customer's request
     */
    public void addFilling() {
        System.out.print("How many fillings would you like to add? ");
        int numberOfFillingsToAdd = SCANNER.nextInt();
        int numberOfFillingsAdded = 0;
        int maxNumberOfFillings = 4;
        while(numberOfFillingsAdded < numberOfFillingsToAdd) {
            System.out.print("Please add your filling: ");
            String fillingToAdd = SCANNER.next();

            if(numberOfFillingsToAdd <= maxNumberOfFillings) {
                for(int i = 0; i < numberOfFillingsToAdd; i++) {
                    this.filling = new Filling(fillingToAdd);
                }
                this.ADDED_FILLINGS.add(this.filling);
            }
            numberOfFillingsAdded++;
            this.currentNumberOfFillings++;
        }
    }

    /**
     * Remove a filling from the burger
     */
    public void removeFilling() {
        System.out.println("Added fillings: ");
        displayAddedFillings();

        System.out.print("\nPlease select a filling from the list above to remove: ");
        String fillingToRemove = SCANNER.next();

        for(int i = 0; i < this.ADDED_FILLINGS.size(); i++) {
            if(this.ADDED_FILLINGS.get(i).getFillingType().equalsIgnoreCase(fillingToRemove)) {
                this.ADDED_FILLINGS.remove(i);
                System.out.println("The filling '" + fillingToRemove + "' has been removed successfully.");
                this.currentNumberOfFillings--;
            }
        }
    }

    /**
     * Add an existing condiment to the burger
     */
    public void addCondiment() {
        System.out.print("How many condiments would you like to add? ");
        int numberOfCondimentsToAdd = SCANNER.nextInt();
        int numberOfCondimentsAdded = 0;
        int maxNumberOfCondiments = 2;
        while(numberOfCondimentsAdded < numberOfCondimentsToAdd) {
            System.out.print("Please add your condiment: ");
            String condimentToAdd = SCANNER.next();

            if(numberOfCondimentsToAdd <= maxNumberOfCondiments) {
                for(int i = 0; i < numberOfCondimentsToAdd; i++) {
                    this.condiment = new Condiment(condimentToAdd);
                }
                this.ADDED_CONDIMENTS.add(this.condiment);
            }
            numberOfCondimentsAdded++;
            this.currentNumberOfCondiments++;
        }
    }

    /**
     * Remove the current condiment from the burger
     */
    public void removeCondiment() {
        System.out.println("Added condiments: ");
        displayAddedCondiments();

        System.out.print("\nPlease select a condiments from the list above to remove: ");
        String condimentToRemove = SCANNER.next();

        for(int i = 0; i < this.ADDED_CONDIMENTS.size(); i++) {
            if(this.ADDED_CONDIMENTS.get(i).getCondimentType().equalsIgnoreCase(condimentToRemove)) {
                this.ADDED_CONDIMENTS.remove(i);
                System.out.println("The filling '" + condimentToRemove + "' has been removed successfully.");
                this.currentNumberOfCondiments--;
            }
        }
    }

    /**
     * Display the fillings currently added to the burger
     */
    private void displayAddedFillings() {
        if(this.currentNumberOfFillings > 0) {
            for(Filling filling : this.ADDED_FILLINGS) {
                System.out.print(filling.getFillingType() + " ");
            }
        }
        else {
            System.out.print("None");
        }
    }

    /**
     * Display the condiment currently added to the burger
     */
    private void displayAddedCondiments() {
        if(this.currentNumberOfCondiments > 0) {
            for(Condiment condiment : this.ADDED_CONDIMENTS) {
                System.out.print(condiment.getCondimentType() +  " ");
            }
        }
        else {
            System.out.print("None");
        }
    }

    /**
     * Get the total cost
     * for the number of fillings
     * added to the burger
     *
     * @return The total cost for the number of fillings
     */
    private double getTotalCostForFillings() {
        double totalCostForFillings = 0;
        if(this.currentNumberOfFillings > 0) {
            totalCostForFillings = this.filling.getFillingPrice()
                    * this.currentNumberOfFillings;
        }
        return totalCostForFillings;
    }

    /**
     * Get the total cost for
     * the number of condiments
     * added to the burger
     *
     * @return The total cost for the number of condiments
     */
    private double getTotalCostForCondiments() {
       double totalCostForCondiments = 0;
       if(this.currentNumberOfCondiments > 0) {
           totalCostForCondiments = this.condiment.getCondimentPrice()
                   * this.currentNumberOfCondiments;
       }
       return totalCostForCondiments;
    }

    /**
     * Calculate the total cost of the hamburger
     * including any additional fillings and / or condiments
     *
     * @return The total cost of the hamburger
     */
    private double calculateTotalCost() {
        return this.getPrice() + this.getTotalCostForFillings()  + this.getTotalCostForCondiments();
    }

    /**
     * Calculate the final cost of the
     * burger (i.e. burger + filling + condiment)
     *
     * Should a filling and condiment be added in the first place
     */
    public void displayOrderDetails() {
        System.out.println("**********************************************");
        System.out.println("Burger name: " + this.burgerName);
        System.out.println("Bread roll type: " + this.breadRollType.getBreadRollType());
        System.out.println("Meat type: " + this.meatType.getMeatType());
        System.out.print("Added filling(s): (" + this.getCurrentNumberOfFillings() + ") - ");
        this.displayAddedFillings();
        System.out.print("\nAdded condiment(s): (" + this.getCurrentNumberOfCondiments() + ") - ");
        this.displayAddedCondiments();
        DecimalFormat currencyFormat = new DecimalFormat("#0.00");
        System.out.println("\nTotal cost: £" + currencyFormat.format(calculateTotalCost()));
        System.out.println("**********************************************");
    }
}