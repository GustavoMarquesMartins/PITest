package br.com.faculdade.imepac.dao;

import javax.persistence.EntityManager;
import java.util.List;

public class Persistence {
    private EntityManager em;

    public Persistence(EntityManager em) {
        this.em = em;
    }

    public <T> void save(T entity) {
        em.persist(entity);
    }

    public <T> T getEntity(Class<T> entityClass, Long id) {
        return this.em.find(entityClass, id);
    }

    public <T> void updateEntity(T entity) {
        this.em.merge(entity);
    }

    public <T> void delete(T entity) {
        entity = em.merge(entity);
        em.remove(entity);
    }

    public <T> List<T> getListEntity(Class<T> entityClass) {
        var tableName = entityClass.getSimpleName().toLowerCase() + "s";
        var JPQL = "SELECT c FROM " + tableName + " c";
        return em.createQuery(JPQL, entityClass).getResultList();
    }

}
