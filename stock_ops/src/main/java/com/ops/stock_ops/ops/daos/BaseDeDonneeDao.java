package com.ops.stock_ops.ops.daos;

import com.ops.stock_ops.Dao;
import com.ops.stock_ops.ops.entities.BaseDeDonnee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDonneeDao extends Dao<BaseDeDonnee> {
    public BaseDeDonneeDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(BaseDeDonnee obj) {
        String sql = "insert into base_de_donne (lien, id_entreprise) values (?, ?)";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, obj.getLien());
            prepare.setInt(2, obj.getId_entreprise());
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException exception) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from base_de_donne where id=?";
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
    public boolean update(BaseDeDonnee obj) {
        String sql = "update base_de_donne set lien=?, id_entreprise: ? where id=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, obj.getLien());
            prepare.setInt(2, obj.getId_entreprise());
            prepare.setInt(3, obj.getId());
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException exception) {
            return false;
        }
    }

    @Override
    public BaseDeDonnee get(int id) {
        String sql = "select * from base_de_donne where id=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setInt(1, id);
            ResultSet result = prepare.executeQuery();
            prepare.close();
            if (result.next()) {
                return new BaseDeDonnee(
                        result.getInt("id"),
                        result.getString("lien"),
                        result.getInt("id_entreprise")
                );
            } else {
                return null;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }
    public BaseDeDonnee get_by_entreprise(int id_entreprise) {
        String sql = "select * from base_de_donne where id_entreprise=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setInt(1, id_entreprise);
            ResultSet result = prepare.executeQuery();
            prepare.close();
            if (result.next()) {
                return new BaseDeDonnee(
                        result.getInt("id"),
                        result.getString("lien"),
                        result.getInt("id_entreprise")
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
    public List<BaseDeDonnee> get_all() {
        String sql = "select * from base_de_donne";
        List<BaseDeDonnee> list_base_de_donne = new ArrayList<BaseDeDonnee>();
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            prepare.close();
            while (result.next()) {
                list_base_de_donne.add(new BaseDeDonnee(
                        result.getInt("id"),
                        result.getString("lien"),
                        result.getInt("id_entreprise")
                ));
            }
            return list_base_de_donne;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
