package org.iut.montreuil.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private String url = "jdbc:postgresql://localhost:5432/masterAnnonce";
    private String user = "postgres";
    private String password = "4590";

    private static Connection instance;

    private ConnectionDB() throws ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            instance = DriverManager.getConnection(url,user, password);
        } catch (SQLException e) {
            e.printStackTrace();;
        }
    }

    public static Connection getInstance() throws ClassNotFoundException {
        if (instance == null) {
            new ConnectionDB();
        }
        return instance;
    }


}
