package br.com.faculdade.imepac.data_utility;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.InputMismatchException;
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
     * Valida um CEP verificando se ele possui exatamente 8 dígitos.
     *
     * @param cep O CEP a ser validado.
     * @return true se o CEP for válido (possuir exatamente 8 dígitos), caso contrário, false.
     */
    public static boolean validaCep(String cep) {
        boolean valido = Pattern.matches("^\\d{8}$", cep);
        if (!valido) {
            return false;
        }
        return true;
    }

    /**
     * Valida um número de celular verificando se ele possui exatamente 11 dígitos.
     *
     * @param numeroCelular O número de celular a ser validado.
     * @return true se o número de celular for válido (possuir exatamente 11 dígitos), caso contrário, false.
     */

    public static boolean validaNumeroCelular(String numeroCelular) {
        boolean valido = Pattern.matches("^\\d{2}9\\d{8}$", numeroCelular);
        if (!valido) {
            return false;
        }
        return true;
    }

    /**
     * Valida um endereço de e-mail verificando se está em um formato básico aceitável.
     *
     * @param email O endereço de e-mail a ser validado.
     * @return true se o endereço de e-mail estiver em um formato básico aceitável, caso contrário, false.
     */
    public static boolean validaEmail(String email) {
        boolean valido = Pattern.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.com)$", email);
        if (!valido) {
            return false;
        }
        return true;
    }
}
