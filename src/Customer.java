/*
 * Mitchell Hughes
 * Student Code: s3901335
 * Email: s3901335@student.rmit.edu.au
 * Date: 27/07/2022
 * 
 * This class is for storing the customers personal information which may be gathered during the online rental process.
 */

public class Customer {

    //Initialise attributes
    public String name;
    public String surname;
    public String email;  
    public Reservation reservation;

    //default constructor
    public Customer() {
        
    }

    //custom constructor
    public Customer(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    //Setters for attributes
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    //getters for attributes
    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public String getEmail() {
        return this.email;
    }
}
