package br.com.faculdade.imepac.dao;

import javax.persistence.EntityManager;

public class EntityPersistence {
    
    private EntityManager entityManager;
    
    public EntityPersistence(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public <T> void saveInstance(T instance){
        this.entityManager.persist(instance);
    }
}
