package br.com.trabalholk.dao;

import br.com.trabalholk.model.Autor;

import java.util.List;
import java.util.Optional;

public interface IAutorDAO {

    Autor save (Autor autor);
    Autor update (Autor autor);
    void delete (int codAutor);
    List<Autor> findAll();
    Optional<Autor> findByCod(Autor codeAutor);
}
