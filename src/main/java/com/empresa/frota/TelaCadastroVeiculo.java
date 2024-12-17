package com.empresa.frota;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroVeiculo extends JFrame {
    private JTextField txtPlaca, txtModelo, txtAno, txtConsumo, txtAdicional;
    private JComboBox<String> tipoVeiculo;

    public TelaCadastroVeiculo() {
        setTitle("Cadastro de Veículo");
        setSize(400, 300);
        setLayout(new GridLayout(7, 2));

        add(new JLabel("Tipo do Veículo:"));
        tipoVeiculo = new JComboBox<>(new String[]{"Carro", "Caminhão"});
        add(tipoVeiculo);

        add(new JLabel("Placa:"));
        txtPlaca = new JTextField();
        add(txtPlaca);

        add(new JLabel("Modelo:"));
        txtModelo = new JTextField();
        add(txtModelo);

        add(new JLabel("Ano:"));
        txtAno = new JTextField();
        add(txtAno);

        add(new JLabel("Consumo (km/l):"));
        txtConsumo = new JTextField();
        add(txtConsumo);

        add(new JLabel("Portas (Carro) / Capacidade Carga (Caminhão):"));
        txtAdicional = new JTextField();
        add(txtAdicional);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> salvarVeiculo());
        add(btnSalvar);

        setVisible(true);
    }

    private void salvarVeiculo() {
        String tipo = (String) tipoVeiculo.getSelectedItem();
        String placa = txtPlaca.getText();
        String modelo = txtModelo.getText();
        int ano = Integer.parseInt(txtAno.getText());
        double consumo = Double.parseDouble(txtConsumo.getText());

        if (tipo.equals("Carro")) {
            int portas = Integer.parseInt(txtAdicional.getText());
            Frota.addVeiculo(new Carro(placa, modelo, ano, consumo, portas));
        } else {
            double capacidade = Double.parseDouble(txtAdicional.getText());
            Frota.addVeiculo(new Caminhao(placa, modelo, ano, consumo, capacidade));
        }

        JOptionPane.showMessageDialog(this, "Veículo cadastrado com sucesso!");
        dispose();
    }
}