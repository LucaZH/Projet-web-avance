package com.ops.stock_ops;

import java.sql.Connection;
import java.util.List;

public abstract class Dao<T> {
    protected Connection connection = null;
    public Dao(Connection connection) {
        this.connection = connection;
    }
    public abstract boolean create(T obj);
    public abstract boolean delete(int id);
    public abstract boolean update(T obj);
    public abstract T get(int id);
    public abstract List<T> get_all();
}

