package com.empresa.frota;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String URL = "jdbc:postgresql://localhost:5432/frota";
    private static final String USER = "postgres";
    private static final String PASSWORD = "aluno";

    public static Connection getConnection() {
        try {

            Class.forName("org.postgresql.Driver");


            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.err.println("Driver do PostgreSQL não encontrado!");
            throw new RuntimeException("Erro: Driver não carregado.", e);

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados!");
            throw new RuntimeException("Erro ao conectar ao banco de dados!", e);
        }
    }

    public static void main(String[] args) throws SQLException {

        try (Connection conn = Database.getConnection()) {
            System.out.println("Conexão com o banco de dados bem-sucedida!");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}