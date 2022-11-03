import br.com.trabalholk.dao.AutorDAO;
import br.com.trabalholk.infra.ConnectionDB;
import br.com.trabalholk.model.Autor;

import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) throws SQLException {

        AutorDAO autorDAO = new AutorDAO();
        Autor autor = new Autor();
        autorDAO.save(autor);

    }
}