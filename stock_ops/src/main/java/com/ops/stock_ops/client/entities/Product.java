package com.ops.stock_ops.client.entities;

public class Product {
    private int id_product;
    private String nom_du_produit;
    private Float prix;
    private String description;
    private int stock;

    public Product(int id_product, String nom_du_produit) {

    }

    public Product(String nom_du_produit, Float prix, String description, int stock) {
        this.nom_du_produit = nom_du_produit;
        this.prix = prix;
        this.description = description;
        this.stock = stock;
    }

    public Product(int id_product, String nom_du_produit, Float prix, String description, int stock) {
        this.id_product = id_product;
        this.nom_du_produit = nom_du_produit;
        this.prix = prix;
        this.description = description;
        this.stock = stock;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getNom_du_produit() {
        return nom_du_produit;
    }

    public void setNom_du_produit(String nom_du_produit) {
        this.nom_du_produit = nom_du_produit;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_product=" + id_product +
                ", nom_du_produit='" + nom_du_produit + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                '}';
    }
}
