package com.ops.stock_ops.client.daos;

import com.ops.stock_ops.client.entities.Vente_produit;
import com.ops.stock_ops.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Vente_produitDAO extends Dao<Vente_produit> {
    public Vente_produitDAO(Connection connection) {super(connection);}

    @Override
    public boolean create(Vente_produit obj) {
        String sql = "insert into vente_produit (date_d_achat, quantite, id_user, id_product) values (?, ?, ?, ?)" ;
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setDate(1, (Date) obj.getDate_d_achat());
            prepare.setInt(2, obj.getQuantite());
            prepare.setInt(3, obj.getId_user());
            prepare.setInt(4, obj.getId_product());
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id_product) {
        String sql = "delete from vente_produit where id_product=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setInt(1, id_product);
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Vente_produit obj) {
        String sql = "update vente_produit" + "set" +
                "date_d_achat=?, quantite=?, id_user=? where id_product=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setDate(1, obj.getDate_d_achat());
            prepare.setInt(2, obj.getQuantite());
            prepare.setInt(4, obj.getId_user());
            prepare.setInt(5, obj.getId_product());
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Vente_produit get(int id_product) {
        String sql = "select * from vente_produit where id_product=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql) ;
            prepare.setInt(1, id_product);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                prepare.close();
                return (new Vente_produit(
                        id_product,
                        result.getDate("date_d_achat"),
                        result.getInt("quantite"),
                        result.getInt("id_user")
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
    public List<Vente_produit> get_all() {
        String sql = "select * from vente_produit" ;
        List<Vente_produit> list_vente_produit = new ArrayList<Vente_produit>();
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                list_vente_produit.add(new Vente_produit(
                        result.getInt("id_product"),
                        result.getDate("date_d_achat"),
                        result.getInt("quantite"),
                        result.getInt("id_user")
                ));
            }
            return list_vente_produit;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
