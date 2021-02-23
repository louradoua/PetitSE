package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class BDF {
    private ArrayList<String> contenu;
    private int taille;

    public BDF(){
        String fait="";
        contenu = new ArrayList<String>();
        Scanner entree =  new Scanner(System.in);
        System.out.println("Saisie des faits (terminer par la fin)");
        while (!fait.equals("fin")){
            System.out.println("fait :");
            fait = entree.nextLine();
            if (!fait.equals("fin")) contenu.add(fait);
        }
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


    @Override
    public String toString() {
        return "BDF{" +
                "contenu=" + contenu +
                ", taille=" + taille +
                '}';
    }
}
