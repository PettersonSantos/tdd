package br.com.petterson.tdd.service;

import br.com.petterson.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioAlto(){
        Funcionario funcionario = new Funcionario("João", LocalDate.now(), new BigDecimal(15000));
        BonusService bonusService = new BonusService();
        assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(funcionario));
    }

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioAltoCapturandoMenssagemDaException(){
        Funcionario funcionario = new Funcionario("João", LocalDate.now(), new BigDecimal(15000));
        BonusService bonusService = new BonusService();
        try {
            bonusService.calcularBonus(funcionario);
            fail();
        }catch (Exception e){
            assertEquals("Funcionario com salario maior que R$10.000,00 não recebe bonus", e.getMessage());
        }
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario(){
        Funcionario funcionario = new Funcionario("João", LocalDate.now(), new BigDecimal(9000));
        BonusService bonusService = new BonusService();
        assertEquals(bonusService.calcularBonus(funcionario), new BigDecimal("900.0"));
    }

    @Test
    void bonusDeveriaSer1000(){
        Funcionario funcionario = new Funcionario("João", LocalDate.now(), new BigDecimal(10000));
        BonusService bonusService = new BonusService();
        assertEquals(bonusService.calcularBonus(funcionario), new BigDecimal("1000.0"));
    }

}