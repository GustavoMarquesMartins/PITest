package br.com.faculdade.imepac.infraestrutura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * Classe utilitária para fornecer e gerenciar instâncias de EntityManager
 * para interação com o banco de dados.
 */
public class JPAUtil {

    /**
     * EntityManagerFactory para o ambiente de produção.
     */
    public static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("casa_de_davi");

    /**
     * EntityManagerFactory para o ambiente de teste.
     */
    public static final EntityManagerFactory FACTORYTEST = Persistence.createEntityManagerFactory("casa_de_davi_test");

    /**
     * Obtém um novo EntityManager para o ambiente de produção.
     *
     * @return EntityManager para interagir com o banco de dados de produção.
     */
    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

    /**
     * Obtém um novo EntityManager para o ambiente de teste.
     *
     * @return EntityManager para interagir com o banco de dados de teste.
     */
    public static EntityManager getEntityManagerTest() {
        return FACTORYTEST.createEntityManager();
    }

    /**
     * Fecha a conexão com o banco de dados de produção.
     * Este método deve ser chamado quando a aplicação estiver sendo desligada
     * ou quando não for mais necessário interagir com o banco de dados de produção.
     */
    public static void CloseConnection(){
        FACTORY.close();
    }
}
