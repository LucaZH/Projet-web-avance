package com.ops.entreprise.daos;

import com.ops.entreprise.entity.Product;
import com.ops.entreprise.entity.User;
import com.ops.stock_ops.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends Dao<User> {
    public UserDAO(Connection connection) {super(connection);}

    @Override
    public boolean create(User obj) {
        String sql = "insert into user (username, mot_de_passe, email, contact, image) values (?, ?, ?, ?, ?)" ;
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, obj.getUsername());
            prepare.setString(2, obj.getMot_de_passe());
            prepare.setString(3, obj.getEmail());
            prepare.setString(3, obj.getContact());
            prepare.setString(3, obj.getImage());
            prepare.setInt(4, obj.getId_user());
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id_user) {
        String sql = "delete from user where id_user=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql) ;
            prepare.setInt(1, id_user);
            prepare.executeUpdate() ;
            prepare.close();
            return true ;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(User obj) {
        String sql = "update user" + "set" +
                "username=?, mot_de_passe=?, email=?, contact=?, image=? where id_user=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, obj.getUsername());
            prepare.setString(2, obj.getMot_de_passe());
            prepare.setString(3, obj.getEmail());
            prepare.setString(4, obj.getContact());
            prepare.setString(5, obj.getImage());
            prepare.setInt(6, obj.getId_user());
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public User get(int id_user) {
        String sql = "select * from user where id_user=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql) ;
            prepare.setInt(1, id_user);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                prepare.close();
                return (new User(
                        id_user,
                        result.getString("username"),
                        result.getString("mot_de_passe"),
                        result.getString("email"),
                        result.getString("contact"),
                        result.getString("image")
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
    public List<User> get_all() {
        String sql = "select * from user" ;
        List<User> list_user = new ArrayList<User>();
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                list_user.add(new User(
                        result.getInt("id_user"),
                        result.getString("username"),
                        result.getString("mot_de_passe"),
                        result.getString("email"),
                        result.getString("contact"),
                        result.getString("image")
                ));
            }
            return list_user;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
