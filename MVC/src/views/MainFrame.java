package views;

import views.bac.BacFrame;
import views.dpt.DptFrame;
import views.form.FormFrame;
import views.list.ListFrame;

import javax.swing.*;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public class MainFrame extends JFrame {

    private BacFrame view_bac;
    private DptFrame view_dpt;
    private FormFrame view_form;
    private ListFrame view_list;

    public MainFrame () {

        this.setTitle("TP2 MVC - POO | Fernandes Marc-Antoine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
    }
}
