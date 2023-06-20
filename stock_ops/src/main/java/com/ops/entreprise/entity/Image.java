package com.ops.entreprise.entity;

public class Image {
    private int id_image ;
    private String nom_image ;

    public Image () {

    }

    public Image(String nom_image) {
        this.nom_image = nom_image ;
    }

    public Image(int id_image, String nom_image) {
        this.id_image = id_image ;
        this.nom_image = nom_image ;
    }

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public String getNom_image() {
        return nom_image;
    }

    public void setNom_image(String nom_image) {
        this.nom_image = nom_image;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id_image=" + id_image +
                ", nom_image='" + nom_image + '\'' +
                '}';
    }
}
