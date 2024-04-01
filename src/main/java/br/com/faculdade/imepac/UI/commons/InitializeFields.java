package br.com.faculdade.imepac.UI.commons;

import br.com.caelum.stella.type.Estado;
import br.com.faculdade.imepac.entidade.pessoa.EstadoCivil;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta classe fornece métodos para formatação de campos de texto, como CPF e
 * data de nascimento, e para adicionar os valores de um enum a um JComboBox.
 */
@NoArgsConstructor
@Data
public class InitializeFields {

    private final String formatacaoCpf = "###.###.###-##";
    private final String formatacaoNumeroCelular = "(##) 9######-##";
    private final String formatacaoCep = "#####-###";
    private final String formataDataNascimento = "##/##/####";

    private char charPadrao;

    /**
     * Formata um campo de texto com uma determinada formatação.
     *
     * @param jFormattedTextField O campo de texto a ser formatado.
     * @param formatacao A formatação desejada para o campo de texto.
     * @param placeHolder O caractere de espaço reservado na formatação.
     */
    public void formatarCampo(JFormattedTextField jFormattedTextField, String formatacao, char placeHolder) {
        try {
            MaskFormatter formatter = new MaskFormatter(formatacao);
            formatter.setPlaceholderCharacter(placeHolder); // Opcional: define o caractere de espaçamento
            formatter.install(jFormattedTextField); // Aplica o formatter ao JFormattedTextField
        } catch (Exception ex) {
            ex.printStackTrace(); // Lida com exceções de formatação inválida
        }
    }

    /**
     * Adiciona os valores de um enum a um JComboBox.
     *
     * @param comboBox O JComboBox ao qual os valores do enum serão adicionados.
     * @param enumClass A classe do enum.
     */
    public void adicionarValoresEnumNoComboBox(JComboBox comboBox, Class<? extends Enum> enumClass) {
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
