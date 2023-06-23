package com.ops.stock_ops.ops.entities;

public class Entreprise {
    private int id_entreprise;
    private String nom_entreprise;
    private String mot_de_passe;
    private String nif;
    private String stat;
    private String email;
    private String logo;
    private String phone;
    private String localisation;
    private String proprio;
    private int id_offre;

    public Entreprise(String nom_entreprise, String mot_de_passe, String nif, String stat, String email, String logo, String phone, String localisation, String proprio, int id_offre) {
        this.nom_entreprise = nom_entreprise;
        this.mot_de_passe = mot_de_passe;
        this.nif = nif;
        this.stat = stat;
        this.email = email;
        this.logo = logo;
        this.phone = phone;
        this.localisation = localisation;
        this.proprio = proprio;
        this.id_offre = id_offre;
    }

    public Entreprise(int id_entreprise, String nom_entreprise, String mot_de_passe, String nif, String stat, String email, String logo, String phone, String localisation, String proprio, int id_offre) {
        this.id_entreprise = id_entreprise;
        this.nom_entreprise = nom_entreprise;
        this.mot_de_passe = mot_de_passe;
        this.nif = nif;
        this.stat = stat;
        this.email = email;
        this.logo = logo;
        this.phone = phone;
        this.localisation = localisation;
        this.proprio = proprio;
        this.id_offre = id_offre;
    }

    public int getId_entreprise() {
        return id_entreprise;
    }

    public void setId_entreprise(int id_entreprise) {
        this.id_entreprise = id_entreprise;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getProprio() {
        return proprio;
    }

    public void setProprio(String proprio) {
        this.proprio = proprio;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }
}
