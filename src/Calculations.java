/*
 * Mitchell Hughes
 * Student Code: s3901335
 * Email: s3901335@student.rmit.edu.au
 * Date: 27/07/2022
 * 
 * This class is the class for calculations using various formulas
 */

//import statements for use later in code 
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Calculations {
    //method to calculate rental price for duration of rent
    public static double calculateRentalPrice(String rentalPerDayS, String insurancePerDayS, String serviceFeeS, int numDaysRent, String discountPercent) {
        
        //initialise discount rate
        double discountRate = 0;
        if(discountPercent.equalsIgnoreCase("N/A")) {
            //if discount percentage is N/A set the rate to 0
            discountRate = 0.00;
        }
        else {
            //else, calculate the discount rate based on the percentage given
            discountRate = (100 - Double.parseDouble(discountPercent)) / 100;
        }

        //type cast all variables to int for calculations
        double rentalPerDay = Double.parseDouble(rentalPerDayS);
        double insurancePerDay = Double.parseDouble(insurancePerDayS);
        double serviceFee = Double.parseDouble(serviceFeeS);
        
        //initialise rentalPrice
        Double rentalPrice = 0.00;
        
        if(numDaysRent >= 7) {
            //uses given formula to calculate the rental price with discount if number of days is greater than or equal to 7
            rentalPrice = (((rentalPerDay * discountRate) + insurancePerDay) * numDaysRent) + serviceFee;
        }
        else {
            //else uses formula to calculate rental price without discount
            rentalPrice = ((rentalPerDay + insurancePerDay) * numDaysRent) + serviceFee;
        }
        
        return rentalPrice;
    }

    //method to check if dates entered are valid
    public static Boolean isValidDate(String pickUpDate, String returnDate) {

        //initialise result variable
        Boolean result = false;

        //First check if date is empty or not
        if(pickUpDate.isEmpty() == false && returnDate.isEmpty() == false) {
            //Setting correct date format
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);

            //Initialise date object and handle exceptions
            try {
                Date fmtPickUp = dateFormat.parse(pickUpDate);
                Date fmtReturnDate = dateFormat.parse(returnDate);

                //check dates if return is before pickup
                if(fmtPickUp.before(fmtReturnDate) == false) {
                    result = false;
                    System.out.println("Return date cannot be earlier than the Pick-up date!");
                }

                //date is valid, therefore set result to true
                result = true;

            }
            //handle exceptions
            catch(ParseException e) {
                result = false;
                System.out.println(pickUpDate + " and " + returnDate + " is not a valid date!");
            }
            catch(NullPointerException e) {
                e.printStackTrace();
            }

            
        }

        //return result of validation
        return result;
    }

    //We will use this method under the assumption that the dates are valid
    public static int calculateNumDaysRental(String pickUpDate, String returnDate) {

        //Initialise numDays and result
        int numDays = -1;
        long result = 0;

        //Initialise date format
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

        try {
            //create date objects using date format
            Date datePickUp = fmt.parse(pickUpDate);
            Date dateReturn = fmt.parse(returnDate);

            //find difference between dates in days
            long daysBetween = datePickUp.getTime() - dateReturn.getTime();
            result = TimeUnit.DAYS.convert(daysBetween, TimeUnit.MILLISECONDS);
        }
        catch(ParseException e) {
            e.printStackTrace();
        }

        //convert back to int from long
        numDays = Math.abs((int) result);

        return numDays;
    }
}
