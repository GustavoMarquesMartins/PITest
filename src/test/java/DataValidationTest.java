import br.com.faculdade.imepac.infraestrutura.DataValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataValidationTest {

    @Test
    public void deveRetornarFalseQuandoCpfPassadoEInvalido(){
        var cpfInvalido = "12312312312";
        assertEquals(false, DataValidation.validaCpf(cpfInvalido));
    }
    @Test
    public void deveRetornarFalseQuandoRgPassadoEInvalido(){
        var rgInvalido = "12345678";
        assertEquals(false, DataValidation.validaRg(rgInvalido));
    }

}
