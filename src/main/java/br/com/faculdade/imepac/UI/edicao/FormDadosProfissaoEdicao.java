package br.com.faculdade.imepac.UI.edicao;

import br.com.faculdade.imepac.UI.commons.CommonMethods;
import br.com.faculdade.imepac.UI.commons.InitializeFields;
import br.com.faculdade.imepac.UI.commons.MaskFormatterFilter;
import br.com.faculdade.imepac.infraestrutura.Persistence;
import br.com.faculdade.imepac.entidade.pessoa.DadosProfissao;
import br.com.faculdade.imepac.entidade.pessoa.Funcionario;
import br.com.faculdade.imepac.entidade.pessoa.PeriodoDia;
import br.com.faculdade.imepac.entidade.projeto.Projeto;
import br.com.faculdade.imepac.entidade.relacionamento.Relacionamento;
import br.com.faculdade.imepac.infraestrutura.JPAUtil;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author gusta
 */
public class FormDadosProfissaoEdicao extends javax.swing.JPanel {

    private Funcionario funcionario;
    private JFrame frame;
    private Relacionamento relacionamento;

    /**
     * Creates new form FormDadosProfissao
     */
    public FormDadosProfissaoEdicao(Funcionario funcionario, JFrame frame, Relacionamento relacionamento) {
        this.relacionamento = relacionamento;
        this.frame = frame;
        this.funcionario = funcionario;
        initComponents();
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

        jLabelCadastroDeFuncionario1 = new javax.swing.JLabel();
        jLabelPeriodo = new javax.swing.JLabel();
        jComboBoxPeriodo = new javax.swing.JComboBox<>();
        jLabelCargo = new javax.swing.JLabel();
        jFormattedTextFieldSalario = new javax.swing.JFormattedTextField();
        jLabelSalario = new javax.swing.JLabel();
        jSpinnerCargaHoraria = new javax.swing.JSpinner();
        jLabelCargaHoaria = new javax.swing.JLabel();
        jCheckBoxVoluntario = new javax.swing.JCheckBox();
        jTextFieldCargo = new javax.swing.JTextField();
        jCheckBoxAcolhido = new javax.swing.JCheckBox();
        jButtonSalvar = new javax.swing.JButton();

        jLabelCadastroDeFuncionario1.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        jLabelCadastroDeFuncionario1.setText("Edição Dados profissão");

        jLabelPeriodo.setText("Período");

        jComboBoxPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelCargo.setText("Cargo");

        jFormattedTextFieldSalario.setName("FormattedFieldCpf"); // NOI18N
        jFormattedTextFieldSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldSalarioActionPerformed(evt);
            }
        });

        jLabelSalario.setText("Salário");

        jLabelCargaHoaria.setText("Carga Horária");

        jCheckBoxVoluntario.setText("Voluntário");
        jCheckBoxVoluntario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxVoluntarioActionPerformed(evt);
            }
        });

        jTextFieldCargo.setName("JTextFieldNome"); // NOI18N
        jTextFieldCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCargoActionPerformed(evt);
            }
        });

        jCheckBoxAcolhido.setText("Já foi acolhido");
        jCheckBoxAcolhido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAcolhidoActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCargo)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelSalario)
                                            .addComponent(jFormattedTextFieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(84, 84, 84)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSpinnerCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelCargaHoaria)
                                            .addComponent(jCheckBoxAcolhido))))
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBoxVoluntario))
                            .addComponent(jComboBoxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPeriodo)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabelCadastroDeFuncionario1)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabelCadastroDeFuncionario1)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelSalario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCargaHoaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabelCargo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxAcolhido)
                    .addComponent(jCheckBoxVoluntario))
                .addGap(18, 18, 18)
                .addComponent(jLabelPeriodo)
                .addGap(4, 4, 4)
                .addComponent(jComboBoxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldSalarioActionPerformed

    }//GEN-LAST:event_jFormattedTextFieldSalarioActionPerformed

    private void jCheckBoxVoluntarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxVoluntarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxVoluntarioActionPerformed

    private void jTextFieldCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCargoActionPerformed

    private void jCheckBoxAcolhidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAcolhidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxAcolhidoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBox jCheckBoxAcolhido;
    private javax.swing.JCheckBox jCheckBoxVoluntario;
    private javax.swing.JComboBox<String> jComboBoxPeriodo;
    private javax.swing.JFormattedTextField jFormattedTextFieldSalario;
    private javax.swing.JLabel jLabelCadastroDeFuncionario1;
    private javax.swing.JLabel jLabelCargaHoaria;
    private javax.swing.JLabel jLabelCargo;
    private javax.swing.JLabel jLabelPeriodo;
    private javax.swing.JLabel jLabelSalario;
    private javax.swing.JSpinner jSpinnerCargaHoraria;
    private javax.swing.JTextField jTextFieldCargo;
    // End of variables declaration//GEN-END:variables

    /**
     * Inicializa o formulário.
     */
    private void inicializaFormulario() {
        this.formataFields(); // Formata os campos de texto formatados
        this.initializeComboBoxOptions(); // Inicializa as opções dos ComboBox
        setOldValues();
        addActions(); // Verifica se o campo voluntário esta selecionado caso esteja ele bloqueia interação com o salário
        this.updateProfessionData();// Configura a ação do botão salvar
    }

    /**
     * Define os valores do funcionário com base nos campos do formulário.
     */
    public void setOldValues() {
        // Obtém os valores dos campos do formulário
        var value = funcionario.getDadosProfissao().getSalario();
        jFormattedTextFieldSalario.setValue(CommonMethods.removeSpecialCharacters(
                (value != null) ? value.toString() : "")
        );
        jTextFieldCargo.setText(funcionario.getDadosProfissao().getCargo());
        jSpinnerCargaHoraria.setValue(funcionario.getDadosProfissao().getCargaHoraria());
        jCheckBoxAcolhido.setSelected(funcionario.getDadosProfissao().isAcolhido());
        jCheckBoxVoluntario.setSelected(funcionario.getDadosProfissao().isVoluntario());
        jComboBoxPeriodo.setSelectedItem(funcionario.getDadosProfissao().getPeriodo());
    }

    /**
     * Formata os campos de texto formatados.
     */
    private void formataFields() {
        MaskFormatterFilter.formatTextField(jFormattedTextFieldSalario, "R$ #.###,##");
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 8, 1);
        jSpinnerCargaHoraria.setModel(model);
    }

    /**
     * Inicializa as opções dos ComboBox.
     */
    private void initializeComboBoxOptions() {
        var initializeComboBox = new InitializeFields();
        initializeComboBox.addEnumValuesToComboBox(jComboBoxPeriodo, PeriodoDia.class);

    }

    /**
     * Define os valores do funcionário com base nos campos do formulário.
     */
    public void setNewValues() throws Exception {
        var voluntario = jCheckBoxVoluntario.isSelected();
        var salario = CommonMethods.removeSpecialCharacters(jFormattedTextFieldSalario.getText());
        var cargo = jTextFieldCargo.getText();
        var cargaHorario = jSpinnerCargaHoraria.getValue();
        var acolhido = jCheckBoxVoluntario.isSelected();
        PeriodoDia periodoDia = (PeriodoDia) jComboBoxPeriodo.getSelectedItem();

        var dadosProfissao = new DadosProfissao();
        dadosProfissao.setAcolhido(acolhido);
        dadosProfissao.setVoluntario(voluntario);
        dadosProfissao.setSalario(salario);
        dadosProfissao.setCargo(cargo);
        dadosProfissao.setCargaHoraria(Integer.parseInt(cargaHorario.toString()));
        dadosProfissao.setAcolhido(acolhido);
        dadosProfissao.setPeriodo(periodoDia);
        dadosProfissao.setFuncionario(funcionario);
        funcionario.setDadosProfissao(dadosProfissao);
    }

    /**
     * Configura a ação do botão salvar.
     */
    public void updateProfessionData() {
        jButtonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EntityManager em = JPAUtil.getEntityManager();
                Persistence persistence = new Persistence(em); // Corrigindo a declaração da variável
                try {
                    setNewValues(); // Define os valores do funcionárioa 

                    em.getTransaction().begin();

                    if (relacionamento != null) {

                        if (funcionario.getRelacionamentos().size() != 0) {
                            var relacionamentos = funcionario.getRelacionamentos();
                            var relacionamentoAntigo = relacionamentos.get(relacionamentos.size() - 1);

                            relacionamentoAntigo.setDataTermino(LocalDate.now());

                            var projeto = persistence.getEntity(Projeto.class, relacionamentoAntigo.getProjeto().getId());
                            projeto.getRelacionamentos().add(relacionamento);
                            persistence.updateEntity(projeto);

                            persistence.updateEntity(relacionamentoAntigo);
                        }

                        persistence.save(relacionamento);
                        var relacionamentos = persistence.getListEntity(Relacionamento.class);
                        var ultimoRelacionamento = relacionamentos.get(relacionamentos.size() - 1);
                        funcionario.getRelacionamentos().add(ultimoRelacionamento);
                    }

                    persistence.updateEntity(funcionario); // Salva o funcionário no banco de dados

                    em.getTransaction().commit();
                    em.close();

                    JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    closePage();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro! " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
    }

    public void closePage() {
        this.setVisible(false);
    }

    public void blockInteraction() {
        jCheckBoxVoluntario.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    jFormattedTextFieldSalario.setEditable(false);
                    jFormattedTextFieldSalario.setDisabledTextColor(Color.GRAY);
                    jFormattedTextFieldSalario.setBackground(Color.LIGHT_GRAY);
                } else {
                    jFormattedTextFieldSalario.setEditable(true);
                    jFormattedTextFieldSalario.setDisabledTextColor(null);
                    jFormattedTextFieldSalario.setBackground(null);
                }
            }
        });
    }

    private void addActions() {
        blockInteraction();
    }
}
