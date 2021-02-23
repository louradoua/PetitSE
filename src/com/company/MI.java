package com.company;

import java.util.ArrayList;

public class MI {
    private BDF baseFaits;
    private BDR baseRegles;

    public MI(BDF bf, BDR br){
        baseFaits = bf;
        baseRegles = br;
    }



    private boolean condDansBDF(String cond){
        boolean s = false;
        // parcourir la base de faits
        ArrayList<String> contenu = baseFaits.getContenu();
        for (int i=0; i<baseFaits.getTaille();i++) {
            if (cond == contenu.get(i)) s = true;
        }
        // si on parcourt toute la boucle sans trouver, alors retourner faux
        return s;
    }

    // Pose la question de savoir si la règle existe bien avec les prémisses données
    private boolean regleDelenchee(Regle r){
        boolean s = true;
        String[] valeurs = r.getValeurs();

        for (int i=0;i<4;i++){
            if (!valeurs[i].equals("")){ // s'il y a effectivement une règle à vérifier
                if ((!condDansBDF(valeurs[i]))&&(!chainageArriere(valeurs[i]))){ // appel récursif au chainage arriere
                    s = false;
                    // si ni l'appel récursif ni les faits ne le permettent, alors on ne peut pas vérfier la ccl
                }
            }
        }
        return s; // sinon, on renvoie vrai
    }

    public boolean chainageArriere(String condAVerif){
        boolean s = false;
        if (condDansBDF(condAVerif)) s = true;
        else {
            for (int i=0;i<baseRegles.getTaille();i++){
                if (regleDelenchee(baseRegles.getContenu().get(i))) {
                    String conclusion = baseRegles.getContenu().get(i).getValeurs()[4];
                    if (conclusion.equals(condAVerif)) s = true;
                }
            }
        }
        return s;
    }

    public void chainageAvant(){
        // faire un tableau dejaDeclenchee de bool
        boolean[] dejaDeclenchee;

    }

    @Override
    public String toString() {
        return "MI{" +
                "baseFaits=" + baseFaits +
                ", baseRegles=" + baseRegles +
                '}';
    }
}
