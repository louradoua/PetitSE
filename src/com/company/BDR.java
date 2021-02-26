package com.company;

import java.util.ArrayList;

public class BDR {
    private ArrayList<Regle> contenu;
    private int taille;
    private String fileName;

    public BDR(String nomBDR){

        contenu = new ArrayList<Regle>();
        fileName = nomBDR;
        StreamDeRegles h = new StreamDeRegles(nomBDR);
        taille = 0;
        while (h.getRegleSuivante() != null){
            contenu.add(h.getRegleSuivante());
            taille++;
        }
        /*String[] t1 = {"personne_aisee","temps_libre","","","peut_voyager"};
        Regle r1 = new Regle(t1);
        contenu.add(r1);

        String[] t2 = {"temps_libre","","","","peut_faire_poterie"};
        Regle r2 = new Regle(t2);
        contenu.add(r2);

        String[] t3 = {"peut_peindre","","","","peut_faire_produit_artisanal"};
        Regle r3 = new Regle(t3);
        contenu.add(r3);

        String[] t4 = {"peut_faire_poterie","","","","peut_faire_produit_artisanal"};
        Regle r4 = new Regle(t4);
        contenu.add(r4);

        String[] t5 = {"peut_faire_produit_artisanal","","","","peut_faire_oeuvre_art"};
        Regle r5 = new Regle(t5);
        contenu.add(r5);*/

        taille = contenu.size();
    }

    public ArrayList<Regle> getContenu() {
        return contenu;
    }

    public int getTaille() {
        return taille;
    }

    @Override
    public String toString() {
        return "BDR{" +
                "contenu=" + contenu +
                ", taille=" + taille +
                '}';
    }
}
