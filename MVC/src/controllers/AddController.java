package controllers;

import models.Etudiant;
import models.Promotion;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public class AddController extends AbstractController {

    public AddController(Promotion promotion) {
        super(promotion);
    }

    public void addEtu(String numero, String nom, String prenom, String bac, String dpt) {
        if (!control(numero, nom, prenom, bac, dpt)) return;

        promotion.addEtudiant(new Etudiant(numero, nom, prenom, bac, dpt));
    }

    private boolean control(String numero, String nom, String prenom, String bac, String dpt) {
        try {
            Integer.parseInt(numero);
            Integer.parseInt(dpt);

            if (nom == null) return false;
            if (prenom == null) return false;

        } catch (Exception ex) {
            System.out.println("Bad format informations");
            return false;
        }
        return true;
    }
}
