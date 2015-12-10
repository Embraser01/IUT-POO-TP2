package controllers;

import models.Etudiant;
import models.Promotion;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public class DelFromForm extends AbstractController{

    public DelFromForm(Promotion promotion) {
        super(promotion);
    }

    public void delEtu(String numero) {
        if (!control(numero)) return;

        Etudiant etu = promotion.searchEtudiant(numero);
        if(etu != null) promotion.removeEtudiant(etu);
    }

    private boolean control(String numero) {
        try {
            Integer.parseInt(numero);

        } catch (Exception ex) {
            System.out.println("Bad format informations");
            return false;
        }
        return true;
    }
}
