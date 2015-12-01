package views;

import models.Etudiant;
import models.Promotion;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public class ListFrame extends JInternalFrame {

    private JList list;
    private DefaultListModel listModel;
    private JScrollPane listScroll;

    private ArrayList<Etudiant> dataList;

    public ListFrame(ArrayList<Etudiant> dataList) {
        super("Liste des étudiants");

        this.dataList = dataList;

        this.listModel = new DefaultListModel();
        for (Etudiant aDataList : this.dataList) {
            this.listModel.addElement(aDataList.getId()
                    + " - "
                    + aDataList.getPrenom()
                    + " "
                    + aDataList.getNom()
                    + " - "
                    + aDataList.getSerieBac()
                    + " - "
                    + aDataList.getDpt());
        }

        this.list = new JList(this.listModel);
        this.listScroll = new JScrollPane(this.list);

        this.add(this.listScroll);
        this.setVisible(true);
        this.pack();
    }
}
