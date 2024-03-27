import br.com.faculdade.imepac.entidade.pessoa.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FuncionarioEntidadeTest {
    private Funcionario funcionario;
    @BeforeEach
    public void setUp(){
        // Configura o ambiente de teste antes que cada metodo seja executado
        this.funcionario = new Funcionario();
    }
    @Test
    public void deveRetornarUmaStringSemCaracteresEspeciaisESemEspacamentoNoInicioENoFim(){
        //Verifica se o metodo setNome remove espacamento no inicio e fim de uma string ou caracter especial
        var nomeComEspacamentoECaracteresEspeciais = " 1 - Teste "; // Given-contexto
        this.funcionario.setNome(nomeComEspacamentoECaracteresEspeciais); // When-quando
        assertEquals("TESTE",funcionario.getNome()); //Then-despecho
    }
    @Test
    public void deveRetornarUmaExceptionQuandoCpfPassadoEInvalido() throws Exception {
        //Verifica se o metodo set para cpf retorna uma exception quando cpf passado e invalido
        assertThrows(Exception.class, () -> funcionario.setCpf("12312312312"));
    }
    @Test
    public void deveRetornarUmaExceptionQuandoRgPassadoEInvalido() throws Exception {
        //Verifica se o metodo set para rg retorna uma exception quando rg passado e invalido
        assertThrows(Exception.class, () -> funcionario.setRg("12345678"));
    }
}