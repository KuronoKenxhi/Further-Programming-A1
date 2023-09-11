/*
 * Mitchell Hughes
 * Student Code: s3901335
 * Email: s3901335@student.rmit.edu.au
 * Date: 27/07/2022
 * 
 * This class is the core class for the MyCar program which has the menu functionality
 */

import java.util.*; //importing Util Package for Scanner and ArrayList classes

public class MyCar { 

    //initialise ArrayList
    public static ArrayList<Vehicle> carList;

    //initialise customer, reservation and vehicle objects
    public static Customer customer = new Customer();
    public static Reservation reservation = new Reservation();
    private static Vehicle orderedVehicle;    

    /*
    * Main Menu Method
    */
    public static void mainMenu() {
        
        //initialise scanner class
        Scanner scan = new Scanner(System.in);

        //declare selection variable
        int selection;

        //do while loop to loop back to main menu
        do {
            //initialise choice variable
            selection = 0;

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("> Select from main menu");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("1) Search by brand");
            System.out.println("2) Browse by vehicle type");
            System.out.println("3) Filter by number of passengers");
            System.out.println("4) Exit");
            System.out.print("Please select: ");
        
            //Takes input from console to select an option on the main menu
            selection = scan.nextInt();
            
            //switch case to branch out to each menu option
            switch(selection) {
                case 1:
                    searchByBrand();
                    break;
                case 2:
                    browseByType();
                    break;
                case 3:
                    filterByNumPassengers();
                    break;
                case 4:
                    break;
                default:
                    selection = 0;
                    break;
            }

        //while condition to ensure that all inputs are within 1-3
        }while(selection < 1 || selection > 3);

        //close scanner to stop memory leaks
        scan.close();
    }

    /*
     * Menu Option 1: Search by brand
     */
    public static void searchByBrand() {
        //Initialise scanner
        Scanner scan = new Scanner(System.in);

        //initialise selection variable
        int selection1;

        //get brand input from user
        System.out.print("Please Provide a brand: ");

        //take input from user
        String brand = scan.next();

        //Initialise a new ArrayList of Vehicles for search result
        ArrayList<Vehicle> results = new ArrayList<Vehicle>();
        
        //iterates through carList arraylist to append to results arraylist
        for(int i = 0; i <= carList.size() - 1; i++) {
            //compares the brand names of each vehicle in carList
            if(carList.get(i).brand.equalsIgnoreCase(brand)) {
                //add vehicle to result arrayList if matching
                results.add(carList.get(i));
            }
        }

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("> Select from matching list");
        System.out.println("----------------------------------------------------------------------------");

        //prints no results if results arraylist is empty
        if(results.isEmpty()==true) {
            System.out.println("No search results");
        }
        else {
            //show search results in required format
            for(int k = 0; k < 3; k++) {
                System.out.println(
                                (k + 1) + ") "
                                + results.get(k).vehicleID + " - " 
                                + results.get(k).brand + " " 
                                + results.get(k).model + " " 
                                + results.get(k).type + " with " 
                                + results.get(k).numSeats + " seats");
            }
        }

        
        
        //prints the go back to main menu option
        System.out.println("4) Go to Main Menu");

        //asks user for input and stores menu selection as int
        System.out.println("Please select: ");
        selection1 = scan.nextInt();

        switch(selection1) {
            case 1:
                orderedVehicle = results.get(0);
                provideDates();
                showVehicleDetails();
                break;
            case 2:
                orderedVehicle = results.get(1);
                provideDates();
                showVehicleDetails();
                break;
            case 3:
                orderedVehicle = results.get(2);
                provideDates();
                showVehicleDetails();
                break;
            case 4:
                break;
        }

        //close scanner to stop memory leak
        scan.close();
    } 

