package br.com.petterson.tdd.service;

import br.com.petterson.tdd.enumeration.Desempenho;
import br.com.petterson.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReajusteServiceTest {

    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar(){
        this.reajusteService = new ReajusteService();
        this.funcionario = new Funcionario("João", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar(){
        reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeDezPorCentoQuandoDesempenhoForBom(){
        reajusteService.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo(){
        reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}