package com.ops.stock_ops.ops.entities;

public class BaseDeDonnee {
    private int id;
    private String lien;
    private int id_entreprise;

    public BaseDeDonnee(String lien, int id_entreprise) {
        this.lien = lien;
        this.id_entreprise = id_entreprise;
    }

    public BaseDeDonnee(int id, String lien, int id_entreprise) {
        this.id = id;
        this.lien = lien;
        this.id_entreprise = id_entreprise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public int getId_entreprise() {
        return id_entreprise;
    }

    public void setId_entreprise(int id_entreprise) {
        this.id_entreprise = id_entreprise;
    }

    @Override
    public String toString() {
        return "BaseDeDonnee{" +
                "id=" + id +
                ", lien='" + lien + '\'' +
                ", id_entreprise=" + id_entreprise +
                '}';
    }
}
