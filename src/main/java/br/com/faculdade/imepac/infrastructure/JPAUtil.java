package br.com.faculdade.imepac.infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    
    public static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("teste");
    
    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
