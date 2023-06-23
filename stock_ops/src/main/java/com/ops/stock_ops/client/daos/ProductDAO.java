package com.ops.stock_ops.client.daos;

import com.ops.stock_ops.client.entities.Product;
import com.ops.stock_ops.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends Dao<Product> {
    public ProductDAO(Connection connection) {super(connection);}

    @Override
    public boolean create(Product obj) {
        String sql = "insert into product (nom_du_produit, prix, description, stock) values (?, ?, ?, ?)" ;
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, obj.getNom_du_produit());
            prepare.setFloat(2, obj.getPrix());
            prepare.setString(3, obj.getDescription());
            prepare.setInt(4, obj.getStock());
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
        String sql = "delete from product where id_product=?";
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
    public boolean update(Product obj) {
        String sql = "update product" + "set" +
                     "nom_du_produit=?, prix=?, description=?, stock=? where id_product=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, obj.getNom_du_produit());
            prepare.setFloat(2, obj.getPrix());
            prepare.setString(3, obj.getDescription());
            prepare.setInt(4, obj.getStock());
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
    public Product get(int id_product) {
        String sql = "select * from product where id_product=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql) ;
            prepare.setInt(1, id_product);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                prepare.close();
                return (new Product(
                        id_product,
                        result.getString("nom_du_produit"),
                        result.getFloat("prix"),
                        result.getString("description"),
                        result.getInt("stock")
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
    public List<Product> get_all() {
        String sql = "select * from product" ;
        List<Product> list_product = new ArrayList<Product>();
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                list_product.add(new Product(
                        result.getInt("id_product"),
                        result.getString("nom_du_produit"),
                        result.getFloat("prix"),
                        result.getString("description"),
                        result.getInt("stock")
                ));
            }
            return list_product;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
