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
        String drinkName = SCANNER.nextLine();
        System.out.print("Please select your drink size (S(mall)/M(edium)/L(arge)): ");
        String drinkSize = SCANNER.nextLine();
        this.drink = new Drink(drinkName, drinkSize);
        this.getDrink().setDrinkPriceBasedOnSize(drinkSize);
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
        System.out.print("Please add a side dish to your Deluxe Burger meal: ");
        String sideDishName = SCANNER.nextLine();
        System.out.print("Please select your side dish size (S(mall)/M(edium)/L(arge)): ");
        String sideDishSize = SCANNER.nextLine();
        this.sideDish = new SideDish(sideDishName, sideDishSize);
        this.getSideDish().setSideDishPriceBasedOnSize(sideDishSize);
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
     * Calculate the total cost of the hamburger
     * including any additional fillings and / or condiments
     *
     * @return The total cost of the hamburger
     */
    @Override
    double calculateTotalCost() {
        return this.getPrice() + this.getDrink().getPrice() + this.getSideDish().getPrice();
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
        System.out.println("Drink: " + this.getDrink().getName() + " (Size: " + this.getDrink().getSize() + ")");
        System.out.println("Side Dish: " + this.getSideDish().getName() + " (Size: " + this.getSideDish().getSize() + ")");
        DecimalFormat currencyFormat = new DecimalFormat("#0.00");
        System.out.println("\nTotal cost: £" + currencyFormat.format(calculateTotalCost()));
        System.out.println("*****************************************************");
    }

    /**
     * This inner class will represent a drink object
     * and can only be created and accessed initially
     * in the Deluxe Burger class.
     *
     * @author Ben Silveston
     */
    private class Drink {
        private String name;
        private String size;
        private double price;

        /**
         * Constructor
         *
         * @param name The name of the drink
         * @param size The named size of the drink (i.e small, medium or large)
         */
        public Drink(String name, String size) {
            this.name = name;
            this.size = size;
        }

        /**
         * Get the current for the drink
         *
         * @return The current name
         */
        public String getName() {
            return name;
        }

        /**
         * Set a new name for the drink
         *
         * @param name The new name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Get the named size
         * of the drink
         *
         * @return The current named size
         */
        public String getSize() {
            return size;
        }

        /**
         * Set the new named
         * size of the drink
         *
         * @param size The new named size
         */
        public void setSize(String size) {
            this.size = size;
        }

        /**
         * Get the current price for the drink
         *
         * @return The current price
         */
        public double getPrice() {
            return price;
        }

        /**
         * Set the new price for the drink
         * based on its named size.
         *
         * @param price The new price
         */
        public void setPrice(double price) {
            this.price = price;
        }

        /**
         * Set the drink price
         * based on its named size.
         *
         * @param size The named size
         * @return The price of the drink based on its named size
         */
        private double setDrinkPriceBasedOnSize(String size) {
            switch(size) {
                case "S":
                case "s":
                case "Small":
                case "small":
                    this.setPrice(2.50);
                    break;
                case "M":
                case "m":
                case "Medium":
                case "medium":
                    this.setPrice(3.50);
                    break;
                case "L":
                case "l":
                case "Large":
                case "large":
                    this.setPrice(5.00);
                    break;
                default:
                    this.setPrice(0.0);
                    break;
            }
            return this.price;
        }
    }
    /**
     * This inner class will represent a side-dish object
     * and can only be created
     * and accessed initially in the Deluxe Burger class.
     *
     * @author Ben Silveston
     */
    private class SideDish {
        private String name;
        private String size;
        private double price;

        /**
         * Default constructor
         *
         * @param name  The name of the side dish
         * @param size  The size of the side dish
         */
        public SideDish(String name, String size) {
            this.name = name;
            this.size = size;
        }

        /**
         * Get the name of the side-dish
         *
         * @return The name of the current side-dish
         */
        public String getName() {
            return name;
        }

        /**
         * Set the name for new side-dish
         *
         * @param name The new name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Get the named size
         * of the side dish
         *
         * @return The current named size
         */
        public String getSize() {
            return size;
        }

        /**
         * Set the new named size
         * of the side dish
         *
         * @param size The new named size
         */
        public void setSize(String size) {
            this.size = size;
        }

        /**
         * Get the price for the current side-dish
         *
         * @return The current price
         */
        public double getPrice() {
            return price;
        }

        /**
         * Set the new price for the side-dish
         * based on its named size.
         *
         * @param price The new price
         */
        public void setPrice(double price) {
            this.price = price;
        }

        /**
         * Set the side dish price
         * based on its named size.
         *
         * @param size The named size
         * @return The side dish based on its named size
         */
        private double setSideDishPriceBasedOnSize(String size) {
            switch(size) {
                case "S":
                case "s":
                case "Small":
                case "small":
                    this.setPrice(1.50);
                    break;
                case "M":
                case "m":
                case "Medium":
                case "medium":
                    this.setPrice(3.00);
                    break;
                case "L":
                case "l":
                case "Large":
                case "large":
                    this.setPrice(4.50);
                    break;
                default:
                    this.setPrice(0.0);
                    break;
            }
            return this.price;
        }
    }
}