package com.ops.stock_ops.ops.daos;

import com.ops.stock_ops.Dao;
import com.ops.stock_ops.ops.entities.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminDao extends Dao<Admin> {
    public AdminDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Admin obj) {
        String sql = "insert into Admin(email, mot_de_passe) values(?, ?)";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, obj.getEmail());
            prepare.setString(2, obj.getMot_de_passe());
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
        String sql = "delete from admin where id=?";
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
    public boolean update(Admin obj) {
        String sql = "update set email=?, mot_de_passe=? where id=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, obj.getEmail());
            prepare.setString(2, obj.getMot_de_passe());
            prepare.setInt(3, obj.getId());
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Admin get(int id) {
        String sql = "select * from admin where id=?";
        Admin admin = new Admin();
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setInt(1, id);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                admin = new Admin(result.getInt("id"), result.getString("email"), result.getString("mot_de_passe"));
                prepare.close();
                return admin;
            } else {
                return null;
            }
        } catch (SQLException exception) {
            return null;
        }
    }

    public Admin get(String email) {
        String sql = "select * from admin where email=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, email);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                Admin admin = new Admin(result.getInt("id"), result.getString("email"), result.getString("mot_de_passe"));
                prepare.close();
                return admin;
            } else {
                return null;
            }
        } catch (SQLException exception) {
            return null;
        }
    }

    @Override
    public List<Admin> get_all() {
        return null;
    }
}
