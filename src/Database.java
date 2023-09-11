/*
 * Mitchell Hughes
 * Student Code: s3901335
 * Email: s3901335@student.rmit.edu.au
 * Date: 27/07/2022
 * 
 * This class is for storing the vehicle information from the csv for use in the online rental program.
 */

import java.io.*;
import java.util.*;

public class Database {
    /*
     * Reads csv file and returns a collection of Vehicles in the form of an array list of type vehicles
     */
    public static ArrayList<Vehicle> readVehicleInfo() throws IOException {
        
        //initialise arraylist to store vehicle information
        ArrayList<Vehicle> carList = new ArrayList<Vehicle>();

        try {
            //read from Fleet.csv file
            BufferedReader read = new BufferedReader(new FileReader("resources/Fleet.csv"));

            //initialise scanner, line and index
            Scanner scan = null;
            String line = null;
            int index = 0;

            

            //iterate through file line by line
            while((line = read.readLine()) != null) {

                //initialise car object to store vehicle information
                Vehicle car = new Vehicle();
                //initialise scanner and select delimiter
                scan = new Scanner(line);
                scan.useDelimiter(",");

                //iterate through each line, word by word
                while(scan.hasNext()) {

                    //store data as String variable
                    String info = scan.next();

                    //use setter for each attribute depending on value of index
                    if(index == 0) {
                        car.setVehicleID(info);
                    }
                    else if(index == 1) {
                        car.setBrand(info);
                    }
                    else if(index == 2) {
                        car.setModel(info);
                    }
                    else if(index == 3) {
                        car.setType(info);
                    }
                    else if(index == 4) {
                        car.setYearManufactured(info);
                    }
                    else if(index == 5) {
                        car.setNumSeats(info);
                    }
                    else if(index == 6) {
                        car.setColour(info);
                    }
                    else if(index == 7) {
                        car.setRentalPerDay(info);
                    }
                    else if(index == 8) {
                        car.setInsurancePerDay(info);
                    }
                    else if(index == 9) {
                        car.setServiceFee(info);
                    }
                    else if(index == 10) {
                        car.setDiscount(info);
                    }
                    //increment index for following iteration of the loop
                    index ++;
                }
                //reset index to 0 so that the next line starts at index 0 again
                index = 0;

                //append car object to arraylist
                carList.add(car);
        
            }

            //close scanners to stop possible memory leaks
            read.close();
            scan.close();

            //iterate through arraylist to find the Vehicle obj that has the attribute names stored.
            for(int i = 0; i <= carList.size() - 1; i++) {
                //compares the vehicle ID of each VehicleObj to find the one that has the column name "Vehicle ID"
                if(carList.get(i).vehicleID.equals("Vehicle ID")) {
                    carList.remove(i);
                }
            }
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return carList;
    }
}