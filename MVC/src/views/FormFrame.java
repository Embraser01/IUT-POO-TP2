package views;

import controllers.AddController;
import controllers.DelFromForm;
import models.Etudiant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public class FormFrame extends JInternalFrame implements ActionListener{

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

    private AddController addController;
    private DelFromForm delFromForm;

    public FormFrame(AddController addController, DelFromForm delFromForm) {

        this.pano = new JPanel();
        this.pano.setLayout(new GridBagLayout());
        this.cont = new GridBagConstraints();

        this.addController = addController;
        this.delFromForm = delFromForm;

        this.addEtu = new JLabel("Ajouter un étudiant");
        this.delEtu = new JLabel("Supprimer un étudiant");
        this.numAdd = new JLabel("Numéro : ");
        this.numDel = new JLabel("Numéro : ");
        this.prenom = new JLabel("Prénom : ");
        this.nom = new JLabel("Nom : ");
        this.bac = new JLabel("Bac : ");
        this.dpt = new JLabel("Dpt : ");

        this.numAddEdit = new JTextField(10);
        this.numDelEdit = new JTextField(10);
        this.prenomEdit = new JTextField(10);
        this.nomEdit = new JTextField(10);

        this.bacCombo = new JComboBox(new String[]{"S", "ES", "STI", "Autre", "Etranger"});

        ArrayList<String> tmp = new ArrayList<>();
        for (int i = 1; i <= 95; i++) tmp.add(Integer.toString(i));
        this.dptCombo = new JComboBox(tmp.toArray());

        this.addBtn = new JButton("Ajouter");
        this.delBtn = new JButton("Supprimer");

        cont.gridy = 0;
        cont.gridx = 0;
        cont.gridwidth = 2;
        this.pano.add(this.addEtu, cont);

        cont.gridy = 3;
        this.pano.add(this.delEtu, cont);

        cont.gridwidth = 1;
        cont.gridy = 1;
        this.pano.add(this.numAdd, cont);

        cont.gridy = 4;
        this.pano.add(this.numDel, cont);

        cont.gridy = 1;
        cont.gridx = 2;
        this.pano.add(this.prenom, cont);

        cont.gridx = 4;
        this.pano.add(this.nom, cont);

        cont.gridx = 6;
        this.pano.add(this.bac, cont);

        cont.gridx = 8;
        this.pano.add(this.dpt, cont);

        cont.gridx = 1;
        this.pano.add(this.numAddEdit, cont);

        cont.gridy = 4;
        this.pano.add(this.numDelEdit, cont);

        cont.gridy = 1;
        cont.gridx = 3;
        this.pano.add(this.prenomEdit, cont);

        cont.gridx = 5;
        this.pano.add(this.nomEdit, cont);

        cont.gridx = 7;
        this.pano.add(this.bacCombo, cont);

        cont.gridx = 9;
        this.pano.add(this.dptCombo, cont);

        cont.gridx = 10;
        cont.gridy = 2;
        this.pano.add(this.addBtn, cont);

        cont.gridy = 5;
        this.pano.add(this.delBtn, cont);

        this.addBtn.addActionListener(this);
        this.delBtn.addActionListener(this);

        this.setContentPane(this.pano);
        this.setVisible(true);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.addBtn){
            this.addController.addEtu(numAddEdit.getText(),
                    nomEdit.getText(),
                    prenomEdit.getText(),
                    (String) bacCombo.getSelectedItem(),
                    (String) dptCombo.getSelectedItem());
        } else if (e.getSource() == this.delBtn){
            this.delFromForm.delEtu(numDelEdit.getText());
        }
    }
}
