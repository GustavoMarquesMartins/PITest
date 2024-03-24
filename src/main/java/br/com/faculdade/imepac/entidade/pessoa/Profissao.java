
package br.com.faculdade.imepac.entidade.pessoa;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
@Embeddable
public class Profissao {
    private String cargo;

    private BigDecimal salario;

    private int cargaHoraria;

    @Enumerated(EnumType.STRING)
    private PeriodoDia periodo;

    private boolean acolhido;
}

