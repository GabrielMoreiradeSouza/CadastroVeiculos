
package com.empresa.frota;

public abstract class Veiculo implements Calculavel {
    private String placa;
    private int portas;
    private String modelo;
    private double consumo;
    private int ano;
    private double consumoCombustivel;
    private boolean disponivel;

    public Veiculo(String placa, String modelo, int ano, double consumoCombustivel) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.consumoCombustivel = consumoCombustivel;
        this.disponivel = true;
    }

    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }
    public double getConsumoCombustivel() { return consumoCombustivel; }
    public boolean isDisponivel() { return disponivel; }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public abstract double calcularCusto(double distancia, double precoCombustivel);

    @Override
    public String toString() {
        return "Veículo [Placa: " + placa + ", Modelo: " + modelo + ", Ano: " + ano + "]";
    }
    public int getPortas(){
        return portas;
    }
    public double getConsumo(){
        return consumo;
    }
}
