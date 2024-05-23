/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.faculdade.imepac.UI.cadastro;

import br.com.faculdade.imepac.UI.commons.CommonMethods;
import br.com.faculdade.imepac.UI.commons.MaskFormatterFilter;
import br.com.faculdade.imepac.infraestrutura.Persistence;
import br.com.faculdade.imepac.entidade.projeto.Projeto;
import br.com.faculdade.imepac.infraestrutura.JPAUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author visitante12
 */
public class FormProjeto extends javax.swing.JPanel {

    private Projeto projeto;
    private JFrame frame;

    /**
     * Creates new form FormProjeto
     */
    public FormProjeto(JFrame frame) {
        initComponents();
        this.frame = frame;
        this.projeto = new Projeto();
        inicializaFormulario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldServico = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextFieldCep = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPublicoAlvo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaJustificativa = new javax.swing.JTextArea();
        jLabelCadastroDeFuncionario1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaDescricao2 = new javax.swing.JTextArea();
        jFormattedTextFieldDataCriacao = new javax.swing.JFormattedTextField();
        jCheckBoxStatus = new javax.swing.JCheckBox();
        jButtonSalvar = new javax.swing.JButton();

        jLabel1.setText("Nome");

        jLabel2.setText("CEP");

        jLabel3.setText("Serviço");

        jLabel4.setText("Descrição");

        jLabel5.setText("Data criação");

        jLabel6.setText("Público alvo");

        jLabel7.setText("Justificativa");

        jTextAreaJustificativa.setColumns(20);
        jTextAreaJustificativa.setRows(5);
        jScrollPane1.setViewportView(jTextAreaJustificativa);

        jLabelCadastroDeFuncionario1.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        jLabelCadastroDeFuncionario1.setText("Cadastro Projeto");

        jTextAreaDescricao2.setColumns(20);
        jTextAreaDescricao2.setRows(5);
        jScrollPane3.setViewportView(jTextAreaDescricao2);

        jCheckBoxStatus.setText("Ativo");
        jCheckBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxStatusActionPerformed(evt);
            }
        });

        jButtonSalvar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/salvar.png"))); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setBorder(null);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCadastroDeFuncionario1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextFieldDataCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNome)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextFieldServico, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(88, 88, 88)
                                        .addComponent(jLabel5)))
                                .addGap(87, 87, 87)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1)
                            .addComponent(jTextFieldPublicoAlvo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxStatus))))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabelCadastroDeFuncionario1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldPublicoAlvo)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldDataCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jCheckBoxStatus))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxStatusActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBox jCheckBoxStatus;
    private javax.swing.JFormattedTextField jFormattedTextFieldCep;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataCriacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCadastroDeFuncionario1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaDescricao2;
    private javax.swing.JTextArea jTextAreaJustificativa;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPublicoAlvo;
    private javax.swing.JTextField jTextFieldServico;
    // End of variables declaration//GEN-END:variables

    public void setValues() throws Exception {
        // Obtém os valores dos campos do formulário
        String nome = jTextFieldNome.getText();
        String cep = CommonMethods.removeSpecialCharacters(jFormattedTextFieldCep.getText());
        String servico = jTextFieldServico.getText();
        LocalDate dataCriacao = CommonMethods.parseStringToLocalDate(jFormattedTextFieldDataCriacao.getText());
        String publicoAlvo = jTextFieldPublicoAlvo.getText();
        String justificativa = jTextAreaJustificativa.getText();
        String descricao = jTextAreaJustificativa.getText();
        boolean arquivado = jCheckBoxStatus.isSelected();

        projeto.setNome(nome);
        projeto.setCep(cep);
        projeto.setServico(servico);
        projeto.setDataCriacao(dataCriacao);
        projeto.setPublicoAlvo(publicoAlvo);
        projeto.setJustificativa(justificativa);
        projeto.setDescricao(descricao);
        projeto.setArquivado(arquivado);
    }

    /**
     * Formata os campos de texto formatados.
     */
    private void formatajFormattedTextFields() {
        MaskFormatterFilter.formatTextField(jFormattedTextFieldDataCriacao, "##/##/####");
        MaskFormatterFilter.formatTextField(jFormattedTextFieldCep, "#####-###");
    }

    public void inicializaFormulario() {
        formatajFormattedTextFields();
        saveProjeto();
    }

    public void saveProjeto() {

        jButtonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setValues();
                    EntityManager em = JPAUtil.getEntityManager();
                    Persistence ps = new Persistence(em);

                    em.getTransaction().begin();
                    ps.save(projeto);
                    em.getTransaction().commit();

                    JOptionPane.showMessageDialog(null, "Projeto salvo!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                    CommonMethods.goToNewPage(frame, new FormProjeto(frame));

                } catch (Exception error) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro! " + error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

    }
}
