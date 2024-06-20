package com.dio.processo.seletivo;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ProcessoSeletivo processoSeletivo = new ProcessoSeletivo();

    public static void main(String[] args) {
        processoSeletivo.adicionarCandidato(new Candidato("Ezequiel Miguel", valorPretendido()));
        processoSeletivo.adicionarCandidato(new Candidato("Miguel Abner", valorPretendido()));
        processoSeletivo.adicionarCandidato(new Candidato("João Silva", valorPretendido()));
        processoSeletivo.adicionarCandidato(new Candidato("Ana Costa", valorPretendido()));
        processoSeletivo.adicionarCandidato(new Candidato("José Pereira", valorPretendido()));
        processoSeletivo.adicionarCandidato(new Candidato("Mariana Almeida", valorPretendido()));
        processoSeletivo.adicionarCandidato(new Candidato("Rafael Lima", valorPretendido()));
        processoSeletivo.adicionarCandidato(new Candidato("Juliana Mendes", valorPretendido()));

        while (true) {
            exibirMenu();
            int opcao = Integer.parseInt(sc.nextLine());
            executarOpcao(opcao);
        }
    }

    private static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2000);
    }

    private static void exibirMenu() {
        System.out.println("""
                --- Sistema de Validação de Processo Seletivo ---
                1. Adicionar candidato
                2. Selecionar candidatos para entrevista
                3. Listar candidatos selecionados
                4. Realizar ligações
                5. Sair
                Escolha uma opção: """);
    }

    private static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarCandidato();
                break;
            case 2:
                selecionarCandidatosParaEntrevista();
                break;
            case 3:
                listarCandidatosSelecionados();
                break;
            case 4:
                realizarLigacoes();
                break;
            case 5:
                sair();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void adicionarCandidato() {
        System.out.println("Informe o nome do Candidato: ");
        String nome = sc.nextLine();

        System.out.println("Infoeme o salario pretendido: ");
        double salarioPretendido = Double.parseDouble(sc.nextLine());

        processoSeletivo.adicionarCandidato(new Candidato(nome, salarioPretendido));
    }

    private static void selecionarCandidatosParaEntrevista() {
        try {
            processoSeletivo.selecionarCandidatosParaEntrevista();
            System.out.println("Candidatos selecionados com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listarCandidatosSelecionados() {
        processoSeletivo.listarCandidatosSelecionados();
    }

    private static void realizarLigacoes() {
        processoSeletivo.realizarLigacoes();
    }


    private static void sair() {
        System.out.println("Saindo...");
        sc.close();
        System.exit(0);
    }
}

