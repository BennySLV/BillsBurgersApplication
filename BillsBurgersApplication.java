package Section5.BillsBurgers;

import java.util.Scanner;

/**
 * Complete Java Masterclass
 *
 * Section 5 - OOP (2) Composition, Encapsulation and Polymorphism
 *
 * This class will form the Bills Burgers application
 * and will contain the functionality for both running
 * and closing the entire application.
 *
 * @author Ben Silveston
 */
public class BillsBurgersApplication {
    private Hamburger hamburger;

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
            System.out.print("Please add your breadroll: ");
            String breadRollType = SCANNER.next();
            hamburger.setBreadRollType(new BreadRoll(breadRollType));

            System.out.print("Confirm answer? (Y / N): ");
            String answer = SCANNER.next();
            
            if(answer.equalsIgnoreCase("Yes") ||
                    answer.equalsIgnoreCase("Y")) {
                System.out.print("Please add your meat: ");
                String meatType = SCANNER.next();
                hamburger.setMeatType(new Meat(meatType));
                hasNotConfirmedSelection = false;
            }
            else if(answer.equalsIgnoreCase("No") ||
                    answer.equalsIgnoreCase("N")) {
                continue;
            }
            else {
                System.out.println("Please provide an appropriate answer (i.e. Yes (Y) or No (N).");
                continue;
            }
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
        System.out.print("Would like to add any additions to your burger (i.e. fillings and/or condiments? : ");
        String additionsAnswer = SCANNER.next();
        if(additionsAnswer.equalsIgnoreCase("Yes") ||
                additionsAnswer.equalsIgnoreCase("Y")) {
            System.out.println("Please select from the following options: " +
                    "\n\t 1 - Fillings only \n\t 2 - Condiments only \n\t 3 - Fillings and Condiments");

            int additionsNumSelection = SCANNER.nextInt();
            switch(additionsNumSelection) {
                case 1:
                    hamburger.addFilling();
                    System.out.print("Confirm selection? (Y / N) : ");
                    String answer = SCANNER.next();
                    confirmAdditionsSelection(answer);
                    break;
                case 2:
                    hamburger.addCondiment();
                    System.out.print("Confirm selection? (Y / N) : ");
                    answer = SCANNER.next();
                    confirmAdditionsSelection(answer);
                    break;
                case 3:
                    hamburger.addFilling();
                    hamburger.addCondiment();
                    System.out.print("Confirm selection? (Y / N) : ");
                    answer = SCANNER.next();
                    confirmAdditionsSelection(answer);
                    break;
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
        System.out.print("Would like to remove any additions to your burger (i.e. fillings and/or condiments? : ");
        String additionsAnswer = SCANNER.next();
        if(additionsAnswer.equalsIgnoreCase("Yes") ||
                additionsAnswer.equalsIgnoreCase("Y")) {
            System.out.println("Please select from the following options: " +
                    "\n\t 1 - Fillings only \n\t 2 - Condiments only \n\t 3 - Fillings and Condiments");

            int additionsNumSelection = SCANNER.nextInt();
            switch(additionsNumSelection) {
                case 1:
                    hamburger.removeFilling();
                    System.out.print("Confirm selection? (Y / N) : ");
                    String answer = SCANNER.next();
                    confirmAdditionsSelection(answer);
                    break;
                case 2:
                    hamburger.removeCondiment();
                    System.out.print("Confirm selection? (Y / N) : ");
                    answer = SCANNER.next();
                    confirmAdditionsSelection(answer);
                    break;
                case 3:
                    hamburger.removeFilling();
                    hamburger.removeCondiment();
                    System.out.print("Confirm selection? (Y / N) : ");
                    answer = SCANNER.next();
                    confirmAdditionsSelection(answer);
                    break;
            }
            processOrder();
        }
    }

    /**
     * Confirm selection for
     * additions and removals of additions.
     *
     * This method will be used
     * for all possible selection
     * options (i.e. for adding and removing fillings
     * and/or condiments)
     *
     * @param answer The answer for the confirmation
     */
    private void confirmAdditionsSelection(String answer) {
        boolean hasNotConfirmedSelection = true;

        while(hasNotConfirmedSelection) {
            if(answer.equalsIgnoreCase("Yes") ||
                    answer.equalsIgnoreCase("Y")) {
                hasNotConfirmedSelection = false;
            }
            else if(answer.equalsIgnoreCase("No") ||
                    answer.equalsIgnoreCase("N")) {
                removeAdditions();
                hasNotConfirmedSelection = false;
            }
            else {
                System.out.println("Please enter an appropriate answer (Yes / No)");
            }
        }
    }

    /**
     * Process the order and close the application
     */
    private void processOrder() {
        System.out.println("Thank you. Please see your order below: ");
        hamburger.displayOrderDetails();
        System.exit(0);
    }

    /**
     * Run the Bills Burger application here
     *
     * This method allows minimum code to be run in the main method
     */
    public void runApplication() {
        System.out.println("Hello! Welcome to Bills Burgers! Please select from the following options: \n"
                + "\t 1 - Standard Hamburger \n\t 2 - Healthy Burger \n\t 3 - Deluxe Burger");

        int burgerSelection = SCANNER.nextInt();
        switch(burgerSelection) {
            case 1:
                hamburger = new Hamburger();
                addMainIngredients();
                addAdditions();
                processOrder();
                break;
        }
    }
} 