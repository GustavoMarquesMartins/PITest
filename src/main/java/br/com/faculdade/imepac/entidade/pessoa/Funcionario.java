package br.com.faculdade.imepac.entidade.pessoa;


import br.com.faculdade.imepac.infraestrutura.DocumentValidator;
import br.com.faculdade.imepac.infraestrutura.ListaStringConverter;
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

    private String habilitacao;

    private String MEI;

    private boolean status;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Enumerated(EnumType.STRING)
    private Cor cor;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    private String endereco;

    private String telefone;

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

    public void adicionarHabilidade(String habilidade){
        this.habilidades.add(habilidade);
    }
    public void adicionarExperienciaProfissional(ExperienciaProfissional experienciaProfissional){
        this.experienciaProfissional.add(experienciaProfissional);
    }
    public void adicionarEducacional(ExperienciaEducacional experienciaEducacional){
        this.experienciaEducacional.add(experienciaEducacional);
    }
    public void setNome(String nome){
        //Remove qualquer espacamento no inicio e fim de uma string ou caracter especial
        var nomeSemEspacosNoInicioENoFim = nome.strip();
        String nomeSemQualquerCaracterEspecial = nomeSemEspacosNoInicioENoFim.replaceAll("[^a-zA-Z]", "");
        this.nome = nomeSemQualquerCaracterEspecial;
    }

    public void setCpf(String cpf) {
        // Atribui um cpf para a instancia
        this.cpf = DocumentValidator.mascaraCpf(cpf);
    }
}
