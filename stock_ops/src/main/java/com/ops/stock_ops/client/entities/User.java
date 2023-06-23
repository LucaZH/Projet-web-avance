package com.ops.stock_ops.client.entities;

public class User {
    private int id_user;
    private String username;
    private String mot_de_passe;
    private String email;
    private String contact;
    private String image;

    public User(String username, String mot_de_passe, String email, String contact, String image) {
        this.username = username;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
        this.contact = contact;
        this.image = image;
    }

    public User(int id_user, String username, String mot_de_passe, String email, String contact, String image) {
        this.id_user = id_user;
        this.username = username;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
        this.contact = contact;
        this.image = image;
    }

    public User(String username, String mot_de_passe, String email, String contact) {
        this.username = username;
        this.mot_de_passe = mot_de_passe;
        this.email = email;
        this.contact = contact;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", username='" + username + '\'' +
                ", mot_de_passe='" + mot_de_passe + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
