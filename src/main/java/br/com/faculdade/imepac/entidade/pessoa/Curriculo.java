package br.com.faculdade.imepac.entidade.pessoa;

import br.com.faculdade.imepac.infraestrutura.ListaStringConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.net.ProxySelector;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "curriculos")
@NoArgsConstructor
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private String endereco;

    private String email;

    private String telefone;

    @OneToMany(mappedBy = "curriculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExperienciaProfissional> experienciaProfissional;

    @OneToMany(mappedBy = "curriculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExperienciaEducacional> experienciaEducacional;

    @Convert(converter = ListaStringConverter.class)
    private List<String> habilidades;

    @OneToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;
    public void adicionarHabilidade(String habilidade){
        this.habilidades.add(habilidade);

    }

    @Entity(name = "experiencias_educacionais")
    @NoArgsConstructor
    @Data
    public static class ExperienciaEducacional {
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
        @JoinColumn(name = "curriculo_id")
        private Curriculo curriculo;
    }

    @Entity(name = "experiencias_profissionais")
    @NoArgsConstructor
    @Data
    public static class ExperienciaProfissional {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String cargo;

        private String empresa;

        private LocalDate periodoInicio;

        private LocalDate periodoFim;

        private String descricao;

        @ManyToOne
        @JoinColumn(name = "curriculo_id")
        private Curriculo curriculo;
    }

}

