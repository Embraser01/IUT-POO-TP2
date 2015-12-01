package models;

/**
 *
 */
public class Etudiant {

    private String id;
    private String nom;
    private String prenom;
    private String serieBac;
    private String dpt;

    public Etudiant(String id, String nom, String prenom, String serieBac, String dpt) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.serieBac = serieBac;
        this.dpt = dpt;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSerieBac() {
        return serieBac;
    }

    public void setSerieBac(String serieBac) {
        this.serieBac = serieBac;
    }
}