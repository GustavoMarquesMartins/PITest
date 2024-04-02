package br.com.faculdade.imepac.UI.commons;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

/**
 * Esta classe fornece métodos para formatação de campos de texto, como CPF e
 * data de nascimento, e para adicionar os valores de um enum a um JComboBox.
 */
@NoArgsConstructor
@Data
public class InitializeFields {

    /**
     * Adiciona os valores de um enum a um JComboBox.
     *
     * @param comboBox  O JComboBox ao qual os valores do enum serão adicionados.
     * @param enumClass A classe do enum.
     */
    public void addEnumValuesToComboBox(JComboBox comboBox, Class<? extends Enum> enumClass) {
        // Limpa o comboBox antes de adicionar novos valores
        comboBox.removeAllItems();

        // Obtém os valores do Enum usando reflexão
        Enum<?>[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants != null) {
            for (Enum<?> enumConstant : enumConstants) {
                comboBox.addItem(enumConstant);
            }
        }
    }

    /**
     * Esta classe interna fornece métodos para formatar um campo de texto
     * utilizando um MaskFormatter.
     */
    public static class MaskFormatterFilter {

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
}
