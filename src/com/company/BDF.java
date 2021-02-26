package com.company;

import java.awt.image.DataBufferDouble;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

public class BDF {
    private ArrayList<String> contenu;
    private int taille;
    private String fileName;

    public BDF(String nomBDF){
        //String fait="";
        contenu = new ArrayList<String>();
        fileName = nomBDF;
        BufferedReader buffer;
        String line;
        try {
            buffer = new BufferedReader(new FileReader(fileName));
            do{
                line = buffer.readLine();
                contenu.add(line);
            } while (line != null && line != "");
            buffer.close();
        }
        catch (Exception e) {
            System.out.println("[Error opening file in BDF]" + e);
        }


        /*Scanner entree =  new Scanner(System.in);
        System.out.println("Saisie des faits (terminer par la fin)");
        while (!fait.equals("fin")){
            System.out.println("fait :");
            fait = entree.nextLine();
            if (!fait.equals("fin")) contenu.add(fait);
        }*/
        taille = contenu.size();
    }


    public ArrayList<String> getContenu() {
        return contenu;
    }

    public int getTaille() {
        return taille;
    }

    public void ajoutBDF(String fait){
        contenu.add(fait);
        taille += 1;
    }

    public void majFichier(){
        FileWriter file;
        try {
            file = new FileWriter(fileName);
            for (int i=0;i<taille;i++){
                file.write(contenu.get(i)+";\n");
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "BDF{" +
                "contenu=" + contenu +
                ", taille=" + taille +
                '}';
    }
}
