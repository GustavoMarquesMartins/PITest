package br.com.faculdade.imepac.entidade.pessoa;

import br.com.faculdade.imepac.data_utility.DataValidation;
import br.com.faculdade.imepac.entidade.projeto.Projeto;
import br.com.faculdade.imepac.data_utility.Mask;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "funcionarios")
@Data
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String rg;

    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    private String cnh;

    private String mei;

    @NotNull
    private boolean status;

    @Column(name = "estado_civil")
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Enumerated(EnumType.STRING)
    private Raca raca;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    private String cep;

    @Column(name = "numero_celular")
    private String numeroCelular;

    private String email;

    @Column(name = "curriculo")
    private String pathCurriculo;

    @Column(name = "carteira_de_trabalho")
    private String pathCarteiraDeTrabalho;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "dado_profissao_id", referencedColumnName = "id")
    private DadosProfissao dadosProfissao;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Habilidade> habilidade = new ArrayList<>();

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Escolaridade> escolaridade = new ArrayList<>();

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExperienciaProfissional> experienciaProfissional = new ArrayList<>();

    @ManyToOne
    private Projeto projeto;

    public void adicionarExperienciaProfissional(ExperienciaProfissional experienciaProfissional) {
        this.experienciaProfissional.add(experienciaProfissional);
    }

    public void adicionarEscolaridade(Escolaridade experienciaEducacional) {
        this.escolaridade.add(experienciaEducacional);
    }

    public void adicionarHabilidade(Habilidade habilidade) {
        this.habilidade.add(habilidade);
    }

    /**
     * Atribui um nome formatado ao objeto.
     *
     * @param nome O nome a ser atribuído ao objeto.
     */
    public void setNome(String nome) {
        this.nome = Mask.formataNome(nome);
    }

    /**
     * Atribui um CPF formatado ao objeto.
     *
     * @param cpf O CPF a ser atribuído ao objeto.
     * @throws Exception Se o CPF fornecido não for válido.
     */
    public void setCpf(String cpf) throws Exception {
        var valido = DataValidation.validaCpf(cpf);
        if (valido) {
            throw new Exception("CPF inválido!");
        }
        this.cpf = cpf;
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

    /**
     * Atribui um número de celular formatado ao objeto.
     *
     * @param numeroCelular O número de celular a ser atribuído ao objeto.
     * @throws Exception Se o número de celular fornecido não for válido.
     */
    public void setnumeroCelular(String numeroCelular) throws Exception {
        var valido = DataValidation.validaNumeroCelular(numeroCelular);
        if (valido) {
            throw new Exception("Número de celular inválido!");
        }
        this.numeroCelular = numeroCelular;
    }

    /**
     * Atribui um endereço de e-mail ao objeto.
     *
     * @param email O endereço de e-mail a ser atribuído ao objeto.
     * @throws Exception Se o endereço de e-mail fornecido não for válido.
     */
    public void setEmail(String email) throws Exception {
        var valido = DataValidation.validaEmail(email);
        if (valido) {
            throw new Exception("Email inválido!");
        }
        this.email = email;
    }
}
