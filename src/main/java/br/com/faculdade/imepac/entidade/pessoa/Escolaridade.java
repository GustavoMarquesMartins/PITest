package br.com.faculdade.imepac.entidade.pessoa;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "escolaridades")
@NoArgsConstructor
@Data
public class Escolaridade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String instituicao;

    private String curso;

    private boolean graduacao;

    private LocalDate periodoInicio;

    private LocalDate periodoFim;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @Override
    public String toString() {
        return "ExperienciaEducacional{"
                + "id=" + id
                + ", instituicao='" + instituicao + '\''
                + ", curso='" + curso + '\''
                + ", graduacao=" + graduacao
                + ", periodoInicio=" + periodoInicio
                + ", periodoFim=" + periodoFim
                + ", descricao='" + descricao + '\''
                + '}';
    }
}
