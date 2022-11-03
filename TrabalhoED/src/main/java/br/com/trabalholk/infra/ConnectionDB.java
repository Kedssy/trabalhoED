package br.com.trabalholk.infra;

import java.sql.*;


public class ConnectionDB {
    private static Connection conexao_PostgreSQL = null;
    private static String location = "localhost";
    private static String Link = "jdbc:postgresql://localhost:5432/TrabalhoED";
    private static final String usuario = "postgres";
    private static final String senha = "extensao";


    public static Connection connectionPostgreSQL() {
        try {
            conexao_PostgreSQL = DriverManager.getConnection(Link, usuario, senha);
            System.out.println("Conexão realizada!");
        } catch (SQLException e) {
            throw new RuntimeException("Ocorreu um problema ao realizar a conexão: ", e);
        }
        return conexao_PostgreSQL;
    }

    public static void closeConnectionPostgreSQL() {
        try {
            if (conexao_PostgreSQL != null) {
                conexao_PostgreSQL.close();
                System.out.println("Conexao fechada");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ocorreu um problema ao encerrar a conexão: ", e);
        }
    }

}
