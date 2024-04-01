package br.com.faculdade.imepac.UI.commons;

import javax.swing.JTextField;

/**
 * Esta classe fornece métodos utilitários comuns para interações com componentes de interface de usuário.
 */
public class CommonMethods {

    /**
     * Limpa o conteúdo de um campo de texto.
     *
     * @param field O campo de texto a ser limpo.
     */
    public static void clearFields(JTextField field) {
        field.setText("");
    }
}
