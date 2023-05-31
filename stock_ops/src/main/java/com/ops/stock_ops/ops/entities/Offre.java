package com.ops.stock_ops.ops.entities;

public class Offre {
    private int id;
    private String nom;
    private String espace_stockage;
    private float prix;
    private int frequence_sauvegard;
    private int id_admin;

    public Offre(String nom, String espace_stockage, float prix, int frequence_sauvegard, int id_admin) {
        this.nom = nom;
        this.espace_stockage = espace_stockage;
        this.prix = prix;
        this.frequence_sauvegard = frequence_sauvegard;
        this.id_admin = id_admin;
    }

    public Offre(int id, String nom, String espace_stockage, float prix, int frequence_sauvegard, int id_admin) {
        this.id = id;
        this.nom = nom;
        this.espace_stockage = espace_stockage;
        this.prix = prix;
        this.frequence_sauvegard = frequence_sauvegard;
        this.id_admin = id_admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspace_stockage() {
        return espace_stockage;
    }

    public void setEspace_stockage(String espace_stockage) {
        this.espace_stockage = espace_stockage;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getFrequence_sauvegard() {
        return frequence_sauvegard;
    }

    public void setFrequence_sauvegard(int frequence_sauvegard) {
        this.frequence_sauvegard = frequence_sauvegard;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", espace_stockage='" + espace_stockage + '\'' +
                ", prix=" + prix +
                ", frequence_sauvegard=" + frequence_sauvegard +
                ", id_admin=" + id_admin +
                '}';
    }
}
