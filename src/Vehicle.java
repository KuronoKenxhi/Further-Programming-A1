/*
 * Mitchell Hughes
 * Student Code: s3901335
 * Email: s3901335@student.rmit.edu.au
 * Date: 27/07/2022
 * 
 * This class is for storing the vehicle information
 */

public class Vehicle {
    public String vehicleID;
    public String brand;
    public String model;
    public String type;
    public String yearManufactured;
    public String numSeats;
    public String colour;
    public String rentalPerDay;
    public String insurancePerDay;
    public String serviceFee;
    public String discount;

    //defualt constructor
    public Vehicle() {
        
    }

    //custom constructor
    public Vehicle(String vehicleid, String brand, String model, String type, String yearManufactured, 
                    String numSeats, String colour, String rentalPerDay, String insurancePerDay, 
                    String serviceFee, String discount) {
        
        this.vehicleID = vehicleid;
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.yearManufactured = yearManufactured;
        this.numSeats = numSeats;
        this.colour = colour;
        this.rentalPerDay = rentalPerDay;
        this.insurancePerDay = insurancePerDay;
        this.serviceFee = serviceFee;
        this.discount = discount;
    }
    
    //getter and setter for ID
    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    //getter and setter for brand
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //getter and setter for model
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    //getter and setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //getter and setter for yearmanufactured
    public String getYearManufactured() {
        return yearManufactured;
    }

    public void setYearManufactured(String yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    //getter and setter for number of seats
    public String getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(String numSeats) {
        this.numSeats = numSeats;
    }

    //getter and setter for colour
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    //getter and setter for rental price per day
    public String getRentalPerDay() {
        return rentalPerDay;
    }

    public void setRentalPerDay(String rentalPerDay) {
        this.rentalPerDay = rentalPerDay;
    }

    //getter and setter for insurance per day
    public String getInsurancePerDay() {
        return insurancePerDay;
    }

    public void setInsurancePerDay(String insurancePerDay) {
        this.insurancePerDay = insurancePerDay;
    }

    //getter and setter for service fee
    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    //getter and setter for discount percentage
    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    
}
