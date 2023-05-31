package com.ops.stock_ops.ops.daos;

import com.ops.stock_ops.Dao;
import com.ops.stock_ops.ops.entities.Offre;

import java.sql.Connection;
import java.util.List;

public class OffreDao extends Dao<Offre> {
    public OffreDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Offre obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Offre obj) {
        return false;
    }

    @Override
    public Offre get(int id) {
        return null;
    }

    @Override
    public List<Offre> get_all() {
        return null;
    }
}
