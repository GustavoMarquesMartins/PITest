package br.com.faculdade.imepac.UI.commons;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

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
}
