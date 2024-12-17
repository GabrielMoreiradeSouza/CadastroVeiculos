
package com.empresa.frota;

public class Caminhao extends Veiculo {
    private double capacidadeCarga;

    public Caminhao(String placa, String modelo, int ano, double consumoCombustivel, double capacidadeCarga) {
        super(placa, modelo, ano, consumoCombustivel);
        this.capacidadeCarga = capacidadeCarga;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    @Override
    public double calcularCusto(double distancia, double precoCombustivel) {
        return (distancia / getConsumoCombustivel()) * precoCombustivel * 1.2;
    }

    @Override
    public String toString() {
        return super.toString() + ", Caminhão [Capacidade Carga: " + capacidadeCarga + " toneladas]";
    }
}
