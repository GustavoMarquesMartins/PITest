package br.com.faculdade.imepac.entidade.pessoa;


import br.com.caelum.stella.bean.validation.CNPJ;
import br.com.caelum.stella.bean.validation.CPF;
import br.com.faculdade.imepac.infraestrutura.DataValidation;
import br.com.faculdade.imepac.infraestrutura.ListaStringConverter;
import br.com.faculdade.imepac.infraestrutura.Mask;
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

    private String Cnh;

    private String Mei;

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
        this.nome = Mask.mascaraNome(nome);
    }

    public void setRg(String rg) throws Exception {
       var valido = DataValidation.validaRg(rg);
       if(!valido){
           throw new Exception("RG inválido");
       }
       this.rg = Mask.mascaraRg(rg);
    }

    public void setCpf(String cpf) throws Exception {
        // Atribui um cpf para a instancia
        var valido = DataValidation.validaCpf(cpf);
        if (!valido){
            throw new Exception("CPF inválido!");
        }
        this.cpf = Mask.mascaraCpf(cpf);
    }

}
