package com.ops.stock_ops.ops.daos;

import com.ops.stock_ops.Dao;
import com.ops.stock_ops.ops.entities.Entreprise;

import java.sql.Connection;
import java.util.List;

public class EntrepriseDao extends Dao<Entreprise> {
    public EntrepriseDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Entreprise obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Entreprise obj) {
        return false;
    }

    @Override
    public Entreprise get(int id) {
        return null;
    }

    @Override
    public List<Entreprise> get_all() {
        return null;
    }
}
