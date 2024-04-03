package br.com.faculdade.imepac.UI.commons;

import java.time.LocalDate;
import javax.swing.JTextField;

/**
 * Esta classe fornece métodos utilitários comuns para interações com
 * componentes de interface de usuário.
 */
public class CommonMethods {

    /**
     * Remove caracteres especiais de uma string.
     *
     * @param originalText A string da qual os caracteres especiais serão removidos.
     * @return A string sem caracteres especiais.
     */
    public static String removeSpecialCharacters(String originalText) {
        String string = originalText.replaceAll("[^0-9]", "");
        return string;
    }

    /**
     * Converte uma string no formato "DDMMYYYY" em um objeto LocalDate.
     *
     * @param dataString A string que representa a data no formato "DDMMYYYY".
     * @return Um objeto LocalDate representando a data especificada.
     * @throws Exception Se a string não estiver no formato correto ou se a data for inválida.
     */
    public static LocalDate parseStringToLocalDate(String dataString) throws Exception {
        String dataNascimento = CommonMethods.removeSpecialCharacters(dataString);
        if (dataNascimento.length() != 8) {
            throw new Exception("Data inválida");
        }
        int dia = Integer.parseInt(dataNascimento.substring(0, 2));
        int mes = Integer.parseInt(dataNascimento.substring(2, 4));
        int ano = Integer.parseInt(dataNascimento.substring(4, 8));
        return LocalDate.of(ano, mes, dia);
    }

}
