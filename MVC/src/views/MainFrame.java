package views;

import models.Promotion;

import javax.swing.*;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public class MainFrame extends JFrame {

    private Promotion promotion;

    private BacFrame view_bac;
    private DptFrame view_dpt;
    private FormFrame view_form;
    private ListFrame view_list;


    public MainFrame () {

        this.promotion = new Promotion();

        this.promotion.loadFileCSV();

        this.setTitle("TP2 MVC - POO | Fernandes Marc-Antoine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.view_list = new ListFrame(promotion.getListeEtudiants());
        this.view_dpt = new DptFrame(promotion.getListeEtudiants());

        this.add(this.view_list);
        this.add(this.view_dpt);
        this.pack();
    }
}
