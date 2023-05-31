package com.ops.stock_ops.ops.daos;

import com.ops.stock_ops.Dao;
import com.ops.stock_ops.ops.entities.BaseDeDonnee;

import java.sql.Connection;
import java.util.List;

public class BaseDeDonneeDao extends Dao<BaseDeDonnee> {
    public BaseDeDonneeDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(BaseDeDonnee obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(BaseDeDonnee obj) {
        return false;
    }

    @Override
    public BaseDeDonnee get(int id) {
        return null;
    }

    @Override
    public List<BaseDeDonnee> get_all() {
        return null;
    }
}
