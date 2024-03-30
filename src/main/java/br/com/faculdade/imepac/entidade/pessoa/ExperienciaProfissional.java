package br.com.faculdade.imepac.entidade.pessoa;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "experiencias_profissionais")
@NoArgsConstructor
@Data
public class ExperienciaProfissional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String cargo;

    private String empresa;

    private LocalDate periodoInicio;

    private LocalDate periodoFim;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @Override
    public String toString() {
        return "ExperienciaProfissional{" +
                "id=" + id +
                ", cargo='" + cargo + '\'' +
                ", empresa='" + empresa + '\'' +
                ", periodoInicio=" + periodoInicio +
                ", periodoFim=" + periodoFim +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
