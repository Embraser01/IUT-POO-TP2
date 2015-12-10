package views;

import controllers.AddController;
import controllers.DelFromForm;
import controllers.DelFromListe;
import models.Promotion;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public class MainFrame extends JFrame {

    private Promotion promotion;

    private BacFrame view_bac;
    private DptFrame view_dpt;
    private FormFrame view_form;
    private ListFrame view_list;

    private GridBagConstraints cont;


    public MainFrame () {

        this.promotion = new Promotion();

        this.promotion.loadFileCSV();

        this.setTitle("TP2 MVC - POO | Fernandes Marc-Antoine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.cont = new GridBagConstraints();

        this.view_list = new ListFrame(promotion.getListeEtudiants(), new DelFromListe(promotion));
        this.view_dpt = new DptFrame(promotion.getListeEtudiants());
        this.view_bac = new BacFrame(promotion.getListeEtudiants());
        this.view_form = new FormFrame(new AddController(promotion), new DelFromForm(promotion));

        promotion.addObservateur(this.view_list);
        this.view_dpt.setObservable(promotion);
        this.view_bac.setObservable(promotion);

        cont.gridx = 2;
        cont.gridy = 0;
        cont.gridheight = 2;
        this.add(this.view_list, cont);

        cont.gridheight = 1;
        cont.gridx = 1;
        cont.gridy = 1;
        this.add(this.view_dpt, cont);

        cont.gridx = 0;
        this.add(this.view_bac, cont);

        cont.gridy = 0;
        this.add(this.view_form, cont);
        this.pack();
    }
}
