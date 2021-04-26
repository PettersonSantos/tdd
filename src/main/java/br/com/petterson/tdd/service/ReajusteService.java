package br.com.petterson.tdd.service;

import br.com.petterson.tdd.enumeration.Desempenho;
import br.com.petterson.tdd.modelo.Funcionario;

public class ReajusteService {
    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
        funcionario.reajustarSalario(funcionario.getSalario().multiply(desempenho.percentualReajuste()));
    }
}
