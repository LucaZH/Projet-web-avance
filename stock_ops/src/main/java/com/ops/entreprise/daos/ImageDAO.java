package com.ops.entreprise.daos;

import com.ops.entreprise.entity.Image;
import com.ops.stock_ops.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDAO extends Dao<Image> {
    public ImageDAO(Connection connection) {super(connection);}

    public boolean create(Image obj) {
        String sql = "insert into image(nom_image) values(?)";
                try {
                    PreparedStatement prepare = this.connection.prepareStatement(sql);
                    prepare.setInt(1, obj.getId_product());
                    prepare.setString(2, obj.getNom_image());
                    prepare.executeUpdate();
                    prepare.close();
                    return true;
                } catch (SQLException exception) {
                    exception.printStackTrace();
                    return false;
                }
    }

    @Override
    public boolean delete(int id_image) {
        String sql = "delete from image where id=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql) ;
            prepare.setInt(1, id_image);
            prepare.executeUpdate() ;
            prepare.close();
            return true ;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Image obj) {
        String sql = "update image set nom_image=? where id_image=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql) ;
            prepare.setString(1, obj.getNom_image());
            prepare.setInt(2, obj.getId_image());
            prepare.executeUpdate() ;
            prepare.close();
            return true ;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Image get(int id_image) {
        String sql = "select * from image where id_image=?";
        Image image = new Image();
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql) ;
            prepare.setInt(1, id_image);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                prepare.close();
                return (new Image(
                        id_image,
                        result.getInt("id_product"),
                        result.getString("nom_image")
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
    public List<Image> get_all() {
        String sql = "select * from image" ;
        List<Image> list_image = new ArrayList<Image>();
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                list_image.add(new Image(
                        result.getInt("id_image"),
                        result.getString("nom_image")
                ));
            }
            return list_image;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
