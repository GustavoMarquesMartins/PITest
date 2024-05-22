package br.com.faculdade.imepac.entidade.relacionamento;

import br.com.faculdade.imepac.entidade.pessoa.Funcionario;
import br.com.faculdade.imepac.entidade.projeto.Projeto;
import java.time.LocalDate;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "relacionamentos")
@NoArgsConstructor
@Setter
@Getter
public class Relacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "id_projeto")
    private Projeto projeto;

    @NotNull
    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_termino")
    private LocalDate dataTermino;
}
