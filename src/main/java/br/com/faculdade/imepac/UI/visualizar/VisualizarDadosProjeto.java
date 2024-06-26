/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.faculdade.imepac.UI.visualizar;

import br.com.faculdade.imepac.UI.edicao.*;
import br.com.faculdade.imepac.UI.commons.ActionManager;
import br.com.faculdade.imepac.UI.commons.CommonMethods;
import br.com.faculdade.imepac.UI.commons.InitializeFields;
import br.com.faculdade.imepac.data_utility.Mask;
import br.com.faculdade.imepac.infraestrutura.Persistence;
import br.com.faculdade.imepac.entidade.pessoa.Escolaridade;
import br.com.faculdade.imepac.entidade.pessoa.Raca;
import br.com.faculdade.imepac.entidade.pessoa.EstadoCivil;
import br.com.faculdade.imepac.entidade.pessoa.Funcionario;
import br.com.faculdade.imepac.entidade.pessoa.Genero;
import br.com.faculdade.imepac.entidade.pessoa.Habilidade;
import br.com.faculdade.imepac.entidade.projeto.Projeto;
import br.com.faculdade.imepac.entidade.relacionamento.Relacionamento;
import br.com.faculdade.imepac.infraestrutura.JPAUtil;
import java.awt.Desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * FormCadastro é uma classe que representa o formulário de cadastro de
 * funcionários.
 */
public class VisualizarDadosProjeto extends JPanel {

    private JFrame frame;
    private Projeto projeto;
    private Relacionamento relacionamentos;

