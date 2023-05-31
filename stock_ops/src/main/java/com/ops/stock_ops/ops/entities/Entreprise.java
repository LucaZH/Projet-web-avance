package com.ops.stock_ops.ops.entities;

public class Entreprise {
    private int id;
    private String nom_entreprise;
    private String mot_de_passe;
    private String nif_stat;
    private String mail;
    private String logo;
    private String phone;
    private String localisation;
    private String proprio;
    private int id_offre;

    public Entreprise(String nom_entreprise, String mot_de_passe, String nif_stat, String mail, String logo, String phone, String localisation, String proprio, int id_offre) {
        this.nom_entreprise = nom_entreprise;
        this.mot_de_passe = mot_de_passe;
        this.nif_stat = nif_stat;
        this.mail = mail;
        this.logo = logo;
        this.phone = phone;
        this.localisation = localisation;
        this.proprio = proprio;
        this.id_offre = id_offre;
    }

    public Entreprise(int id, String nom_entreprise, String mot_de_passe, String nif_stat, String mail, String logo, String phone, String localisation, String proprio, int id_offre) {
        this.id = id;
        this.nom_entreprise = nom_entreprise;
        this.mot_de_passe = mot_de_passe;
        this.nif_stat = nif_stat;
        this.mail = mail;
        this.logo = logo;
        this.phone = phone;
        this.localisation = localisation;
        this.proprio = proprio;
        this.id_offre = id_offre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNif_stat() {
        return nif_stat;
    }

    public void setNif_stat(String nif_stat) {
        this.nif_stat = nif_stat;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    @Override
    public String toString() {
        return "Entreprise{" +
                "id=" + id +
                ", nom_entreprise='" + nom_entreprise + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                ", nif_stat='" + nif_stat + '\'' +
                ", mail='" + mail + '\'' +
                ", logo='" + logo + '\'' +
                ", phone='" + phone + '\'' +
                ", localisation='" + localisation + '\'' +
                ", proprio='" + proprio + '\'' +
                ", id_offre=" + id_offre +
                '}';
    }
}
