package controllers;

import models.Promotion;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public abstract class AbstractController {

    protected Promotion promotion;

    public AbstractController(Promotion promotion){
        this.promotion = promotion;
    }
}
