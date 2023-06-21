package com.ops.entreprise.entity;

public class User_permission {
    private int id_user;
    private int id_permission;

    public User_permission () {

    }

    public User_permission (int id_user, int id_permission) {
        this.id_user = id_user ;
        this.id_permission = id_permission ;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_permission() {
        return id_permission;
    }

    public void setId_permission(int id_permission) {
        this.id_permission = id_permission;
    }

    @Override
    public String toString() {
        return "User_permission{" +
                "id_user=" + id_user + '\'' +
                ", id_permission=" + id_permission + '\'' +
                '}';
    }
}
