package com.empresa.frota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Frota {
    public static void addVeiculo(Veiculo veiculo) {
        String sql = "INSERT INTO veiculos (tipo, placa, modelo, ano, consumo, adicional) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, veiculo instanceof Carro ? "Carro" : "Caminhão");
            stmt.setString(2, veiculo.getPlaca());
            stmt.setString(3, veiculo.getModelo());
            stmt.setInt(4, veiculo.getAno());
            stmt.setDouble(5, veiculo.getConsumo());

            if (veiculo instanceof Carro) {
                stmt.setDouble(6, ((Carro) veiculo).getPortas());
            } else {
                stmt.setDouble(6, ((Caminhao) veiculo).getCapacidadeCarga());
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Veiculo> getVeiculos() {
        ArrayList<Veiculo> lista = new ArrayList<>();
        String sql = "SELECT * FROM veiculos";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String tipo = rs.getString("tipo");
                String placa = rs.getString("placa");
                String modelo = rs.getString("modelo");
                int ano = rs.getInt("ano");
                double consumo = rs.getDouble("consumo");
                double adicional = rs.getDouble("adicional");

                if (tipo.equals("Carro")) {
                    lista.add(new Carro(placa, modelo, ano, consumo, (int) adicional));
                } else {
                    lista.add(new Caminhao(placa, modelo, ano, consumo, adicional));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}