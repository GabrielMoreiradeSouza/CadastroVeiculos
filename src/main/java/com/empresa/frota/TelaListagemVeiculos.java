package com.empresa.frota;

import javax.swing.*;

public class TelaListagemVeiculos extends JFrame {
    public TelaListagemVeiculos() {
        setTitle("Veículos Cadastrados");
        setSize(400, 300);

        JTextArea areaLista = new JTextArea();
        areaLista.setEditable(false);

        StringBuilder lista = new StringBuilder();
        for (Veiculo veiculo : Frota.getVeiculos()) {
            lista.append(veiculo.toString()).append("\\n");
        }
        areaLista.setText(lista.toString());

        add(new JScrollPane(areaLista));
        setVisible(true);
    }
}