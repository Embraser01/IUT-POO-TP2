package models;

/**
 *
 */
public class Etudiant {

    /**
     * Numero de l' étudiant
     */
    private String id;

    /**
     * Nom de l'étudiant
     */
    private String nom;

    /**
     * Prenom de l'étudiant
     */
    private String prenom;

    /**
     * De quel BAC vient l'étudiant
     */
    private String serieBac;

    /**
     * De quel Département vient l'étudiant
     */
    private String dpt;


    /**
     * Constructeur unique d'un étudiant
     * @param id Numéro étudiant
     * @param nom Nom de l'étudiant
     * @param prenom Prénom de l'étudiant
     * @param serieBac BAC de l'étudiant
     * @param dpt Département d'où vient l'étudiant
     */
    public Etudiant(String id, String nom, String prenom, String serieBac, String dpt) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.serieBac = serieBac;
        this.dpt = dpt;
    }

    /**
     * Renvoie le département
     * @return Numéro de département
     */
    public String getDpt() {
        return dpt;
    }

    /**
     * Change le département
     * @param dpt Numéro de département
     */
    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    /**
     * Renvoie le numéro étudiant
     * @return Numéro étudiant
     */
    public String getId() {
        return id;
    }

    /**
     * Change le numéro étudiant
     * @param id Numéro étudiant
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Renvoie le nom de l'étudiant
     * @return Nom de l'étudiant
     */
    public String getNom() {
        return nom;
    }

    /**
     * Change le nom de l'étudiant
     * @param nom Nom de l'étudiant
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Renvoie le prénom de l'étudiant
     * @return Prénom de l'étudiant
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Change le prénom de l'étudiant
     * @param prenom Prénom de l'étudiant
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Renvoie le BAC d'où vient l'étudiant
     * @return Type de BAC
     */
    public String getSerieBac() {
        return serieBac;
    }

    /**
     * Change le BAC de l'étudiant
     * @param serieBac Nom du BAC
     */
    public void setSerieBac(String serieBac) {
        this.serieBac = serieBac;
    }
}