    /*
     * Menu Option 2: Browse by Vehicle type
     */
    public static void browseByType() {

        //initialise scanner class
        Scanner scan = new Scanner(System.in);

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("> Browse by type of vehicle");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("1) Sedan");
        System.out.println("2) Hatch");
        System.out.println("3) SUV");
        System.out.println("4) Go to main menu");
        System.out.print("Please select: ");

        //Take input from console to continue navigating the menu
        int selection2 = scan.nextInt();

        // Switch statement to show search results for each type
        String type = "";
        switch(selection2) {
            case 1:
                type = "Sedan";
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("> Select from list of Sedans");
                System.out.println("----------------------------------------------------------------------------");
                break;
            case 2:
                type = "Hatch";
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("> Select from list of Hatchs");
                System.out.println("----------------------------------------------------------------------------");
                break;
            case 3:
                type = "SUV";
                System.out.println("----------------------------------------------------------------------------");
                System.out.println("> Select from list of SUVs");
                System.out.println("----------------------------------------------------------------------------");
                break;
            case 4:
                //TODO find replacement for sys.exit()
                System.exit(0);
        }

        //Initialise a new ArrayList of Vehicles for search result
        ArrayList<Vehicle> results = new ArrayList<Vehicle>();

        //iterates through carList arraylist to append to results arraylist
        for(int i = 0; i <= carList.size() - 1; i++) {
            //compares the type names of each vehicle in carList
            if(carList.get(i).type.equals(type)) {
                //add vehicle to result arrayList if matching
                results.add(carList.get(i));
            }
        }

        //prints no results if results arraylist is empty
        if(results.isEmpty()==true) {
            System.out.println("No search results");
        }
        else {
            //show search results in required format
            for(int k = 0; k < 3; k++) {
                System.out.println(
                                (k + 1) + ") "
                                + results.get(k).vehicleID + " - " 
                                + results.get(k).brand + " " 
                                + results.get(k).model + " " 
                                + results.get(k).type + " with " 
                                + results.get(k).numSeats + " seats");
            }
        }
        
        System.out.println("4) Go to Main Menu");

        //asks user for input and stores menu selection as int
        System.out.println("Please select: ");
        selection2 = scan.nextInt();
        
        switch(selection2) {
            case 1:
                orderedVehicle = results.get(0);
                provideDates();
                showVehicleDetails();
                break;
            case 2:
                orderedVehicle = results.get(1);
                provideDates();
                showVehicleDetails();
                break;
            case 3:
                orderedVehicle = results.get(2);
                provideDates();
                showVehicleDetails();
                break;
            case 4:  
                //TODO find replacement for sys.exit()
                System.exit(0);
            default:
                break;
        }
        
        //close scanner to stop memory leak
        scan.close();
    }
    
    /*
     * Menu Option 3: Filter by number of passengers
     */
    public static void filterByNumPassengers() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please Provide the number of passengers: ");
        String numPassengers = scan.next();

        //Initialise a new ArrayList of Vehicles for search result
        ArrayList<Vehicle> results = new ArrayList<Vehicle>();
        
        //iterates through carList arraylist to append to results arraylist
        for(int i = 0; i <= carList.size() - 1; i++) {
            //compares the number of seats of each vehicle in carList
            if(carList.get(i).numSeats.equals(numPassengers)) {
                //add vehicle to result arrayList if matching
                results.add(carList.get(i));
            }
        }

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("> Select from matching list");
        System.out.println("----------------------------------------------------------------------------");

        //prints no results if results arraylist is empty
        if(results.isEmpty()==true) {
            System.out.println("No search results");
        }
        else {
            //show search results in required format
            for(int k = 0; k < 3; k++) {
                System.out.println(
                                (k + 1) + ") "
                                + results.get(k).vehicleID + " - " 
                                + results.get(k).brand + " " 
                                + results.get(k).model + " " 
                                + results.get(k).type + " with " 
                                + results.get(k).numSeats + " seats");
            }
        }
        //prints the go back to main menu option with dynamic number prefix
        System.out.println("4) Go to Main Menu");

        //asks user for input and stores menu selection as int
        System.out.println("Please select: ");
        int selection = scan.nextInt();

