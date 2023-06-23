package com.ops.stock_ops.client.entities;

import java.util.Date;

public class Vente_produit {
    private Date date_d_achat;
    private int quantite;
    private int id_user;
    private int id_product;

    public Vente_produit(int id_product, java.sql.Date date_d_achat, int quantite, int id_user) {

    }

    public Vente_produit(Date date_d_achat, int quantite, int id_user, int id_product) {
        this.date_d_achat = date_d_achat;
        this.quantite = quantite;
        this.id_user = id_user;
        this.id_product = id_product;
    }

    public java.sql.Date getDate_d_achat() {
        return (java.sql.Date) date_d_achat;
    }

    public void setDate_d_achat(Date date_d_achat) {
        this.date_d_achat = date_d_achat;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    @Override
    public String toString() {
        return "Vente_produit{" +
                "date_d_achat=" + date_d_achat +
                ", quantite=" + quantite +
                ", id_user=" + id_user +
                ", id_product=" + id_product +
                '}';
    }
}
