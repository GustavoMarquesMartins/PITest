package br.com.faculdade.imepac.infraestrutura;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.util.regex.Pattern;

@Data
@AllArgsConstructor
public class DataValidation {

    /**
     * Verifica se o CPF fornecido é válido.
     *
     * @param cpf O número do CPF a ser validado.
     * @return true se o CPF for válido, false caso contrário.
     */
    public static boolean validaCpf(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(cpf);
        if (erros.size() > 0) {
            return false;
        }
        return true;
    }

    /**
     * Verifica se a string 'rg' contém apenas dígitos numéricos e possui no mínimo 9 caracteres.
     *
     * @param rg O número do RG a ser validado.
     * @return true se o RG for válido, false caso contrário.
     */
    public static boolean validaRg(String rg) {
        var valido = Pattern.matches("^\\d+$", rg);
        if ((!valido) || (rg.length() < 9)) {
            return false;
        }
        return true;
    }
}
