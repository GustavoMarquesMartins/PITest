package br.com.faculdade.imepac.UI.commons;

import br.com.faculdade.imepac.dao.Persistence;
import br.com.faculdade.imepac.entidade.pessoa.Escolaridade;
import br.com.faculdade.imepac.entidade.pessoa.Funcionario;
import br.com.faculdade.imepac.entidade.pessoa.Habilidade;
import br.com.faculdade.imepac.infraestrutura.JPAUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

/**
 * Esta classe fornece métodos para gerenciar ações de botões em interfaces de
 * usuário.
 */
@AllArgsConstructor
@NoArgsConstructor
public class ActionManager {

    private Funcionario funcionario;

    /**
     * Associa uma ação ao botão para adicionar um currículo ao funcionário
     * quando clicado.
     *
     * @param curriculumButton O botão ao qual a ação será associada.
     * @return O funcionário atualizado com o novo currículo adicionado.
     */
    public void addCurriculumButton(JButton curriculumButton) {
        curriculumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    String selectFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                    funcionario.setPathCurriculo(selectFilePath);
                }
            }
        });
    }

    public void addSkillButton(JButton skillButton, JTextField jTextFieldSkill) {
        skillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Habilidade skill = new Habilidade();
                skill.setHabilidade(jTextFieldSkill.getText());
                skill.setFuncionario(funcionario);
                jTextFieldSkill.setText("");
                funcionario.adicionarHabilidade(skill);
            }
        });
    }

    /**
     * Associa uma ação ao botão para adicionar uma carteira de trabalho ao
     * funcionário quando clicado.
     *
     * @param workcardButton O botão ao qual a ação será associada.
     * @return O funcionário atualizado com a nova carteira de trabalho
     * adicionada.
     */
    public void addWorkcardButton(JButton workcardButton) {
        workcardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    String selectFilePath = fileChooser.getSelectedFile().getAbsolutePath();
                    funcionario.setPathCarteiraDeTrabalho(selectFilePath);
                }
            }
        });
    }

}
