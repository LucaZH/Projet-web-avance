package com.ops.stock_ops.ops.daos;

import com.ops.stock_ops.Dao;
import com.ops.stock_ops.ops.entities.Entreprise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntrepriseDao extends Dao<Entreprise> {
    public EntrepriseDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Entreprise obj) {
        String sql = "insert into " +
                "entreprise(nom_entreprise, mot_de_passe, nif, stat, email, logo, phone, localisation, proprio, id_offre)" +
                " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, obj.getNom_entreprise());
            prepare.setString(2, obj.getMot_de_passe());
            prepare.setString(3, obj.getNif());
            prepare.setString(4, obj.getStat());
            prepare.setString(5, obj.getEmail());
            prepare.setString(6, obj.getLogo());
            prepare.setString(7, obj.getPhone());
            prepare.setString(8, obj.getLocalisation());
            prepare.setString(9, obj.getProprio());
            prepare.setInt(10, obj.getId_offre());
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from entreprise where id=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setInt(1, id);
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Entreprise obj) {
        String sql = "update entreprise " + "set " +
                "nom_entreprise=?, mot_de_passe=?, nif=?, stat=?, email=?, logo=?, phone=?, localisation=?, proprio=?," +
                " id_offre=? where id_entreprise=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, obj.getNom_entreprise());
            prepare.setString(2, obj.getMot_de_passe());
            prepare.setString(3, obj.getNif());
            prepare.setString(4, obj.getStat());
            prepare.setString(5, obj.getEmail());
            prepare.setString(6, obj.getLogo());
            prepare.setString(7, obj.getPhone());
            prepare.setString(8, obj.getLocalisation());
            prepare.setString(9, obj.getProprio());
            prepare.setInt(10, obj.getId_offre());
            prepare.setInt(11, obj.getId_entreprise());
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Entreprise get(int id) {
        String sql = "select * from entreprise where id=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setInt(1, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                prepare.close();
                return (new Entreprise(
                        id,
                        result.getString("nom_entreprise"),
                        result.getString("mot_de_passe"),
                        result.getString("nif"),
                        result.getString("stat"),
                        result.getString("email"),
                        result.getString("logo"),
                        result.getString("phone"),
                        result.getString("localisation"),
                        result.getString("proprio"),
                        result.getInt("id_offre")
                ));
            } else {
                return null;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public Entreprise get(String email) {
        String sql = "select * from entreprise where email=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, email);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                prepare.close();
                return (new Entreprise(
                        result.getInt("id_entreprise"),
                        result.getString("nom_entreprise"),
                        result.getString("mot_de_passe"),
                        result.getString("nif"),
                        result.getString("stat"),
                        result.getString("email"),
                        result.getString("logo"),
                        result.getString("phone"),
                        result.getString("localisation"),
                        result.getString("proprio"),
                        result.getInt("id_offre")
                ));
            } else {
                return null;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Entreprise> get_all() {
        String sql = "select * from entreprise";
        List<Entreprise> list_entreprise = new ArrayList<Entreprise>();
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                list_entreprise.add(new Entreprise(
                        result.getInt("id_entreprise"),
                        result.getString("nom_entreprise"),
                        result.getString("mot_de_passe"),
                        result.getString("nif"),
                        result.getString("stat"),
                        result.getString("email"),
                        result.getString("logo"),
                        result.getString("phone"),
                        result.getString("localisation"),
                        result.getString("proprio"),
                        result.getInt("id_offre")
                ));
            }
            prepare.close();
            return list_entreprise;
        } catch (SQLException exception) {
            return list_entreprise;
        }
    }
}
