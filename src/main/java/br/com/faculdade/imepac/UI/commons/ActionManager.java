package br.com.faculdade.imepac.UI.commons;

import br.com.faculdade.imepac.entidade.pessoa.Funcionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Esta classe fornece métodos para gerenciar ações de botões em interfaces de usuário.
 */
public class ActionManager {

    private Funcionario funcionario = new Funcionario();

    /**
     * Associa uma ação ao botão para adicionar uma habilidade ao funcionário quando clicado.
     *
     * @param button O botão ao qual a ação será associada.
     * @param habilidade O campo de texto que contém a habilidade a ser adicionada.
     */
    public void buttonAdicionaHabilidade(JButton button, JTextField habilidade) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionario.adicionarHabilidade(habilidade.getText());
                CommonMethods.clearFields(habilidade);
            }
        });
    }
}
