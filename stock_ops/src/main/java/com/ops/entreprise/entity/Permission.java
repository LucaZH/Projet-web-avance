package com.ops.entreprise.entity;

public class Permission {
    private int id_permission;
    private String nom_permission;

    public Permission () {

    }

    public Permission(String nom_permission) {
        this.nom_permission = nom_permission;
    }

    public Permission(int id_permission, String nom_permission) {
        this.id_permission = id_permission ;
        this.nom_permission =  nom_permission ;
    }

    public int getId_permission() {
        return id_permission;
    }

    public void setId_permission(int id_permission) {
        this.id_permission = id_permission;
    }

    public String getNom_permission() {
        return nom_permission;
    }

    public void setNom_permission(String nom_permission) {
        this.nom_permission = nom_permission;
    }

    @Override
    public  String toString() {
        return "Permission {" +
                "id_permission = " + id_permission +
                ", nom_permission = '" + nom_permission + '\'' +
                '}';
    }
}


