package models;

import views.Observateur;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public interface Observable {

    void addObservateur(Observateur observateur);

    boolean removeObservateur(Observateur observateur);

    void notifyObservateurs();
}
