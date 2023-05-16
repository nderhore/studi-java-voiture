package org.example.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {

    private static Connection connection = null;

    private String url = "jdbc:sqlite:database.db";

    private ConnectDB(){
            try {

                // Chargement du pilote JDBC (Java Database Connectivity)
                Class.forName("org.sqlite.JDBC");

                // Connexion à la Database
                connection = DriverManager.getConnection(url);
                initDB();
            }catch(SQLException e){
                System.err.println("Impossible de se connecter à la DB");
                System.exit(0);
            }catch (ClassNotFoundException f){
                System.err.println("Impossible de charger les Driver");
                System.exit(0);
            }
    }

    private void initDB() throws SQLException{
            String query = "create table if not exists voiture(\n" +
                    "    id not null primary key,\n" +
                    "    nom text,\n" +
                    "    energie text,\n" +
                    "    state text,\n" +
                    "    constraint pk_table primary key(id)\n" +
                    ")";
        Statement statement = connection.createStatement();
        statement.execute(query);
    }


    public static Connection getConnection() {
        if (connection == null){

            new ConnectDB();
        }
        return connection;
    }
}
