/*
 * Mitchell Hughes
 * Student Code: s3901335
 * Email: s3901335@student.rmit.edu.au
 * Date: 27/07/2022
 * 
 * This class is the class where the main method is for the MyCar program.
 */

import java.io.*; //importing io package for file reading


public class Main {
    public static void main(String[] args) throws IOException {        

        //load the csv file into arraylist
        MyCar.carList = Database.readVehicleInfo();        
        
        //run program
        System.out.println("Welcome to My Car!");
        MyCar.mainMenu();
    }
}
