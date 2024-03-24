package br.com.faculdade.imepac.entidade.projeto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Entity(name = "projetos")
@NoArgsConstructor
@Data
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String endereco;

    private String servico;

    private String descricao;

    private LocalDate dataCriacao;

    private String publicoAlvo;

    private String justificativa;
}
