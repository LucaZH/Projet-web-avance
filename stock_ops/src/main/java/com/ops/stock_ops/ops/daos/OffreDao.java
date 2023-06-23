package com.ops.stock_ops.ops.daos;

import com.ops.stock_ops.Dao;
import com.ops.stock_ops.ops.entities.Offre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OffreDao extends Dao<Offre> {
    public OffreDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Offre obj) {
        String sql = "insert into offre(nom, espace_stockage, prix, frequence_sauvegard, id_admin) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, obj.getNom());
            prepare.setFloat(2, obj.getEspace_stockage());
            prepare.setFloat(3, obj.getPrix());
            prepare.setInt(4, obj.getFrequence_sauvegard());
            prepare.setInt(5, obj.getId_admin());
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
        String sql = "delete from offre where id=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setInt(1, id);
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException exception) {
            return false;
        }
    }

    @Override
    public boolean update(Offre obj) {
        String sql = "update set offre nom=?, espace_stockage=?, prix=?, frequence_sauvegard=? where id=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, obj.getNom());
            prepare.setFloat(2, obj.getEspace_stockage());
            prepare.setFloat(3, obj.getPrix());
            prepare.setInt(4, obj.getFrequence_sauvegard());
            prepare.setInt(5, obj.getId());
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException exception) {
            return false;
        }
    }

    @Override
    public Offre get(int id) {
        String sql = "select * from offre where  id=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setInt(1, id);
            ResultSet result = prepare.executeQuery();
            prepare.close();
            if (result.next()) {
                return new Offre(
                        result.getInt("id"),
                        result.getString("nom"),
                        result.getFloat("espace_stockage"),
                        result.getFloat("prix"),
                        result.getInt("frequence_sauvegard"),
                        result.getInt("id_admin")
                );
            } else {
                return null;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Offre> get_all() {
        String sql = "select * from offre";
        List<Offre> list_offre = new ArrayList<Offre>();
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                list_offre.add(new Offre(
                        result.getInt("id_offre"),
                        result.getString("nom"),
                        result.getFloat("espace_stockage"),
                        result.getFloat("prix"),
                        result.getInt("frequence_sauvegard"),
                        result.getInt("id_admin")
                ));
            }
            prepare.close();
            return list_offre;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return list_offre;
        }
    }
}
