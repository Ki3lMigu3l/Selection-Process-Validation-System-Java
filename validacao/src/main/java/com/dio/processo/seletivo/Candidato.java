package com.dio.processo.seletivo;


public class Candidato {
    private String nome;
    private double salarioPretendido;

    public Candidato(String nome, double salarioPretendido) {
        this.nome = nome;
        this.salarioPretendido = salarioPretendido;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioPretendido() {
        return salarioPretendido;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "nome='" + nome + '\'' +
                ", salarioPretendido=" + salarioPretendido +
                '}';
    }
}
