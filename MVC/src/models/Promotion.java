package models;

import views.Observateur;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Contient une liste d'étudiant
 * @see Etudiant
 */

public class Promotion implements Observable {

    /**
     * Liste des étudiants de la promo
     */
    private ArrayList<Etudiant> list;

    /**
     * Liste des observateurs de la promo
     */
    private ArrayList<Observateur> observateurs = null;

    /**
     * Constructeur de la promotion (initialise une liste d' étudiant)
     */
    public Promotion() {
        list = new ArrayList<Etudiant>();
    }

    /**
     *  Ajoute un étudiant de la promotion
     * @param etu Etudiant
     */
    public void addEtudiant(Etudiant etu) {
        list.add(etu);
        notifyObservateurs();
    }

    /**
     * Supprime un étudiant de la promotion
     * @param etu Etudiant
     */
    public void removeEtudiant(Etudiant etu) {
        list.remove(etu);
        notifyObservateurs();
    }

    /**
     * Renvoie la promo
     * @return Liste d'étudiant
     */
    public ArrayList<Etudiant> getListeEtudiants() {
        return list;
    }

    /**
     * Recherche dans la promo l'étudiant ayant le numéro id
     * @param id Numéro étudiant
     * @return Etudiant
     */
    public Etudiant searchEtudiant(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().compareTo(id) == 0) {
                return list.get(i);
            }
        }
        return null;
    }

    /**
     * Récupère le nombre d'étudiant par type de bac
     * @return Tableau de int
     */
    public int[] seriesbacs() {
        int[] tab = new int[6];
        for (int i = 0; i < tab.length; i++)
            tab[i] = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSerieBac().compareToIgnoreCase("S") == 0)
                tab[0]++;
            else if (list.get(i).getSerieBac().compareToIgnoreCase("ES") == 0)
                tab[1]++;
            else if (list.get(i).getSerieBac().compareToIgnoreCase("STI") == 0)
                tab[2]++;
            else if (list.get(i).getSerieBac().compareToIgnoreCase("STG") == 0)
                tab[3]++;
            else if (list.get(i).getSerieBac().compareToIgnoreCase("Etranger") == 0)
                tab[4]++;
            else if (list.get(i).getSerieBac().compareToIgnoreCase("Autre") == 0)
                tab[5]++;
        }
        return tab;
    }

    /**
     * Demande un fichier CSV à l'utilisateur et initialise la promo avec
     */
    public void loadFileCSV() {
        String ligne, idt, nom, prenom, dept, bac;
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("./MVC/src/res"));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                FileInputStream fichier_int = new FileInputStream(fileChooser.getSelectedFile());
                InputStreamReader inputs = new InputStreamReader(fichier_int, "Latin1");
                BufferedReader input = new BufferedReader(inputs);
                while ((ligne = input.readLine()) != null) {
                    String[] fields = ligne.split(";");
                    addEtudiant(new Etudiant(fields[0], fields[1], fields[2], fields[4], fields[3]));
                }
                System.out.println("Liste chargée");
                input.close();
            }
        } catch (Exception exception) {
            System.out.println("Probleme import csv : ");
        }
    }

    @Override
    public void addObservateur(Observateur observateur) {

        if (observateurs == null) observateurs = new ArrayList<>();

        if (!observateurs.contains(observateur)) observateurs.add(observateur);
    }

    @Override
    public boolean removeObservateur(Observateur observateur) {
        if (observateurs != null) return observateurs.remove(observateur);
        return false;
    }

    @Override
    public void notifyObservateurs() {
        if(observateurs == null) return;
        for (Observateur observateur : observateurs) observateur.onUpdate();
    }
}