    public VisualizarDadosProjeto(JFrame frame, Long id) {
        this.frame = frame;
        EntityManager em = JPAUtil.getEntityManager();
        Persistence ps = new Persistence(em);

        this.projeto = ps.getEntity(Projeto.class, id);

        initComponents(); // Inicializa os componentes do formulário 
        this.setOldValues();
        this.addActions();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jCheckBoxStatus = new javax.swing.JCheckBox();
        jLabelCor1 = new javax.swing.JLabel();
        jLabelCor2 = new javax.swing.JLabel();
        jLabelCor7 = new javax.swing.JLabel();
        jLabelCor10 = new javax.swing.JLabel();
        jLabelCor11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelCor18 = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelCep = new javax.swing.JLabel();
        jLabelDataCriacao = new javax.swing.JLabel();
        jLabelDescricao = new javax.swing.JLabel();
        jLabelPublicoAlvo = new javax.swing.JLabel();
        jLabelJustificativa = new javax.swing.JLabel();
        jLabelServico = new javax.swing.JLabel();
        jLabelCor12 = new javax.swing.JLabel();
        jButtonVerFuncionarios = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jLabel8.setText("Data de Nascimento");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel7.setText("CPF");

        jLabel9.setText("Nome");

        jLabel10.setText("RG");

        jLabel24.setText("CEP");

        jLabel26.setText("Número de celular");

        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField27ActionPerformed(evt);
            }
        });

        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });

        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });

        jLabel30.setText("Cor");

        jLabel27.setText("Dados profissão");

        jLabel23.setText("Gênero");

        jLabel25.setText("Carteira de trabalho");

        jLabel29.setText("Currículo");

        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });

        jLabel28.setText("E-mail");

        jTextField1.setText("jTextField1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jCheckBoxStatus.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jCheckBoxStatus.setText("Ativo");
        jCheckBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxStatusActionPerformed(evt);
            }
        });

        jLabelCor1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelCor1.setText("Nome:");

        jLabelCor2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelCor2.setText("Descrição:");

        jLabelCor7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelCor7.setText("Público alvo:");

        jLabelCor10.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelCor10.setText("Data criação:");

        jLabelCor11.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelCor11.setText("CEP:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        jLabel4.setText("Dados projeto:");

        jLabelCor18.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelCor18.setText("Justificativa:");

        jLabelNome.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelNome.setText("nome");

        jLabelCep.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelCep.setText("cep");

        jLabelDataCriacao.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelDataCriacao.setText("data criação");

        jLabelDescricao.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelDescricao.setText("descrição");

        jLabelPublicoAlvo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelPublicoAlvo.setText("público alvo");

        jLabelJustificativa.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelJustificativa.setText("justificativa");

        jLabelServico.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelServico.setText("serviço");

        jLabelCor12.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabelCor12.setText("Serviço:");

        jButtonVerFuncionarios.setBackground(new java.awt.Color(176, 101, 129));
        jButtonVerFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/funcionarios.png"))); // NOI18N
        jButtonVerFuncionarios.setText("Funcionarios");
        jButtonVerFuncionarios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonVerFuncionarios)
                    .addComponent(jCheckBoxStatus)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCor2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelDescricao))
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCor1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelNome))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCor11)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelCep)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelCor10)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelDataCriacao))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelCor7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelPublicoAlvo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelCor18)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelJustificativa))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelCor12)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelServico)))))))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCor1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNome))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCor11)
                            .addComponent(jLabelCep))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCor2)
                            .addComponent(jLabelDescricao)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCor10)
                            .addComponent(jLabelDataCriacao))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCor7)
                            .addComponent(jLabelPublicoAlvo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCor18)
                            .addComponent(jLabelJustificativa))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxStatus)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCor12)
                        .addComponent(jLabelServico)))
                .addGap(18, 18, 18)
                .addComponent(jButtonVerFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21ActionPerformed

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26ActionPerformed

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField27ActionPerformed

    private void jCheckBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVerFuncionarios;
    private javax.swing.JCheckBox jCheckBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCep;
    private javax.swing.JLabel jLabelCor1;
    private javax.swing.JLabel jLabelCor10;
    private javax.swing.JLabel jLabelCor11;
    private javax.swing.JLabel jLabelCor12;
    private javax.swing.JLabel jLabelCor18;
    private javax.swing.JLabel jLabelCor2;
    private javax.swing.JLabel jLabelCor7;
    private javax.swing.JLabel jLabelDataCriacao;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelJustificativa;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPublicoAlvo;
    private javax.swing.JLabel jLabelServico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables

    /**
     * Define os valores do funcionário com base nos campos do formulário.
     */
    public void setOldValues() {

        // Obtém os valores dos campos do formulário
        jLabelNome.setText(projeto.getNome());
        jLabelCep.setText(Mask.mascaraCep(projeto.getCep()));
        jLabelDescricao.setText(projeto.getDescricao());
        jCheckBoxStatus.setSelected(projeto.isArquivado());
        jCheckBoxStatus.setEnabled(false);

        // Cria um objeto DateTimeFormatter com o padrão desejado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Formata a data
        String formattedDate = formatter.format(projeto.getDataCriacao());

        jLabelDataCriacao.setText(formattedDate);
        jLabelPublicoAlvo.setText(projeto.getPublicoAlvo());
        jLabelJustificativa.setText(projeto.getJustificativa());
        jLabelServico.setText(projeto.getServico());
    }

    public void addActions() {
        jButtonVerFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (projeto.getRelacionamentos().size() != 0) {

                    DefaultTableModel modelo = new DefaultTableModel();

                    modelo.addColumn("Nome");
                    modelo.addColumn("Cpf");

                    for (Relacionamento relacionamento : projeto.getRelacionamentos()) {
                        if (relacionamento.getDataTermino() == null) {
                            modelo.addRow(new Object[]{relacionamento.getFuncionario().getNome(),
                                relacionamento.getFuncionario().getCpf()});
                        }
                    }

                    JTable table = new JTable(modelo);
                    JScrollPane scrollPane = new JScrollPane(table);

                    JFrame frame = new JFrame("Funcionários");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setSize(500, 300);
                    frame.add(scrollPane);
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Sem funcionários relacionados");
                }
            }

        }
        );

    }
}
