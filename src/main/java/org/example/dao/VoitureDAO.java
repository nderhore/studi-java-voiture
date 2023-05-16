package org.example.dao;

import org.example.pojo.Voiture;

import java.sql.SQLException;
import java.util.List;

public interface VoitureDAO {

    int add(Voiture voiture) throws SQLException;

    void delete(int id) throws SQLException;

    Voiture getVoitureById(int id) throws SQLException;

    List<Voiture> getVoitures() throws SQLException;

    public void update(Voiture voiture) throws SQLException;


}
