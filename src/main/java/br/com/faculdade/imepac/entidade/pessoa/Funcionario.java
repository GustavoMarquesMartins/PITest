package br.com.faculdade.imepac.entidade.pessoa;


import br.com.faculdade.imepac.data_utility.DataValidation;
import br.com.faculdade.imepac.entidade.projeto.Projeto;
import br.com.faculdade.imepac.infraestrutura.ListaStringConverter;
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

    @NotBlank
    private String nome;

    @NotBlank
    @Column(unique = true)
    private String rg;

    @NotBlank
    @Column(unique = true)
    private String cpf;

    @NotNull
    private LocalDate dataNascimento;

    private String cnh;

    private String mei;

    @NotNull
    private boolean status;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Cor cor;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @NotBlank
    private String cep;

    @NotBlank
    private String numeroCelular;

    @NotBlank
    private String email;

    @NotBlank
    private String pathCurriculo;

    private String pathCarteiraDeTrabalho;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private DadosProfissao dadosProfissao;

    @Convert(converter = ListaStringConverter.class)
    private List<String> habilidades = new ArrayList<>();


    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Escolaridade> escolaridade = new ArrayList<>();

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExperienciaProfissional> experienciaProfissional = new ArrayList<>();

    public void adicionarHabilidade(String habilidade) {
        this.habilidades.add(habilidade);
    }

    public void adicionarExperienciaProfissional(ExperienciaProfissional experienciaProfissional) {
        this.experienciaProfissional.add(experienciaProfissional);
    }

    public void adicionarEducacional(Escolaridade experienciaEducacional) {
        this.escolaridade.add(experienciaEducacional);
    }

    @ManyToOne
    private Projeto projeto;

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
        if (!valido) {
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
        if (!valido) {
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
        if (!valido) {
            throw new Exception("Email inválido!");
        }
        this.email = email;
    }
}
