package br.com.faculdade.imepac.entidade.pessoa;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "dados_profissoes")
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

    private boolean voluntario;

    @OneToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @Override
    public String toString() {
        return "DadosProfissao{" + "id=" + id + ", periodo=" + periodo + ", cargo='" + cargo + '\'' + ", salario=" + salario + ", cargaHoraria=" + cargaHoraria + ", acolhido=" + acolhido + '}';
    }

    public void setCargo(String cargo) throws Exception {
        if (cargo.isEmpty() || cargo == null) {
            throw new Exception("Cargo é um campo obrigatório!");
        }
        this.cargo = cargo;
    }

    public void setSalario(String salario) throws Exception {
        if ((salario == null || salario.isEmpty()) && this.voluntario == false) {
            throw new Exception("Salário é um campo obrigatório!");
        }
        if (this.voluntario == true) {
            this.salario = null;
        } else {
            this.salario = new BigDecimal(salario).divide(new BigDecimal(100));
        }
    }

    public void setPeriodoCargaHoraria(Integer cargaHoraria) throws Exception {
        if (cargaHoraria == 0 || cargaHoraria == null) {
            throw new Exception("Salário é um campo obrigatório!");
        }
        this.cargaHoraria = cargaHoraria;
    }
}
