package com.ops.entreprise.daos;

import com.ops.entreprise.entity.Permission;
import com.ops.stock_ops.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermissionDAO extends Dao<Permission> {
    public PermissionDAO(Connection connection) {super(connection);}

    @Override
    public boolean create(Permission obj) {
        String sql = "insert into permission (nom_permission) values (?)" ;
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, obj.getNom_permission());
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id_permission) {
        String sql = "delete from permission where id=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql) ;
            prepare.setInt(1, id_permission);
            prepare.executeUpdate() ;
            prepare.close();
            return true ;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Permission obj) {
        String sql = "update permission set nom_permission=? where id_permission=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            prepare.setString(1, obj.getNom_permission());
            prepare.setInt(2, obj.getId_permission());
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Permission get(int id_permission) {
        String sql = "select * from permission where id_permission=?";
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql) ;
            prepare.setInt(1, id_permission);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                prepare.close();
                return (new Permission(
                        id_permission,
                        result.getString("nom_permission")));
            } else {
                return null;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Permission> get_all() {
        String sql = "select * from permission" ;
        List<Permission> list_permission = new ArrayList<Permission>();
        try {
            PreparedStatement prepare = this.connection.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                list_permission.add(new Permission(
                        result.getInt("id_permission"),
                        result.getString("nom_permission")
                ));
            }
            return list_permission;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

}
