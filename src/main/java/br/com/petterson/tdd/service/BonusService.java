package br.com.petterson.tdd.service;

import java.math.BigDecimal;

import br.com.petterson.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("Funcionario com salario maior que R$10.000,00 não recebe bonus");
		}
		return valor;
	}

}
