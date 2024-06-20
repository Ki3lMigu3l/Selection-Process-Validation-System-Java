package com.dio.processo.seletivo.exception;

public class CandidatoNaoSelecionadoException extends RuntimeException {
    public CandidatoNaoSelecionadoException(String nome) {
        super("Candidato " + nome + " não foi selecionado para a entrevista.");
    }
}
