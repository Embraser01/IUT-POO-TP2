package views;

import models.Etudiant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public class FormFrame extends JInternalFrame {

    private ArrayList<Etudiant> dataList;

    private JPanel pano;
    private GridBagConstraints cont;

    private JLabel addEtu;
    private JLabel delEtu;
    private JLabel numAdd;
    private JLabel numDel;
    private JLabel prenom;
    private JLabel nom;
    private JLabel bac;
    private JLabel dpt;

    private JTextField numAddEdit;
    private JTextField numDelEdit;
    private JTextField prenomEdit;
    private JTextField nomEdit;

    private JComboBox bacCombo;
    private JComboBox dptCombo;

    private JButton addBtn;
    private JButton delBtn;

    public FormFrame(ArrayList<Etudiant> dataList) {

        this.dataList = dataList;

        this.pano = new JPanel();
        this.pano.setLayout(new GridBagLayout());

        this.addEtu = new JLabel("Ajouter un étudiant");
        this.delEtu = new JLabel("Supprimer un étudiant");
        this.numAdd = new JLabel("Numéro");
        this.numDel = new JLabel("Numéro");
        this.prenom = new JLabel("Prénom");
        this.nom = new JLabel("Nom");
        this.bac = new JLabel("Bac");
        this.dpt = new JLabel("Dpt");

        this.numAddEdit = new JTextField("");
        this.numDelEdit = new JTextField("");
        this.prenomEdit = new JTextField("");
        this.nomEdit = new JTextField("");

        this.bacCombo = new JComboBox(new String[]{"S", "ES", "STI", "Autre", "Etranger"});

        ArrayList<String> tmp = new ArrayList<>();
        for (int i = 1; i <= 95; i++) tmp.add(Integer.toString(i));
        this.dptCombo = new JComboBox(tmp.toArray());

        this.addBtn = new JButton("Ajouter");
        this.delBtn = new JButton("Supprimer");

        this.pano.add(this.addEtu, cont);
        this.pano.add(this.delEtu, cont);
        this.pano.add(this.numAdd, cont);
        this.pano.add(this.numDel, cont);
        this.pano.add(this.prenom, cont);
        this.pano.add(this.nom, cont);
        this.pano.add(this.bac, cont);
        this.pano.add(this.dpt, cont);

        this.pano.add(this.numAddEdit, cont);
        this.pano.add(this.numDelEdit, cont);
        this.pano.add(this.prenomEdit, cont);
        this.pano.add(this.nomEdit, cont);

        this.pano.add(this.bacCombo, cont);
        this.pano.add(this.dptCombo, cont);

        this.pano.add(this.addBtn, cont);
        this.pano.add(this.delBtn, cont);

        this.setContentPane(this.pano);
        this.setVisible(true);
        this.pack();
    }
}
