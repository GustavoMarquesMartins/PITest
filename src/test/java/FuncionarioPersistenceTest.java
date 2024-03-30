import br.com.faculdade.imepac.dao.Persistence;
import br.com.faculdade.imepac.entidade.pessoa.Funcionario;
import br.com.faculdade.imepac.infraestrutura.JPAUtil;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;


public class FuncionarioPersistenceTest {

    private static final EntityManager em = JPAUtil.getEntityManagerTest();
    private final Persistence ps = new Persistence(em);

    @BeforeAll
    public static void beforeAll() {
        em.getTransaction().begin();
    }

    @Test
    public void devePassarSemNehumaExceptionQuandoTentarSalvarFuncionario() {
        var funcionario = new Funcionario();
        this.ps.save(funcionario);
        Assertions.assertDoesNotThrow(() -> this.ps.save(funcionario));
    }

    @AfterAll
    public static void afterAll() {
        em.getTransaction().rollback();
        em.close();
    }
}
