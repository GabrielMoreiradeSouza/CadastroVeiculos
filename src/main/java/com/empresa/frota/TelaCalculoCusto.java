package com.empresa.frota;

import javax.swing.*;
import java.awt.*;

public class TelaCalculoCusto extends JFrame {
    private JTextField txtDistancia, txtPreco;

    public TelaCalculoCusto() {
        setTitle("Cálculo de Custo de Viagem");
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Distância percorrida (km):"));
        txtDistancia = new JTextField();
        add(txtDistancia);

        add(new JLabel("Preço do combustível (R$):"));
        txtPreco = new JTextField();
        add(txtPreco);

        JButton btnCalcular = new JButton("Calcular");
        JTextArea resultado = new JTextArea();
        resultado.setEditable(false);

        btnCalcular.addActionListener(e -> {
            double distancia = Double.parseDouble(txtDistancia.getText());
            double preco = Double.parseDouble(txtPreco.getText());
            double custoTotal = 0;

            for (Veiculo veiculo : Frota.getVeiculos()) {
                custoTotal += veiculo.calcularCusto(distancia, preco);
            }

            resultado.setText("Custo total da viagem: R$ " + String.format("%.2f", custoTotal));
        });

        add(btnCalcular);
        add(new JScrollPane(resultado));

        setVisible(true);
    }
}