package Section5.BillsBurgers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Java Programming Masterclass for Software Developers
 *
 * Section 5 - OOP (2) Composition, Encapsulation and Polymorphism
 *
 * This abstract class will define all the common characteristics
 * for all burgers that are made within Bills Burgers.
 *
 * @author Ben Silveston
 */
public abstract class Burger implements MainIngredients, Additions {
    protected String burgerName;
    protected BreadRoll breadRoll;
    protected Meat meat;
    private Filling filling;
    private Condiment condiment;
    private double price;

    protected int currentNumberOfFillings = 0;
    protected int currentNumberOfCondiments = 0;

    private List<Filling> addedFillings;
    private List<Condiment> addedCondiments;

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Constructor
     *
     * @param burgerName The name of the burger
     * @param price The price of the burger
     */
    public Burger(String burgerName, double price) {
        this.burgerName = burgerName;
        this.price = price;
        this.addedFillings = new ArrayList<>();
        this.addedCondiments = new ArrayList<>();
    }

    /**
     * Get the current bread roll
     * for the burger
     *
     * @return The current bread roll type
     */
    private BreadRoll getBreadRoll() {
        return breadRoll;
    }

    /**
     * Set the bread roll type
     * for the burger
     *
     * @param breadRoll The new bread roll type
     */
    protected void setBreadRoll(BreadRoll breadRoll) {
        this.breadRoll = breadRoll;
    }

    /**
     * Get the current meat
     * for the burger
     *
     * @return The current meat type
     */
    protected Meat getMeat() {
        return meat;
    }

    /**
     * Set the new meat type
     * for the burger
     *
     * @param meat The new meat type
     */
    public void setMeat(Meat meat) {
        this.meat = meat;
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
     * Get the list containing
     * the number of added fillings
     * for the hamburger.
     *
     * @return The added fillings list data
     */
    public List<Filling> getAddedFillings() {
        return addedFillings;
    }

    /**
     * Get the list containing
     * the number of added condiments
     * for the hamburger.
     *
     * @return The added condiments list data
     */
    public List<Condiment> getAddedCondiments() {
        return addedCondiments;
    }

    /**
     * Add an existing bread roll to the burger
     */
    @Override
    public void addBreadRoll() {
        System.out.print("Please add your bread roll: ");
        String breadRollType = SCANNER.next();
        this.setBreadRoll(new BreadRoll(breadRollType));
    }

    /**
     * Remove the bread roll from the burger
     */
    @Override
    public void removeBreadRoll() {
        this.setBreadRoll(null);
        System.out.println(this.getBreadRoll() + " has been removed successfully.");
    }

    /**
     * Add an existing meat to the burger
     */
    @Override
    public void addMeat() {
        System.out.print("Please add your meat: ");
        String meatType = SCANNER.next();
        this.setMeat(new Meat(meatType));
    }

    /**
     * Remove the meat from the burger
     */
    @Override
    public void removeMeat() {
        this.setMeat(null);
        System.out.println(this.getMeat() + " has been removed successfully. ");
    }

    /**
     * Add the number of fillings as well as
     * actual fillings based on the customer's request
     */
    @Override
    public void addFilling() {
        System.out.print("How many fillings would you like to add? ");
        int numberOfFillingsToAdd = SCANNER.nextInt();
        int numberOfFillingsAdded = 0;
        int maxNumberOfFillings = 4;

        if(numberOfFillingsToAdd <= maxNumberOfFillings) {
            while(numberOfFillingsAdded < numberOfFillingsToAdd) {
                System.out.print("Please add your filling: ");
                String fillingToAdd = SCANNER.next();

                for(int i = 0; i < numberOfFillingsToAdd; i++) {
                    this.filling = new Filling(fillingToAdd);
                }
                this.addedFillings.add(this.filling);
                numberOfFillingsAdded++;
                this.currentNumberOfFillings++;
            }
        }
        else {
            System.out.println("Error - can only add a maximum of 4 fillings!");
        }
    }

    /**
     * Remove a filling from the burger
     */
    @Override
    public void removeFilling() {
        System.out.println("Added fillings: ");
        displayAddedFillings();

        System.out.print("\nPlease select a filling from the list above to remove: ");
        String fillingToRemove = SCANNER.next();

        for(int i = 0; i < this.addedFillings.size(); i++) {
            if(this.addedFillings.get(i).getFillingType().equalsIgnoreCase(fillingToRemove)) {
                this.addedFillings.remove(i);
                System.out.println("The filling '" + fillingToRemove + "' has been removed successfully.");
                this.currentNumberOfFillings--;
            }
            else {
                System.out.println("Error - '" + fillingToRemove + "' not found in the burger.");
            }
        }
    }

    /**
     * Add an existing condiment to the burger
     */
    @Override
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
                this.addedCondiments.add(this.condiment);
            }
            else {
                System.out.println("Error - can only add a maximum of 2 condiments!");
            }
            numberOfCondimentsAdded++;
            this.currentNumberOfCondiments++;
        }
    }

    /**
     * Remove the current condiment from the burger
     */
    @Override
    public void removeCondiment() {
        System.out.println("Added condiments: ");
        displayAddedCondiments();

        System.out.print("\nPlease select a condiments from the list above to remove: ");
        String condimentToRemove = SCANNER.next();

        for(int i = 0; i < this.addedCondiments.size(); i++) {
            if(this.addedCondiments.get(i).getCondimentType().equalsIgnoreCase(condimentToRemove)) {
                this.addedCondiments.remove(i);
                System.out.println("The filling '" + condimentToRemove + "' has been removed successfully.");
                this.currentNumberOfCondiments--;
            }
            else {
                System.out.println("Error - the condiment '" + condimentToRemove
                        + "' could not be found in the burger.");
            }
        }
    }

    /**
     * Display the fillings currently added to the burger
     */
    private void displayAddedFillings() {
        if(this.currentNumberOfFillings > 0) {
            for(Filling filling : this.addedFillings) {
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
            for(Condiment condiment : this.addedCondiments) {
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
    protected double calculateTotalCost() {
        return this.getPrice() + this.getTotalCostForFillings()  + this.getTotalCostForCondiments();
    }

    /**
     * Calculate the final cost of the
     * burger (i.e. burger + filling + condiment)
     *
     * Should a filling and condiment be added in the first place
     */
    protected void displayOrderDetails() {
        System.out.println("*****************************************************");
        System.out.println("Burger name: " + this.burgerName);
        System.out.println("Bread roll type: " + this.breadRoll.getBreadRollType());
        System.out.println("Meat type: " + this.meat.getMeatType());
        System.out.print("Added filling(s): (" + this.getCurrentNumberOfFillings() + ") - ");
        this.displayAddedFillings();
        System.out.print("\nAdded condiment(s): (" + this.getCurrentNumberOfCondiments() + ") - ");
        this.displayAddedCondiments();
        DecimalFormat currencyFormat = new DecimalFormat("#0.00");
        System.out.println("\nTotal cost: £" + currencyFormat.format(calculateTotalCost()));
        System.out.println("*****************************************************");
    }
}