package br.com.faculdade.imepac.entidade.pessoa;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "experiencias_educacionais")
@NoArgsConstructor
@Data
public class ExperienciaEducacional {
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
}
