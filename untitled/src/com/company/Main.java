package com.company;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static String[] detailsAnimal;
    private static String[] detailsHabitat;
    public static void main(String[] args) throws IOException {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        //detailsHabitat = utility.GetDetailArray("habitat");

        int option = 0;
        while(option != 3){
            System.out.print("Enter option mr zoo keeper:");
            option = scanner.nextInt();
            if(option == 1){
                //Print animal details to console
                ZooKeeperDataUtility utility = new ZooKeeperDataUtility("src/animal.txt","src/habitat.txt");
                utility.PrintDetailData("animal");
                System.out.print("Which animal option? ");
                int animalOption = scanner.nextInt();
                utility.PrintAnimalData(animalOption);
//                detailsAnimal = utility.GetDetailArray("animal");
//                printDetails("animal");
            }
            else if (option == 2){
                //would be to list your habitate
                printDetails("habitat");
                System.out.println("1. For Habitat ");
                System.out.println("1. For Habitat ");
                System.out.println("1. For Habitat ");
                System.out.println("1. For Habitat ");
            }else
                break;
        }
        //here is you jframe example

    }

    private static void printDetails(String type) {
        //get detail count
        switch (type.toLowerCase()){
            case "animal":

                for (int i = 0; i < detailsAnimal.length; i++) {
                    System.out.println("For " + detailsAnimal[i] + " enter " + i + "");
                }
                break;
            case "habitat":
                for (int i = 0; i < detailsHabitat.length; i++) {
                    System.out.println("For " + detailsHabitat[i] + " enter " + i + "");
                }
                break;
            default:
                System.out.println("No details");
                break;
        }
    }
}
