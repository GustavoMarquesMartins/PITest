package br.com.faculdade.imepac.employeemangement;

import br.com.faculdade.imepac.dao.EntityPersistence;
import br.com.faculdade.imepac.infrastructure.JPAUtil;
import br.com.faculdade.imepac.model.Teste;

import javax.persistence.EntityManager;

public class EmployeeMangement {

    public static void main(String[] args) {

        var em = JPAUtil.getEntityManager();
        var entityPersistence = new EntityPersistence(em);

        var teste = new Teste("Gustavo", "12112121");

        em.getTransaction().begin();
        entityPersistence.saveInstance(teste);
        em.getTransaction().commit();
    }
}
