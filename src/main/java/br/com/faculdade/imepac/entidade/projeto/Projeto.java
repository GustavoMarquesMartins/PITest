package br.com.faculdade.imepac.entidade.projeto;

import br.com.faculdade.imepac.data_utility.DataValidation;
import br.com.faculdade.imepac.data_utility.Mask;
import br.com.faculdade.imepac.entidade.relacionamento.Relacionamento;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "projetos")
@NoArgsConstructor
@Data
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String cep;

    private String servico;

    private String descricao;

    private LocalDate dataCriacao;

    private String publicoAlvo;

    private String justificativa;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private Set<Relacionamento> relacionamentos = new HashSet<>();

    /**
     * Atribui um nome formatado ao objeto.
     *
     * @param nome O nome a ser atribuído ao objeto.
     */
    public void setNome(String nome) throws Exception {
        if (nome == null || nome.isEmpty()) {
            throw new Exception("Nome é um campo obrigatório.");
        }
        this.nome = Mask.formataNome(nome);
    }

    /**
     * Atribui um CEP formatado ao objeto.
     *
     * @param cep O CEP a ser atribuído ao objeto.
     * @throws Exception Se o CEP fornecido não for válido.
     */
    public void setCep(String cep) throws Exception {
        var valido = DataValidation.validaCep(cep);
        if (!valido) {
            throw new Exception("CEP inválido!");
        }
        this.cep = cep;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
