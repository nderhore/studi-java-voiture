package org.example.dao.impl;

import org.example.connector.ConnectDB;
import org.example.dao.VoitureDAO;
import org.example.pojo.Voiture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class VoitureDAOImpl implements VoitureDAO {

    Connection connection = ConnectDB.getConnection();


    @Override
    public int add(Voiture voiture) throws SQLException {
        String query = "INSERT INTO voiture(nom,energie,state) VALUES (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1,voiture.getNom());
        ps.setString(2,voiture.getEnergie().toString());
        ps.setBoolean(3,voiture.isState());

        return ps.executeUpdate(); // retour : nombre de ligne impacté
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM voiture where id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1,id);
        ps.executeUpdate();
    }

    @Override
    public Voiture getVoitureById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Voiture> getVoitures() throws SQLException {
        return null;
    }

    @Override
    public void update(Voiture voiture) throws SQLException {

    }
}
