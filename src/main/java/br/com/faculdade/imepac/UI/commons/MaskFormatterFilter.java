package br.com.faculdade.imepac.UI.commons;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

/**
 * Esta classe interna fornece métodos para formatar um campo de texto
 * utilizando um MaskFormatter.
 */
public class MaskFormatterFilter {

    // Caractere de espaço reservado padrão
    private static final char PLACEHOLDER_CHAR = '_';

    /**
     * Formata um JFormattedTextField de acordo com a máscara especificada.
     *
     * @param textField O JFormattedTextField a ser formatado.
     * @param mask      A máscara de formatação desejada.
     */
    public static void formatTextField(JFormattedTextField textField, String mask) {
        try {
            MaskFormatter formatter = createMaskFormatter(mask);
            configureTextFieldFormatter(textField, formatter);
        } catch (ParseException ex) {
            ex.printStackTrace(); // Lida com exceções de formatação inválida
        }
    }

    // Cria um MaskFormatter com a máscara especificada
    private static MaskFormatter createMaskFormatter(String mask) throws ParseException {
        MaskFormatter formatter = new MaskFormatter(mask);
        formatter.setPlaceholderCharacter(PLACEHOLDER_CHAR);
        formatter.setValueContainsLiteralCharacters(false); // Permite que o valor contenha caracteres literais
        return formatter;
    }

    // Configura o JFormattedTextField para usar o MaskFormatter
    private static void configureTextFieldFormatter(JFormattedTextField textField, MaskFormatter formatter) {
        textField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(formatter));
    }
}