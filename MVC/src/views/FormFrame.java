package views;

import models.Etudiant;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public class FormFrame extends JInternalFrame {

    private ArrayList<Etudiant> dataList;

    public FormFrame(ArrayList<Etudiant> dataList) {

        this.dataList = dataList;
    }
}
