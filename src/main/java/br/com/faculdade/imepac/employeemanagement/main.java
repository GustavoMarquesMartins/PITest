package br.com.faculdade.imepac.employeemanagement;

import br.com.faculdade.imepac.dao.Persistence;
import br.com.faculdade.imepac.entidade.pessoa.*;
import br.com.faculdade.imepac.infraestrutura.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;

public class main {
    public static void main(String[] args) throws Exception {
        EntityManager em = JPAUtil.getEntityManager();
        Persistence persistence = new Persistence(em);

        //Gera instancia de funcionario
        var funcionario = new Funcionario();

        // Gera instancia de experiencia profissionais
        var experienciaProfissional = new ExperienciaProfissional();
        // Define dados da experiencia profissional
        experienciaProfissional.setCargo("teste");
        experienciaProfissional.setEmpresa("Empresa XYZ");
        experienciaProfissional.setPeriodoInicio(LocalDate.of(2020, 1, 1));
        experienciaProfissional.setPeriodoFim(LocalDate.of(2021, 1, 1));
        experienciaProfissional.setDescricao("Experiência profissional na área X");
        experienciaProfissional.setFuncionario(funcionario);

        //Gera instancia de experiencia educacional
        var experienciaEducacional = new Escolaridade();
        //Define dados da experiencia educacional
        experienciaEducacional.setInstituicao("Universidade XYZ");
        experienciaEducacional.setCurso("Ciência da Computação");
        experienciaEducacional.setGraduacao(true);
        experienciaEducacional.setPeriodoInicio(LocalDate.of(2018, 1, 1));
        experienciaEducacional.setPeriodoFim(LocalDate.of(2022, 1, 1));
        experienciaEducacional.setDescricao("Experiência educacional na área de tecnologia");
        experienciaEducacional.setFuncionario(funcionario);

        //Gera instancia de dados Profissao
        var dadosProfissao = new DadosProfissao();
        // Define os dados da profissao
        dadosProfissao.setCargo("Cargo");
        dadosProfissao.setSalario(new BigDecimal("12.00"));
        dadosProfissao.setCargaHoraria(8);
        dadosProfissao.setPeriodo(PeriodoDia.MATUTINO);
        dadosProfissao.setAcolhido(true);
        dadosProfissao.setFuncionario(funcionario); // <- definindo funcionario dono dos dados

        // Define os dados do funcionario
        funcionario.setNome("Roberto");
        funcionario.setRg("12345678910");
        funcionario.setCpf("52998224725"); // <- passar cpf valido
        funcionario.setDataNascimento(LocalDate.of(1980, 5, 10));
        funcionario.setCnh("40584103720");
        funcionario.setMei("123456789");
        funcionario.setStatus(true);
        funcionario.setEstadoCivil(EstadoCivil.CASADO);
        funcionario.setCor(Cor.BRANCO);
        funcionario.setGenero(Genero.MASCULINO);
        funcionario.setCep("38446213");
        funcionario.setnumeroCelular("34991841164");
        funcionario.setEmail("roberto@example.com");
        funcionario.setPathCurriculo("");
        funcionario.setPathCarteiraDeTrabalho("");
        funcionario.setDadosProfissao(dadosProfissao); // <- Define os dados de profissao do funcionario
        funcionario.adicionarHabilidade("");
        funcionario.adicionarExperienciaProfissional(experienciaProfissional); // <- experincia profissional
        funcionario.adicionarEducacional(experienciaEducacional); // <- experincia profissional

        em.getTransaction().begin();
        persistence.save(funcionario);
        em.getTransaction().commit();

    }
}