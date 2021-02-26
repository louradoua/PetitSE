package com.company;

import java.util.ArrayList;

// Servez vous la mif mais oubliez pas de comprendre un peu le principe sinon ça va se voir mdr
// Surtout modifiez la variable s de sortie des fonctions, c'est propre à ma manière de codé donc c'est cramé af


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


    private boolean regleDelenchee(Regle r){
        boolean s = true;
        String[] valeurs = r.getValeurs();

        for (int i=0;i<4;i++){
            if (!valeurs[i].equals("")){ // s'il y a effectivement une règle à vérifier
                if (!condDansBDF(valeurs[i])){
                    s = false;
                }
            }
        }
        return s; // sinon, on renvoie vrai
    }

    public void chainageAvant(){
        // faire un tableau dejaDeclenchee de bool de la taille de la base de règles
        boolean[] dejaDeclenchee = new boolean[baseRegles.getTaille()];
        /*for (int i=0;i<dejaDeclenchee.length;i++) dejaDeclenchee[i] = false;*/

        int cpt = 0; // compte les nouvelles découvertes au tour courant du tant que
        do {
            for (int i=0;i<baseRegles.getTaille();i++){
                if (!dejaDeclenchee[i]){
                    Regle r = baseRegles.getContenu().get(i);
                    if (regleDelenchee(r)) {
                        dejaDeclenchee[i] = true;
                        baseFaits.ajoutBDF(r.getValeurs()[4]);
                        cpt += 1;
                    }
                }
            }
        } while (cpt!=0);
    }


    // Pose la question de savoir si la règle existe bien avec les prémisses données
    private boolean verifRegleArriere(Regle r){
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
                if (verifRegleArriere(baseRegles.getContenu().get(i))) {
                    String conclusion = baseRegles.getContenu().get(i).getValeurs()[4];
                    if (conclusion.equals(condAVerif)) s = true;
                }
            }
        }
        return s;
    }

    @Override
    public String toString() {
        return "MI{" +
                "baseFaits=" + baseFaits +
                ", baseRegles=" + baseRegles +
                '}';
    }
}
