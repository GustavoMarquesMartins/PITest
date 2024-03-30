package br.com.faculdade.imepac.entidade.pessoa;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "dados_profissao")
public class DadosProfissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private PeriodoDia periodo;

    private String cargo;

    private BigDecimal salario;

    private int cargaHoraria;

    private boolean acolhido;

    @OneToOne(mappedBy = "dadosProfissao")
    private Funcionario funcionario;

    @Override
    public String toString() {
        return "DadosProfissao{" +
                "id=" + id +
                ", periodo=" + periodo +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", cargaHoraria=" + cargaHoraria +
                ", acolhido=" + acolhido +
                '}';
    }
}
