package controllers;

import models.Etudiant;
import models.Promotion;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public class DelFromListe extends AbstractController{

    public DelFromListe(Promotion promotion) {
        super(promotion);
    }

    public void delEtu(Etudiant etudiant) {
        if (etudiant == null) return;

        promotion.removeEtudiant(etudiant);
    }
}
