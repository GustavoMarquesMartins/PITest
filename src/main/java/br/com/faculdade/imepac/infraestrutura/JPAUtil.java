package br.com.faculdade.imepac.infraestrutura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    public static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("casa_de_davi");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
