package views;

import controllers.DelFromListe;
import models.Etudiant;
import models.Promotion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public class ListFrame extends JInternalFrame implements Observateur, ActionListener {

    private JList list;
    private JScrollPane listScroll;

    private JButton delBtn;
    private GridBagConstraints cont;

    private ArrayList<Etudiant> dataList;

    private DelFromListe delFromListe;

    public ListFrame(ArrayList<Etudiant> dataList, DelFromListe delFromListe) {
        super("Liste des étudiants");

        this.dataList = dataList;
        this.delFromListe = delFromListe;

        this.cont = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        this.list = new JList(this.getNewListModel());
        this.listScroll = new JScrollPane(this.list);
        this.listScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.delBtn = new JButton("Supprimer");

        this.delBtn.addActionListener(this);

        cont.gridy = 1;
        this.add(this.delBtn, cont);

        cont.gridy = 0;
        this.add(this.listScroll, cont);

        this.setVisible(true);
        this.pack();
    }

    @Override
    public void onUpdate() {
        this.list.setModel(this.getNewListModel());
    }

    private ListModel getNewListModel() {

        DefaultListModel listModel = new DefaultListModel();
        for (Etudiant aDataList : this.dataList) {
            listModel.addElement(aDataList.getId()
                    + " - "
                    + aDataList.getPrenom()
                    + " "
                    + aDataList.getNom()
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
    }
}
