package com.company;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while(option != 3){
            System.out.print("Enter option mr zoo keeper:");
            option = scanner.nextInt();
            if(option == 1){
                //Print animal details to console
                //We actually read through the file twice. Once to get details then once to print data... could
                //be optimized.. but hard to do without using data structures.
                ZooKeeperDataUtility utility = new ZooKeeperDataUtility("src/animal.txt","src/habitat.txt");
                utility.PrintDetailData("animal");
                System.out.print("Which animal option? ");
                int animalOption = scanner.nextInt();
                utility.PrintAnimalData(animalOption);
            }
            else if (option == 2){
                //would be to list your habitate
                //Print animal details to console
                ZooKeeperDataUtility utility = new ZooKeeperDataUtility("src/animal.txt","src/habitat.txt");
                utility.PrintDetailData("habitat");
                System.out.print("Which habitat option? ");
                int habitatOption = scanner.nextInt();
                utility.PrintHabitatData(habitatOption);
            }else
                break;
        }
    }
}
