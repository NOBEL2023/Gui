package Service;

import Entite.*;

import java.sql.SQLException;
import java.util.List;

public interface IService <T>{

    boolean ajouter(T t) throws SQLException;

    boolean supprimer(int id) throws SQLException;

    boolean update(T t,int i) throws SQLException;

    default T findById(int i) throws SQLException {
        return null;
    }

    List<T> readAll() throws SQLException;


}
