package br.com.trabalholk.dao;

import br.com.trabalholk.dao.IAutorDAO;
import br.com.trabalholk.infra.ConnectionDB;
import br.com.trabalholk.model.Autor;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AutorDAO implements IAutorDAO {

    @Override
    public Autor save(Autor autor) {

        try {
            String sql = "INSERT INTO autor (nome_autor) VALUES ('Lucas')";
            Statement statement = ConnectionDB.connectionPostgreSQL().createStatement();

            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        ConnectionDB.closeConnectionPostgreSQL();
        return autor;
    }

    @Override
    public Autor update(Autor autor) {

        try {
            String sql = "UPDATE autor SET nome_autor = " + autor.getNomeAutor() + "WHERE cod_autor = " + autor.getCodAutor();
            Statement statement = ConnectionDB.connectionPostgreSQL().createStatement();

            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        ConnectionDB.closeConnectionPostgreSQL();
        return autor;
    }

    @Override
    public void delete(int codAutor) {
        try {
            String sql = "DELETE autor WHERE cod_autor = " + codAutor;
            Statement statement = ConnectionDB.connectionPostgreSQL().createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        ConnectionDB.closeConnectionPostgreSQL();
    }

    @Override
    public List<Autor> findAll() {
        ArrayList<Autor> listaAutor = new ArrayList<>();

        try {
            String sql = "SELECT * FROM autor";
            Statement statement = ConnectionDB.connectionPostgreSQL().createStatement();
            statement.executeQuery(String.valueOf(listaAutor));
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return null;
    }

    @Override
    public Optional<Autor> findByCod(Autor codeAutor) {
        return Optional.empty();
    }
}
