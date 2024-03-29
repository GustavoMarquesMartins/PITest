package br.com.faculdade.imepac.entidade.pessoa;


import br.com.faculdade.imepac.data_utility.DataValidation;
import br.com.faculdade.imepac.infraestrutura.ListaStringConverter;
import br.com.faculdade.imepac.data_utility.Mask;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private LocalDate dataNascimento;

    private String cnh;

    private String mei;

    private boolean status;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Enumerated(EnumType.STRING)
    private Cor cor;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    private String cep;

    private String numeroCelular;

    private String email;

    private String pathCurriculo;

    private String pathCarteiraDeTrabalho;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private DadosProfissao dadosProfissao;

    @Convert(converter = ListaStringConverter.class)
    private List<String> habilidades = new ArrayList<>();

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExperienciaEducacional> experienciaEducacional = new ArrayList<>();

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExperienciaProfissional> experienciaProfissional = new ArrayList<>();

    public void adicionarHabilidade(String habilidade) {
        this.habilidades.add(habilidade);
    }

    public void adicionarExperienciaProfissional(ExperienciaProfissional experienciaProfissional) {
        this.experienciaProfissional.add(experienciaProfissional);
    }

    public void adicionarEducacional(ExperienciaEducacional experienciaEducacional) {
        this.experienciaEducacional.add(experienciaEducacional);
    }

    /**
     * Atribui um nome formatado ao objeto.
     *
     * @param nome O nome a ser atribuído ao objeto.
     */
    public void setNome(String nome) {
        this.nome = Mask.mascaraNome(nome);
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
        this.cpf = Mask.mascaraCpf(cpf);
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
        this.cep = Mask.mascaraCep(cep);
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
            throw new Exception("CEP inválido!");
        }
        this.numeroCelular = Mask.mascaraNumeroCelular(numeroCelular);
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
