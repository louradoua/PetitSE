package com.company;

import java.util.Arrays;

public class Regle {
    private String [] schema;
    private String [] valeurs;

    public Regle(String[]val){
        schema = new String[5];
        valeurs = new String[5];

        for (int i=0; i<5; i++){
            if (i<4) schema[i] = "Condition " + i;
            else schema[i] = "Conclusion";
            valeurs[i] = val[i];
        }
    }

    public String[] getSchema() {
        return schema;
    }

    public String[] getValeurs() {
        return valeurs;
    }

    @Override
    public String toString() {
        String res = "Regle{" ;
        for (int i=0; i<5; i++)
            res +=  schema[i] + ": " + valeurs[i];

        return res + "}";
    }
}
