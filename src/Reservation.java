/*
 * Mitchell Hughes
 * Student Code: s3901335
 * Email: s3901335@student.rmit.edu.au
 * Date: 27/07/2022
 * 
 * This class is for storing the reservation information
 */

public class Reservation {
    //declare attributes
    Customer customer;
    public int numPassengers;
    public String pickUpDate;
    public String returnDate;
    public int numDaysRent;
    public double totalPrice;  

    //default constructor
    public Reservation() {

    }

    //custom constructor
    public Reservation(Customer customer, int numPassengers, String pickUpDate, String returnDate, int numDaysRent, double totalPrice) {
        this.customer = customer;
        this.numDaysRent = numDaysRent;
        this.numPassengers = numPassengers;
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.totalPrice = totalPrice;

    }
    
    //setters
    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }
    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    public void setNumDaysRent(int numDaysRent) {
        this.numDaysRent = numDaysRent;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    //getters
    public Customer getCustomer() {
        return customer;
    }
    public int getNumPassengers() {
        return this.numPassengers;
    }
    public String getReturnDate() {
        return returnDate;
    }
    public String getPickUpDate() {
        return pickUpDate;
    }
    public int getNumDaysRent() {
        return numDaysRent;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
}
