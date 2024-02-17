package Service;

import Entite.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IServiceContrat<T> {

        boolean ajouter(T t,client C,vehicule V) throws SQLException;

        boolean supprimer(T t) throws SQLException;

        boolean update(T t,int i,client C,vehicule V) throws SQLException;

        T findById(int i) throws SQLException;

    List<Map<String, Object>> readAll() throws SQLException;



}
