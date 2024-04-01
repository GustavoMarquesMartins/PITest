import br.com.faculdade.imepac.data_utility.Mask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaskTest {
    /**
     * Testa se o método mascaraNome da classe Mask retorna o nome formatado corretamente.
     * Deve remover espaços em branco nas extremidades e converter o nome para letras maiúsculas.
     */
    @Test
    public void deveRetornarNomeComMascara() {
        var nomeSemMascara = " teste123 ";
        assertEquals("TESTE", Mask.formataNome(nomeSemMascara));
    }

    /**
     * Testa se o método mascaraCpf da classe Mask retorna o CPF formatado corretamente.
     * Deve adicionar a máscara padrão (###.###.###-##) ao CPF fornecido.
     */
    @Test
    public void deveRetornarCpfComMascara() {
        var cpfSemMascara = "12312312312";
        assertEquals("123.123.123-12", Mask.mascaraCpf(cpfSemMascara));
    }

    /**
     * Testa se o método mascaraCep da classe Mask retorna um CEP formatado corretamente.
     * Deve adicionar a máscara padrão (#####-###) ao CEP fornecido.
     */
    @Test
    public void deveRetornarCepComMascara() {
        var cepSemMascara = "12345678";
        assertEquals("12345-678", Mask.mascaraCep(cepSemMascara));
    }

    /**
     * Testa se o método mascaraNumeroCelular da classe Mask retorna um número de celular formatado corretamente.
     * Deve adicionar a máscara padrão ((XX) 9XXXX-XXXX) ao número de celular fornecido.
     */
    @Test
    public void deveRetornarNumeroCelularComMascara() {
        var cepSemMascara = "34991671190";
        assertEquals("(34) 99167-1190", Mask.mascaraNumeroCelular(cepSemMascara));
    }
}
