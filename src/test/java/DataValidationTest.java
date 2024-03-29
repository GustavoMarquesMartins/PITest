import br.com.faculdade.imepac.data_utility.DataValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Classe de teste para a classe DataValidation, responsável por testar os métodos de validação de CPF, RG e CNH.
 */
public class DataValidationTest {

    /**
     * Testa o método validaCpf quando um CPF inválido é passado como parâmetro.
     */
    @Test
    public void deveRetornarFalseQuandoCpfPassadoEInvalido() {
        var cpfInvalido = "12312312312";
        assertEquals(false, DataValidation.validaCpf(cpfInvalido));
    }

    /**
     * Testa o método validaCpf quando um CPF válido é passado como parâmetro.
     */
    @Test
    public void deveRetornarTrueQuandoCpfPassadoEValido() {
        var cpfValido = "52998224725";
        assertEquals(true, DataValidation.validaCpf(cpfValido));
    }

    /**
     * Testa se o método validaCep da classe DataValidation retorna false quando um CEP inválido é passado.
     * Deve retornar false se o CEP fornecido não tiver exatamente 8 dígitos.
     */
    @Test
    public void deveRetornarFalseQuandoCepPassadoEInvalido() {
        var cepInvalido = "1234567";
        assertEquals(false, DataValidation.validaCep(cepInvalido));
    }

    /**
     * Testa se o método validaCep da classe DataValidation retorna true quando um CEP válido é passado.
     * Deve retornar true se o CEP fornecido tiver exatamente 8 dígitos.
     */
    @Test
    public void deveRetornarTrueQuandoCepPassadoEValido() {
        var cepValido = "12345678";
        assertEquals(true, DataValidation.validaCep(cepValido));
    }

    /**
     * Testa se o método validaNumeroCelular da classe DataValidation retorna false quando um número de celular inválido é passado.
     * Deve retornar false se o número de celular fornecido não tiver exatamente 11 dígitos.
     */
    @Test
    public void deveRetornarFalseQuandoNumeroCelularPassadoEInvalido() {
        var numeroCelularInvalido = "349924566456";
        assertEquals(false, DataValidation.validaNumeroCelular(numeroCelularInvalido));
    }

    /**
     * Testa se o método validaNumeroCelular da classe DataValidation retorna true quando um número de celular válido é passado.
     * Deve retornar true se o número de celular fornecido tiver exatamente 11 dígitos.
     */
    @Test
    public void deveRetornarTrueQuandoNumeroCelularPassadoEValido() {
        var CelularValido = "34991852282";
        assertEquals(true, DataValidation.validaNumeroCelular(CelularValido));
    }

    /**
     * Testa se o método validaEmail da classe DataValidation retorna false quando um endereço de e-mail inválido é passado.
     * Deve retornar false se o endereço de e-mail fornecido não estiver em um formato válido.
     */
    @Test
    public void deveRetornarFalseQuandoEmailPassadoEInvalido() {
        var emailInvalido = "_@gmail.";
        assertEquals(false, DataValidation.validaEmail(emailInvalido));
    }

    /**
     * Testa se o método validaEmail da classe DataValidation retorna true quando um endereço de e-mail válido é passado.
     * Deve retornar true se o endereço de e-mail fornecido estiver em um formato válido.
     */
    @Test
    public void deveRetornarTrueQuandoEmailPassadoEValido() {
        var emailValido = "teste@gmail.com";
        assertEquals(true, DataValidation.validaEmail(emailValido));
    }
}
