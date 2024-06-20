package com.dio.processo.seletivo;

import com.dio.processo.seletivo.exception.CandidatoNaoSelecionadoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessoSeletivo {
    private static final double SALARIO_BASE = 2000;
    private final List<Candidato> candidatos = new ArrayList<>();
    private final List<Candidato> candidatosSelecionados = new ArrayList<>();

    public void adicionarCandidato(Candidato candidato) {
        candidatos.add(candidato);
        validarCandidato(candidato);
    }

    public void validarCandidato(Candidato candidato) {
        if (candidato.getSalarioPretendido() < SALARIO_BASE) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (candidato.getSalarioPretendido() == SALARIO_BASE) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }

    public void selecionarCandidatosParaEntrevista() {
        candidatosSelecionados.addAll(
                candidatos.stream()
                        .filter(candidato -> candidato.getSalarioPretendido() <= SALARIO_BASE)
                        .limit(5)
                        .toList()
        );

        if (candidatosSelecionados.size() < 5) {
            throw new CandidatoNaoSelecionadoException("Menos de 5 candidatos foram selecionados.");
        }
    }

    public void listarCandidatosSelecionados() {
        for (Candidato candidato : candidatosSelecionados) {
            System.out.println(candidato.toString());
        }
        // candidatosSelecionados.forEach(System.out::println);
    }

    public void realizarLigacoes() {
        Random random = new Random();
        for (Candidato candidato : candidatosSelecionados) {
            int tentativas = 0;
            boolean conseguiuContato = false;
            while (tentativas < 3 && !conseguiuContato) {
                tentativas++;
                conseguiuContato = random.nextBoolean();
            }
            if (conseguiuContato) {
                System.out.println("Conseguimos contato com " + candidato.getNome() + " após " + tentativas + " tentativa(s)");
            } else {
                System.out.println("Não conseguimos contato com o " + candidato.getNome());
            }
        }
    }
}
