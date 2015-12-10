package models;

import views.Observateur;


public interface Observable {
    /**
     * Ajoute un observateur à l'objet
     * @param observateur Objet observateur
     */
    void addObservateur(Observateur observateur);

    /**
     * Enlève un observateur à l'objet
     * @param observateur Objet observateur
     * @return Boolean si oui ou non il a été enlevé
     */
    boolean removeObservateur(Observateur observateur);

    /**
     * Notifie l'ensemble des observateurs
     * @see Observateur#onUpdate()
     */
    void notifyObservateurs();
}
