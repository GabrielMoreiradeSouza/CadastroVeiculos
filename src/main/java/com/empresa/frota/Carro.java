
package com.empresa.frota;

public class Carro extends Veiculo {
    private int quantidadePortas;

    public Carro(String placa, String modelo, int ano, double consumoCombustivel, int quantidadePortas) {
        super(placa, modelo, ano, consumoCombustivel);
        this.quantidadePortas = quantidadePortas;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    @Override
    public double calcularCusto(double distancia, double precoCombustivel) {
        return (distancia / getConsumoCombustivel()) * precoCombustivel;
    }

    @Override
    public String toString() {
        return super.toString() + ", Carro [Portas: " + quantidadePortas + "]";
    }
}
