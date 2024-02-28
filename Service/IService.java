package Service;

import Entite.*;

import java.sql.SQLException;
import java.util.List;

public interface IService <T>{

    boolean ajouter(T t) throws SQLException;

    boolean supprimer(T t) throws SQLException;

    boolean update(T t,int i) throws SQLException;

    T findById(int i) throws SQLException;

    List<T> readAll() throws SQLException;


}
