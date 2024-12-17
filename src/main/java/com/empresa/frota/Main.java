package com.empresa.frota;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gestão de Frota");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new GridLayout(4, 1));

            JButton btnCadastro = new JButton("Cadastrar Veículo");
            JButton btnListar = new JButton("Listar Veículos");
            JButton btnCusto = new JButton("Calcular Custo de Viagem");
            JButton btnSair = new JButton("Sair");

            btnCadastro.addActionListener(e -> new TelaCadastroVeiculo());
            btnListar.addActionListener(e -> new TelaListagemVeiculos());
            btnCusto.addActionListener(e -> new TelaCalculoCusto());

            btnSair.addActionListener(e -> System.exit(0));

            frame.add(btnCadastro);
            frame.add(btnListar);
            frame.add(btnCusto);
            frame.add(btnSair);

            frame.setVisible(true);
        });
    }
}