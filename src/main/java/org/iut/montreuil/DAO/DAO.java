package org.iut.montreuil.DAO;

import org.iut.montreuil.connection.ConnectionDB;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class DAO<T> {
    protected Connection con;

    public DAO(Connection con) {
        this.con = con;
    }

    public abstract Boolean create(T object);

    public abstract Boolean update(T object);

    public abstract Boolean delete(int id);

    public abstract T find(int id);

    public abstract ArrayList<T> findAll();
}
