package br.com.faculdade.imepac.infraestrutura;

import br.com.faculdade.imepac.infraestrutura.JPAUtil;
import lombok.NoArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.bind.JAXB;
import java.util.List;

/**
 * Classe responsável por fornecer métodos genéricos para operações de
 * persistência.
 */
@NoArgsConstructor
public class Persistence {

    private EntityManager em;

    /**
     * Construtor da classe Persistence.
     *
     * @param em O EntityManager utilizado para interagir com o banco de dados.
     */
    public Persistence(EntityManager em) {
        this.em = em;
    }

    /**
     * Método para salvar uma entidade no banco de dados.
     *
     * @param entity A entidade a ser salva.
     * @param <T> O tipo da entidade.
     */
    public <T> void save(T entity) {
        em.persist(entity);
    }

    /**
     * Método para obter uma entidade do banco de dados pelo seu ID.
     *
     * @param entityClass A classe da entidade.
     * @param id O ID da entidade.
     * @param <T> O tipo da entidade.
     * @return A entidade encontrada ou null se não for encontrada.
     */
    public <T> T getEntity(Class<T> entityClass, Long id) {
        return this.em.find(entityClass, id);
    }

    /**
     * Método para atualizar uma entidade no banco de dados.
     *
     * @param entity A entidade a ser atualizada.
     * @param <T> O tipo da entidade.
     */
    public <T> void updateEntity(T entity) {
        this.em.merge(entity);
    }

    /**
     * Método para excluir uma entidade do banco de dados.
     *
     * @param entity A entidade a ser excluída.
     * @param <T> O tipo da entidade.
     */
    public <T> void delete(T entity) {
        entity = em.merge(entity);
        em.remove(entity);
    }

    /**
     * Método para obter uma lista de todas as entidades de um determinado tipo
     * do banco de dados.
     *
     * @param entityClass A classe da entidade.
     * @param <T> O tipo da entidade.
     * @return Uma lista contendo todas as entidades do tipo especificado.
     */
    public <T> List<T> getListEntity(Class<T> entityClass) {
        var tableName = entityClass.getSimpleName().toLowerCase() + "s";
        var JPQL = "SELECT c FROM " + tableName + " c";
        return em.createQuery(JPQL, entityClass).getResultList();
    }

}