        switch(selection) {
            case 1:
                orderedVehicle = results.get(0);
                provideDates();
                showVehicleDetails();
                break;
            case 2:
                orderedVehicle = results.get(1);
                provideDates();
                showVehicleDetails();
                break;
            case 3:
                orderedVehicle = results.get(2);
                provideDates();
                showVehicleDetails();
                break;
            case 4:  
                //TODO find replacement for sys.exit()
                System.exit(0);
            default:
                break;
        }
        
        //close scanner to stop memory leak
        scan.close();
    }

    /*
     * Provide dates method for pick up and return dates
     */
    public static void provideDates() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("> Provide dates");
        System.out.println("----------------------------------------------------------------------------");

        //Initialise scanner
        Scanner scan = new Scanner(System.in);

        //asks user for pick up and return dates
        System.out.print("Please provide pick-up date (dd/mm/yyyy): ");
        String pickUpDate = scan.next();
        System.out.print("Please provide return date (dd/mm/yyyy): ");
        String returnDate = scan.next();

        Boolean datesValid = Calculations.isValidDate(pickUpDate, returnDate);

        //if dates are valid set pickup and return dates
        if(datesValid == true) {
            //set pickup and return dates of customer obj
            reservation.setPickUpDate(pickUpDate);
            reservation.setReturnDate(returnDate);
            reservation.setNumDaysRent(Calculations.calculateNumDaysRental(pickUpDate, returnDate));
        }
        else {
            //TODO find alternative to sys.exit()
            System.exit(0);
        }

        
        
    }

    /*
     * Vehicle information summary for final confirmation before order
     */
    public static void showVehicleDetails() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("> Show vehicle details");
        System.out.println("----------------------------------------------------------------------------");        
        
        //Initialise and calculate total insurance price, service fee price and rentalprice not including service fee and insurance
        Double insurancePrice = reservation.numDaysRent * Double.parseDouble(orderedVehicle.insurancePerDay);
        Double serviceFeePrice = Double.parseDouble(orderedVehicle.serviceFee);
        Double rentalPrice = reservation.numDaysRent * Double.parseDouble(orderedVehicle.rentalPerDay);
        
        //change discount message depending on whether or not they can get a discount
        String discountMessage;
        Double discountedPrice;
        if(reservation.numDaysRent >= 7) {
            //prints the discount percentage followed by percentage sign
            discountMessage = orderedVehicle.discount + "%";
            //sets to the rate for calculating the rental price with discount
            discountedPrice = rentalPrice * ((100 - Double.parseDouble(orderedVehicle.discount))/100);
        }
        else {
            //prints if discount is not applicable
            discountMessage = "Discount is not applicable";
            //prints rentalPrice back without any discount
            discountedPrice = rentalPrice;
        }
        
        //use formula in Calculations class to calculate total rental price
        reservation.totalPrice = Calculations.calculateRentalPrice(orderedVehicle.rentalPerDay, orderedVehicle.insurancePerDay, orderedVehicle.serviceFee, reservation.numDaysRent, orderedVehicle.discount);
        
        //uses printf statements to print out all the information formatted as a table
        System.out.printf("%-20s\t%-20s\n", "Vehicle:", orderedVehicle.vehicleID);
        System.out.printf("%-20s\t%-20s\n", "Brand:", orderedVehicle.brand);
        System.out.printf("%-20s\t%-20s\n", "Model:", orderedVehicle.model);
        System.out.printf("%-20s\t%-20s\n", "Type of Vehicle:", orderedVehicle.type);
        System.out.printf("%-20s\t%-20s\n", "Year of Manufacture:", orderedVehicle.yearManufactured);
        System.out.printf("%-20s\t%-20s\n", "No. of Seats:", orderedVehicle.numSeats);
        System.out.printf("%-20s\t%-20s\n", "Colour:", orderedVehicle.colour);
        System.out.printf("%-20s\t%-20s%-20s\n", "Rental:", "$" + rentalPrice, "($" + orderedVehicle.rentalPerDay + " * " + reservation.numDaysRent + " days)");
        System.out.printf("%-20s\t%-20s%-20s\n", "Discounted Price:", "$" + discountedPrice, "(" + discountMessage + ")");
        System.out.printf("%-20s\t%-20s%-20s\n", "Insurance:", "$" + insurancePrice, "($" + orderedVehicle.insurancePerDay + " * " + reservation.numDaysRent + " days)");
        System.out.printf("%-20s\t%-20s\n", "Service Fee:", "$" + serviceFeePrice);
        System.out.printf("%-20s\t%-20s\n", "Total:", "$" + reservation.totalPrice);
        System.out.println("");

        //initialise scanner
        Scanner scan = new Scanner(System.in);

        //ask for input
        System.out.print("Would you like to reserve the vehicle (Y/N)? ");
        String selection = scan.next();
        
        //loop until the input is correct ("Y")
        while((!selection.equalsIgnoreCase("Y"))) {

            if(selection.equalsIgnoreCase("N")) {
                break;
            }
            System.out.println("Please enter a valid character!");
            selection = scan.next();
        }

        if(selection.equalsIgnoreCase("Y")) {
            //move onto next step in menu
            providePersonalInfo();
        }
        

        //close scan to stop memory leak
        scan.close();
    }
    
    /*
     * Personal Information input method to gather customer personal information
     */
    public static void providePersonalInfo() {
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("> Provide personal information");
        System.out.println("----------------------------------------------------------------------------");

        //Initialise scanner
        Scanner scan = new Scanner(System.in);

        //take input from user and gather information on customer
        System.out.print("Please provide your given name: ");
        customer.name = scan.next();

        System.out.print("Please provide your surname: ");
        customer.surname = scan.next();

        System.out.print("Please provide your email address: ");
        customer.email = scan.next();

        System.out.print("Please provide the number of passengers: ");
        reservation.numPassengers = scan.nextInt();

        //checks if number of passengers is smaller than numSeats
        if(reservation.numPassengers > Integer.parseInt(orderedVehicle.numSeats)) {
            System.out.println("Too many passengers for this vehicle!");
        }

        System.out.println("Confirm and pay (Y/N)");
        String selection = scan.next();

        
        //loop until the input is correct ("Y")
        while((!selection.equalsIgnoreCase("Y"))) {
            
            if(selection.equalsIgnoreCase("N")) {
                break;
            }
            System.out.println("Please enter a valid character!");
            selection = scan.next();
        }

        if(selection.equalsIgnoreCase("Y")) {
            //use printf's to format output in columns
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("> Congratulations! Your vehicle is booked. A receipt has been sent to your email. ");
            System.out.println("  We will soon be in touch before your pick-up date.");
            System.out.println("----------------------------------------------------------------------------");

            System.out.printf("%-20s\t%-20s\n", "Name:", customer.name + " " + customer.surname);
            System.out.printf("%-20s\t%-20s\n", "Email:", customer.email);
            System.out.printf("%-20s\t%-20s\n", "Your Vehicle:", orderedVehicle.brand + " "
                                                                            + orderedVehicle.model + " "
                                                                            + orderedVehicle.type + " with "
                                                                            + orderedVehicle.numSeats + " seats");
            
            System.out.printf("%-20s\t%-20s\n", "Number of Passengers:", orderedVehicle.numSeats);
            System.out.println("");
            System.out.printf("%-20s\t%-20s\n", "Pick-Up Date:", reservation.pickUpDate);
            System.out.println("");
            System.out.printf("%-20s\t%-20s\n", "Return Date:", reservation.returnDate);
            System.out.println("");

            //print the total price
            System.out.printf("%-20s\t%-20s\n", "Total Payment:", "$" + reservation.totalPrice);
        }

        //close scan to stop memory leak
        scan.close();
    }
}
