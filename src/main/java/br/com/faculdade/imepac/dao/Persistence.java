package br.com.faculdade.imepac.dao;

import javax.persistence.EntityManager;

public class Persistence {
    private EntityManager em;

    public Persistence(EntityManager em){
        this.em = em;
    }
    public <T> void salvar(T projeto){
        em.persist(projeto);
    }
}
