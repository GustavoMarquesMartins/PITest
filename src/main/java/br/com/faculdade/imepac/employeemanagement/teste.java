package br.com.faculdade.imepac.employeemanagement;

import br.com.faculdade.imepac.dao.Persistence;
import br.com.faculdade.imepac.entidade.pessoa.Funcionario;
import br.com.faculdade.imepac.entidade.projeto.Projeto;
import br.com.faculdade.imepac.infraestrutura.JPAUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class teste {
    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        var ps = new Persistence(em);
        try {
            // Criando uma instância de Projeto
            Projeto projeto = new Projeto();

            // Atribuindo valores usando os métodos setter
            projeto.setNome("Nome do Projeto");
            projeto.setCep("12345678"); // Exemplo de CEP válido
            projeto.setServico("Serviço do Projeto");
            projeto.setDescricao("Descrição do Projeto");
            projeto.setDataCriacao(LocalDate.now()); // Data de criação como a data atual
            projeto.setPublicoAlvo("Público-alvo do Projeto");
            projeto.setJustificativa("Justificativa do Projeto");

            em.getTransaction().begin();
            ps.save(projeto);
            var lista = ps.getListEntity(Funcionario.class);
            for(Funcionario funcionarios : lista){
                System.out.println(funcionarios);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
