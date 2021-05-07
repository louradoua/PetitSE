package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;

public class StreamDeRegles {
    private FileReader file;
    private BufferedReader buffer;
    private Regle regle; // règle courante lors du parcours du fichier par le buffer

    public StreamDeRegles(String fileName){
        try{
            file = new FileReader(fileName);
            buffer = new BufferedReader(file);
            System.out.println("File ready");
        }
        catch(Exception e){
            System.out.println("erreur de lecture");
        }
        String line = null;
        try{
            line = buffer.readLine();
            file.close();
        }
        catch(Exception e){
            System.out.println("erreur de lecture");
        }

        String[] head;
        head = line.split(";");
        regle = new Regle(head);
    }

    public Regle getRegleSuivante() {
        String line;
        try{
            line = buffer.readLine();
            String[] head;
            head = line.split(";");
            regle.setRegle(head);
            buffer.close();
            return regle;
        }
        catch(Exception e){
            System.out.println("erreur de lecture");
            return null;
        }

    }

    @Override
    public String toString() {
        return "StreamDeRegles{" +
                "file=" + file +
                ", buffer=" + buffer +
                ", regle=" + regle +
                '}';
    }
}
