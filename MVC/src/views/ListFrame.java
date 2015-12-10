package views;

import controllers.DelFromListe;
import models.Etudiant;
import models.Promotion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public class ListFrame extends JInternalFrame implements Observateur, ActionListener {

    private final static int SORT_NUM = 0;
    private final static int SORT_NUM_DESC = 1;
    private final static int SORT_NAME = 2;
    private final static int SORT_NAME_DESC = 3;

    private int order;

    private JList list;
    private JScrollPane listScroll;

    private JButton delBtn;
    private JComboBox sortCombo;
    private GridBagConstraints cont;

    private ArrayList<Etudiant> dataList;

    private DelFromListe delFromListe;

    public ListFrame(ArrayList<Etudiant> dataList, DelFromListe delFromListe) {
        super("Liste des étudiants");

        this.dataList = dataList;
        this.delFromListe = delFromListe;
        this.order = 0;

        this.cont = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        this.list = new JList(this.getNewListModel());
        this.listScroll = new JScrollPane(this.list);
        this.listScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.delBtn = new JButton("Supprimer");

        this.sortCombo = new JComboBox(new String[]{"Numero croissant", "Numero décroissant", "Nom croissant", "Nom décroissant"});

        this.delBtn.addActionListener(this);
        this.sortCombo.addActionListener(this);

        cont.gridy = 1;
        cont.gridx = 0;
        this.add(this.delBtn, cont);

        cont.gridx = 1;
        this.add(this.sortCombo, cont);

        cont.gridy = 0;
        cont.gridx = 0;
        cont.gridwidth = 2;
        this.add(this.listScroll, cont);

        this.setVisible(true);
        this.pack();
    }

    @Override
    public void onUpdate() {
        this.list.setModel(this.getNewListModel());
    }

    private ListModel getNewListModel() {

        ArrayList<Etudiant> tmp = (ArrayList<Etudiant>) dataList.clone();

        switch (order){
            case SORT_NAME_DESC:
                Collections.sort(tmp,new NameComparator(true));
                break;
            case SORT_NUM:
                Collections.sort(tmp,new NumComparator(false));
                break;
            case SORT_NUM_DESC:
                Collections.sort(tmp,new NumComparator(true));
                break;
            default:
                Collections.sort(tmp,new NameComparator(false));
        }

        DefaultListModel listModel = new DefaultListModel();
        for (Etudiant aDataList : tmp) {
            listModel.addElement(aDataList.getId()
                    + " - "
                    + aDataList.getNom()
                    + " "
                    + aDataList.getPrenom()
                    + " - "
                    + aDataList.getSerieBac()
                    + " - "
                    + aDataList.getDpt());
        }

        return listModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.delBtn) {
            if (this.list.getSelectedIndex() >= 0) {
                this.delFromListe.delEtu(this.dataList.get(this.list.getSelectedIndex()));
                this.list.setSelectedIndex(0);
            }
        }

        else if(e.getSource() == this.sortCombo){
            this.order = this.sortCombo.getSelectedIndex();
            this.list.setModel(this.getNewListModel());
        }
    }


    private class NameComparator implements Comparator<Etudiant> {

        private boolean desc;

        public NameComparator(boolean desc){
            this.desc = desc;
        }

        @Override
        public int compare(Etudiant o1, Etudiant o2) {
            if(desc) return -o1.getNom().compareToIgnoreCase(o2.getNom());

            return o1.getNom().compareToIgnoreCase(o2.getNom());
        }
    }

    private class NumComparator implements Comparator<Etudiant> {

        private boolean desc;

        public NumComparator(boolean desc){
            this.desc = desc;
        }

        @Override
        public int compare(Etudiant o1, Etudiant o2) {
            if(desc) return -o1.getId().compareToIgnoreCase(o2.getId());

            return o1.getId().compareToIgnoreCase(o2.getId());
        }
    }
}
