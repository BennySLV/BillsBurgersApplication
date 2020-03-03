package Section5.BillsBurgers;

import java.util.Scanner;

/**
 * Java Programming Masterclass for Software Developers
 *
 * Section 5 - OOP (2) Composition, Encapsulation and Polymorphism
 *
 * This class will form the functionality
 * for both running and closing
 * the Bills Burgers application platform.
 *
 * @author Ben Silveston
 */
public class BillsBurgersApplication {
    private Hamburger hamburger;
    private HealthyBurger healthyBurger;
    private DeluxeBurger deluxeBurger;

    private int burgerSelection;

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Add the main ingredients
     * to the burger
     *
     * These are both the bread roll
     * and the meat
     *
     * This method gives the user the opportunity
     * to therefore add all ingredients
     */
    private void addMainIngredients() {
        boolean hasNotConfirmedSelection = true;
        while(hasNotConfirmedSelection) {
            if(this.burgerSelection == 1) {
                hamburger.addBreadRoll();
            }
            else if(this.burgerSelection == 2) {
                healthyBurger.addBreadRoll();
            }
            else if(this.burgerSelection == 3) {
                deluxeBurger.addBreadRoll();
            }
            if(this.burgerSelection == 1) {
                hamburger.addMeat();
            }
            else if(this.burgerSelection == 2) {
                healthyBurger.addMeat();
            }
            else if(this.burgerSelection == 3) {
                deluxeBurger.addMeat();
            }
            hasNotConfirmedSelection = false;
        }
    }

    /**
     * Add additions to the burger.
     *
     * These include both fillings and
     * condiments, which will be selected
     * based on the user's request.
     */
    private void addAdditions() {
        System.out.print("Would like to add any additions to your burger (i.e. fillings and/or condiments?) (Y / N) : ");
        String additionsAnswer = SCANNER.next();
        if(additionsAnswer.equalsIgnoreCase("Yes") ||
                additionsAnswer.equalsIgnoreCase("Y")) {
            System.out.println("Please select from the following options: " +
                    "\n\t 1 - Fillings only \n\t 2 - Condiments only \n\t 3 - Fillings and Condiments");

            int additionsNumSelection = SCANNER.nextInt();
            switch(additionsNumSelection) {
                case 1:
                    if(this.burgerSelection == 1) {
                        hamburger.addFilling();
                        break;
                    }
                    else if(this.burgerSelection == 2) {
                        healthyBurger.addFilling();
                        break;
                    }
                case 2:
                    if(this.burgerSelection == 1) {
                        hamburger.addCondiment();
                        break;
                    }
                    else if(this.burgerSelection == 2) {
                        healthyBurger.addCondiment();
                        break;
                    }
                case 3:
                    if(this.burgerSelection == 1) {
                        hamburger.addFilling();
                        hamburger.addCondiment();
                        break;
                    }
                    else if(this.burgerSelection == 2) {
                        healthyBurger.addFilling();
                        healthyBurger.addCondiment();
                        break;
                    }
            }
            processOrder();
        }
    }

    /**
     * Remove additions to the burger.
     *
     * These include both fillings and
     * condiments, which will be selected
     * based on the user's request.
     */
    private void removeAdditions() {
        System.out.print("Would like to remove any additions to your burger (i.e. fillings and/or condiments)? (Y / N) : ");
        String additionsAnswer = SCANNER.next();
        if(additionsAnswer.equalsIgnoreCase("Yes") ||
                additionsAnswer.equalsIgnoreCase("Y")) {
            System.out.println("Please select from the following options: " +
                    "\n\t 1 - Fillings only \n\t 2 - Condiments only \n\t 3 - Fillings and Condiments");

            int additionsNumSelection = SCANNER.nextInt();
            switch(additionsNumSelection) {
                case 1:
                    if(this.burgerSelection == 1) {
                        hamburger.removeFilling();
                        break;
                    }
                    else if(this.burgerSelection == 2) {
                        healthyBurger.removeFilling();
                        break;
                    }
                case 2:
                    if(this.burgerSelection == 1) {
                        hamburger.removeCondiment();
                        break;
                    }
                    else if(this.burgerSelection == 2) {
                        healthyBurger.removeCondiment();
                        break;
                    }
                case 3:
                    if(this.burgerSelection == 1) {
                        hamburger.removeFilling();
                        hamburger.removeCondiment();
                        break;
                    }
                    else if(this.burgerSelection == 2) {
                        healthyBurger.removeFilling();
                        healthyBurger.removeCondiment();
                        break;
                    }
            }
            processOrder();
        }
    }

    /**
     * Process the order and close the application
     */
    private void processOrder() {
        System.out.println("\nThank you. Please see your order below: ");
        if(this.burgerSelection == 1) {
            hamburger.displayOrderDetails();
        }
        else if(this.burgerSelection == 2) {
            healthyBurger.displayOrderDetails();
        }
        else if(this.burgerSelection == 3) {
            deluxeBurger.displayOrderDetails();
        }
        System.exit(0);
    }

    /**
     * Run the Bills Burgers application here
     *
     * This method allows minimum code to be run in the main method
     */
    void runApplication() {
        System.out.println("Hello! Welcome to Bills Burgers! Please select from the following three options: \n"
                + "\t 1 - Hamburger \n\t 2 - Healthy Burger \n\t 3 - Deluxe Burger");

        this.burgerSelection = SCANNER.nextInt();
        switch(burgerSelection) {
            case 1:
                hamburger = new Hamburger("Hamburger", 5.00);
                addMainIngredients();
                addAdditions();
                processOrder();
                break;
            case 2:
                healthyBurger = new HealthyBurger("Healthy Burger", 6.50);
                addMainIngredients();
                addAdditions();
                processOrder();
                break;
            case 3:
                deluxeBurger = new DeluxeBurger("Deluxe Burger", 8.00);
                addMainIngredients();
                deluxeBurger.addDrink();
                deluxeBurger.addSideDish();
                processOrder();
                break;
        }
    }
} 