package Section5.BillsBurgers;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Complete Java Masterclass for Software Developers
 *
 * Section 5 - OOP (2) Composition, Encapsulation and Polymorphism
 *
 * This subclass will represent the "Deluxe Burger"
 * version of the standard hamburger, sold by
 * Bill's Burgers.
 *
 * The Deluxe Burger will be served along with a choice of one side-dish
 * and one drink as part of a meal deal. No extra additions
 * can be added to this burger.
 *
 * @author Ben Silveston
 */
public class DeluxeBurger extends Burger {
    private Drink drink;
    private SideDish sideDish;

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Constructor
     *
     * @param burgerName The name of the deluxe burger
     * @param price The price of the deluxe burger
     */
    DeluxeBurger(String burgerName, double price) {
        super(burgerName, price);
    }

    /**
     * Get the drink for
     * the Deluxe Burger meal
     *
     * @return The current drink selected
     */
    private Drink getDrink() {
        return drink;
    }

    /**
     * Get the side dish
     * for the Deluxe Burger meal
     *
     * @return The current side dish
     */
    private SideDish getSideDish() {
        return sideDish;
    }

    /**
     * Add a drink to the
     * Deluxe Burger meal
     */
    void addDrink() {
        System.out.print("Please add a drink to your Deluxe Burger meal: ");
        String drinkToAdd = SCANNER.next();
        this.drink = new Drink(drinkToAdd, 2.50);
    }

    /**
     * Remove a drink from
     * the Deluxe Burger meal
     */
    public void removeDrink() {
        this.drink = null;
        System.out.println("The drink '" + this.getDrink().getName() + "' has been removed successfully.");
    }

    /**
     * Add a side dish
     * to the Deluxe Burger meal
     */
    void addSideDish() {
        System.out.print("Please add a side-dish to your Deluxe Burger meal: ");
        String sideDishToAdd = SCANNER.next();
        this.sideDish = new SideDish(sideDishToAdd, 0.50);
    }

    /**
     * Remove a side dish
     * to the Deluxe Burger meal
     */
    public void removeSideDish() {
        this.sideDish = null;
        System.out.println("The side-dish '" + this.getSideDish().getName() + "' has been removed successfully.");
    }

    /**
     * Calculate the final cost of the
     * burger (i.e. burger + drink + filling + condiment)
     *
     * Should a drink, filling or condiment be added in the first place
     */
    @Override
    public void displayOrderDetails() {
        System.out.println("*****************************************************");
        System.out.println("Burger name: " + this.burgerName);
        System.out.println("Bread roll type: " + this.breadRoll.getBreadRollType());
        System.out.println("Meat type: " + this.meat.getMeatType());
        System.out.println("Drink: " + this.getDrink().getName());
        System.out.println("Side Dish: " + this.getSideDish().getName());
        DecimalFormat currencyFormat = new DecimalFormat("#0.00");
        System.out.println("\nTotal cost: £" + currencyFormat.format(calculateTotalCost()));
        System.out.println("*****************************************************");
    }
}