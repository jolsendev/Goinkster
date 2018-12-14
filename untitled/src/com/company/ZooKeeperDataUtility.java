package com.company;

import sun.plugin.viewer.context.IExplorerAppletContext;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ZooKeeperDataUtility {
    private String aFP;
    private String hFP;
    private BufferedReader aBR;
    private BufferedReader hBR;
    private int animalArraySize = 0;
    private int habitatArraySize = 0;

    public ZooKeeperDataUtility(String animalFilePath, String habitatFilePath) throws IOException{
        this.aFP = animalFilePath;
        this.hFP = habitatFilePath;
        //get file buffer for animal file
        aBR = new BufferedReader(new FileReader(this.aFP));
        //get file buffer for habitat
        hBR = new BufferedReader(new FileReader(this.hFP));
    }


    public void PrintDetailData(String type) throws IOException{
        String line;
        int count = 1;
        switch (type.toLowerCase()){
            case "animal":
                count= 1;
                while ((line = aBR.readLine()) != null) {
                    if(line.contains("Details on")){
                        System.out.println("For "+line+" select: " + count++);
                        animalArraySize++;
                    }
                    else
                        //we break here so we do not go through the whole file..
                        break;
                }
                break;
            case "habitat":
                count = 1;
                while ((line = hBR.readLine()) != null) {
                    if(line.contains("Details on")){
                        System.out.println("For "+line+" select: " + count++);
                        habitatArraySize++;
                    }
                    else
                        //we break here so we do not go through the whole file..
                        break;
                }
                break;
        }
    }

    public boolean PrintAnimalData(int animalOption) throws IOException {

        if(!(animalOption <= animalArraySize)){
            return false;
        }
        String animal = getAnimal(animalOption);
        String line;
        if(animal != null){
            while ((line = aBR.readLine()) != null) {
                if(line.contains("Animal - "+animal) ){
                    System.out.println(line);
                    while ((line = aBR.readLine()) != null) {
                        if(!line.equals("")){
                            if(!line.contains("***")){
                                System.out.println(line);
                            }else{
                                DisplayMessage(line);
                                break;
                            }
                        }else{
                            break;
                        }

                    }
                }
            }
        }else{
            return false;
        }
        aBR.close();
        return true;
    }

    private void DisplayMessage(String line) {
        //replace all of the **** with
        line = line.replaceAll("[*]", "");
        JOptionPane.showMessageDialog(null, "Oh Shit! "+line);
    }

    private String getAnimal(int animalOption) throws IOException {
        //get animal type from string
        //going through the file a second time.
        aBR = new BufferedReader(new FileReader(this.aFP));
        int count= 1;
        String line;
        while ((line = aBR.readLine()) != null) {
            if(line.contains("Details on ") && count == animalOption ){
                String animal = line.substring(11, line.length()-1);
                animal = animal.substring(0, 1).toUpperCase() + animal.substring(1);
                return animal;
            }
            count++;
        }
        return null;
    }

    public boolean PrintHabitatData(int habitatOption) throws IOException {
        if(!(habitatOption <= habitatArraySize)){
            return false;
        }
        String habitat = getHabitat(habitatOption);
        String line;
        if(habitat != null){
            while ((line = hBR.readLine()) != null) {
                if(line.contains("Habitat - "+habitat) ){
                    System.out.println(line);
                    while ((line = hBR.readLine()) != null) {
                        if(!line.equals("")){
                            if(!line.contains("***")){
                                System.out.println(line);
                            }else{
                                DisplayMessage(line);
                                break;
                            }

                        }else{break;}
                    }
                }
            }
        }else{
            return false;
        }
        hBR.close();
        return true;
    }

    private String getHabitat(int habitatOption) throws IOException {
        //get animal type from string
        hBR = new BufferedReader(new FileReader(this.hFP));
        int count= 1;
        String line;
        while ((line = hBR.readLine()) != null) {
            if(line.contains("Details on ") && count == habitatOption ){
                String animal = line.substring(11);
                String[] a = animal.split(" ");
                animal = a[0];
                animal = animal.substring(0, 1).toUpperCase() + animal.substring(1);
                return animal;
            }
            count++;
        }
        return null;
    }
}
