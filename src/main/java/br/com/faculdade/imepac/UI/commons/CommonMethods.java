package br.com.faculdade.imepac.UI.commons;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Esta classe fornece métodos utilitários comuns para interações com
 * componentes de interface de usuário.
 */
public class CommonMethods {

    /**
     * Remove caracteres especiais de uma string.
     *
     * @param originalText A string da qual os caracteres especiais serão
     * removidos.
     * @return A string sem caracteres especiais.
     */
    public static String removeSpecialCharacters(String originalText) {
        String string = originalText.replaceAll("[^0-9]", "");
        return string;
    }

    public static LocalDate parseStringToLocalDate(String dateString) throws Exception {
        String date = CommonMethods.removeSpecialCharacters(dateString);

        if (dateString == null || dateString.isEmpty()) {
            throw new IllegalArgumentException("Data é um campo obrigatório!");
        }

        if (date.length() != 8) {
            throw new IllegalArgumentException("Formato de data inválido! Use DD/MM/AAAA");
        }

        int dia = Integer.parseInt(date.substring(0, 2));
        int mes = Integer.parseInt(date.substring(2, 4));
        int ano = Integer.parseInt(date.substring(4, 8));

        try {
            return LocalDate.of(ano, mes, dia);
        } catch (Exception e) {
            throw new IllegalArgumentException("Data inválida! Verifique os valores de dia, mês e ano.");
        }
    }
}
