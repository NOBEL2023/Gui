package Service;

import Entite.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IServiceContrat<T> {

        boolean ajouter(T t, Client C, vehicule V) throws SQLException;

        boolean supprimer(int id) throws SQLException;

        boolean update(T t, int i, Client C, vehicule V) throws SQLException;

        T findById(int i) throws SQLException;

    List<Map<String, Object>> readAll() throws SQLException;



}
