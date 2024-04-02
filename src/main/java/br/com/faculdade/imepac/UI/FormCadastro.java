/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.faculdade.imepac.UI;

import br.com.caelum.stella.type.Estado;
import br.com.faculdade.imepac.UI.commons.ActionManager;
import br.com.faculdade.imepac.UI.commons.CommonMethods;
import br.com.faculdade.imepac.UI.commons.InitializeFields;
import br.com.faculdade.imepac.UI.commons.InitializeFields.MaskFormatterFilter;
import br.com.faculdade.imepac.dao.Persistence;
import br.com.faculdade.imepac.entidade.pessoa.Cor;
import br.com.faculdade.imepac.entidade.pessoa.EstadoCivil;
import br.com.faculdade.imepac.entidade.pessoa.Funcionario;
import br.com.faculdade.imepac.entidade.pessoa.Genero;
import br.com.faculdade.imepac.infraestrutura.JPAUtil;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat.ParseException;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author gusta
 */
public class FormCadastro extends javax.swing.JPanel {

    private JFrame frame;
    private Funcionario funcionario;

    /**
     * Creates new form FormCadastro
     */
    public FormCadastro(JFrame frame) {
        this.frame = frame;
        initComponents();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.inicializaFormulario();
    }

    private void inicializaFormulario() {
        this.funcionario = new Funcionario();
        this.addActions();
        this.formatajFormattedTextFields();
        this.initializeComboBoxOptions();
        this.saveFuncionario();
    }

    private void formatajFormattedTextFields() {
        MaskFormatterFilter.formatTextField(jFormattedTextFieldCpf, "###.###.###-##");
        MaskFormatterFilter.formatTextField(jFormattedTextFieldDataNascimento, "##/##/####");
        MaskFormatterFilter.formatTextField(jFormattedTextFieldCep, "#####-###");
        MaskFormatterFilter.formatTextField(jFormattedTextFieldNumeroCelular, "(##) #######-##");
    }

    private void initializeComboBoxOptions() {
        var initializeComboBox = new InitializeFields();
        initializeComboBox.addEnumValuesToComboBox(jComboBoxEstadoCivil, EstadoCivil.class);
        initializeComboBox.addEnumValuesToComboBox(jComboBoxCor, Cor.class);
        initializeComboBox.addEnumValuesToComboBox(jComboBoxGenero, Genero.class);
    }

    private void addActions() {
        ActionManager actionManager = new ActionManager(funcionario);
        actionManager.addSkillButton(jButtonHabilidade, jTextArea);
        actionManager.addCurriculumButtom(jButtonCurriculo);
        actionManager.addWorkcardButtom(jButtonCarteiraDeTrabalho);
    }

    public void getValues() {
        try {
            String nome = jTextFieldNome.getText();
            String rg = jTextFieldRg.getText();
            String cpf = CommonMethods.removeSpecialCharacters(jFormattedTextFieldCpf.getText());
            LocalDate dataNascimento = CommonMethods.parseStringToLocalDate(jFormattedTextFieldDataNascimento.getText());
            String cnh = jTextFieldCnh.getText();
            String mei = jTextFieldMei.getText();
            boolean status = jCheckBoxStatus.isSelected();
            EstadoCivil estadoCivil = (EstadoCivil) jComboBoxEstadoCivil.getSelectedItem();
            Cor cor = (Cor) jComboBoxCor.getSelectedItem();
            String cep = jFormattedTextFieldCep.getText();
            String numeroCelular = jFormattedTextFieldNumeroCelular.getText();
            String email = jTextFieldEmail.getText();

            this.funcionario.setNome(nome);
            this.funcionario.setRg(rg);
            this.funcionario.setCpf(cpf);
            this.funcionario.setDataNascimento(dataNascimento);
            this.funcionario.setCnh(cnh);
            this.funcionario.setStatus(status);
            this.funcionario.setEstadoCivil(estadoCivil);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveFuncionario() {
        jButtonSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getValues();
                EntityManager em = JPAUtil.getEntityManager();
                var persistence = new Persistence(em);
                em.getTransaction().begin();
                persistence.save(funcionario);
                em.getTransaction().commit();
                funcionario = new Funcionario();
                System.out.println("Funcionario Salvo com sucesso");
            }
        });
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
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldRg = new javax.swing.JTextField();
        jLabelRg = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        jLabelDataNascimento = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabelEstadoCivil = new javax.swing.JLabel();
        jTextFieldCnh = new javax.swing.JTextField();
        jLabelCnh = new javax.swing.JLabel();
        jTextFieldMei = new javax.swing.JTextField();
        jLabelMei = new javax.swing.JLabel();
        jLabelCep = new javax.swing.JLabel();
        jLabelCarteiraDeTrabalho = new javax.swing.JLabel();
        jLabelNumeroCelular = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jLabelCurriculo = new javax.swing.JLabel();
        jLabelCor = new javax.swing.JLabel();
        jLabelGenero = new javax.swing.JLabel();
        jLabelHabilidade = new javax.swing.JLabel();
        jFormattedTextFieldCpf = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDataNascimento = new javax.swing.JFormattedTextField();
        jCheckBoxStatus = new javax.swing.JCheckBox();
        jComboBoxEstadoCivil = new javax.swing.JComboBox<>();
        jButtonHabilidade = new javax.swing.JButton();
        jComboBoxCor = new javax.swing.JComboBox<>();
        jComboBoxGenero = new javax.swing.JComboBox<>();
        jFormattedTextFieldCep = new javax.swing.JFormattedTextField();
        jFormattedTextFieldNumeroCelular = new javax.swing.JFormattedTextField();
        jButtonCurriculo = new javax.swing.JButton();
        jButtonCarteiraDeTrabalho = new javax.swing.JButton();
        jLabelCadastroDeFuncionario = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jButtonSalvar = new javax.swing.JButton();

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

        jTextFieldNome.setName("JTextFieldNome"); // NOI18N
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jLabelNome.setText("Nome");
        jLabelNome.setName("JLabelNome"); // NOI18N

        jTextFieldRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRgActionPerformed(evt);
            }
        });

        jLabelRg.setText("RG");

        jLabelCpf.setText("CPF");

        jLabelDataNascimento.setText("Data de nascimento");

        jLabelStatus.setText("Status");

        jLabelEstadoCivil.setText("Estado civil");

        jTextFieldCnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCnhActionPerformed(evt);
            }
        });

        jLabelCnh.setText("CNH");

        jLabelMei.setText("MEI");

        jLabelCep.setText("CEP");

        jLabelCarteiraDeTrabalho.setText("Carteira de trabalho");

        jLabelNumeroCelular.setText("Número de celular");

        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        jLabelEmail.setText("E-mail");

        jLabelCurriculo.setText("Currículo");

        jLabelCor.setText("Cor");

        jLabelGenero.setText("Gênero");

        jLabelHabilidade.setText("Habilidades");

        jFormattedTextFieldCpf.setName("FormattedFieldCpf"); // NOI18N
        jFormattedTextFieldCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldCpfActionPerformed(evt);
            }
        });

        jFormattedTextFieldDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDataNascimentoActionPerformed(evt);
            }
        });

        jCheckBoxStatus.setText("Ativo");
        jCheckBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxStatusActionPerformed(evt);
            }
        });

        jComboBoxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEstadoCivil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadoCivilActionPerformed(evt);
            }
        });

        jButtonHabilidade.setText("Adicionar");

        jComboBoxCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jFormattedTextFieldCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldCepActionPerformed(evt);
            }
        });

        jButtonCurriculo.setText("Buscar");

        jButtonCarteiraDeTrabalho.setText("Buscar");

        jLabelCadastroDeFuncionario.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        jLabelCadastroDeFuncionario.setText("Cadastro de Funcionário");

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane2.setViewportView(jTextArea);

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
                        .addGap(278, 278, 278)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMei)
                            .addComponent(jTextFieldMei, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jFormattedTextFieldDataNascimento, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNome, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDataNascimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(189, 189, 189)
                                        .addComponent(jLabelStatus))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(186, 186, 186)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonHabilidade)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelHabilidade)
                                            .addComponent(jCheckBoxStatus)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(153, 153, 153))))
                            .addComponent(jLabelCnh)
                            .addComponent(jTextFieldCnh, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabelCep)
                                            .addComponent(jFormattedTextFieldCep)
                                            .addComponent(jLabelNumeroCelular)
                                            .addComponent(jFormattedTextFieldNumeroCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelRg)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldRg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                        .addComponent(jFormattedTextFieldCpf, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabelCpf))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEmail)
                                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonCurriculo)
                                            .addComponent(jLabelCurriculo))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelCarteiraDeTrabalho)
                                            .addComponent(jButtonCarteiraDeTrabalho)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelCor))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelGenero)
                                            .addComponent(jComboBoxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelEstadoCivil)))))
                            .addComponent(jLabelCadastroDeFuncionario))))
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabelCadastroDeFuncionario)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jTextFieldRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelEstadoCivil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelGenero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelCep)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelNumeroCelular)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextFieldNumeroCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelCurriculo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonCurriculo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelCarteiraDeTrabalho)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonCarteiraDeTrabalho))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(jLabelRg))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(96, 96, 96)
                                    .addComponent(jLabelCpf)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jFormattedTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jFormattedTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelDataNascimento)
                                    .addComponent(jLabelStatus))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxStatus)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCnh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelMei)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldMei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelHabilidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonHabilidade)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButtonSalvar)
                .addGap(26, 26, 26))
        );

        jTextFieldNome.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextFieldCnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCnhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCnhActionPerformed

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

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

    private void jFormattedTextFieldCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCpfActionPerformed

    }//GEN-LAST:event_jFormattedTextFieldCpfActionPerformed

    private void jTextFieldRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRgActionPerformed
    }//GEN-LAST:event_jTextFieldRgActionPerformed

    private void jFormattedTextFieldDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldDataNascimentoActionPerformed

    private void jCheckBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxStatusActionPerformed

    private void jComboBoxEstadoCivilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoCivilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEstadoCivilActionPerformed

    private void jFormattedTextFieldCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldCepActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCarteiraDeTrabalho;
    private javax.swing.JButton jButtonCurriculo;
    private javax.swing.JButton jButtonHabilidade;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JCheckBox jCheckBoxStatus;
    private javax.swing.JComboBox<String> jComboBoxCor;
    private javax.swing.JComboBox<String> jComboBoxEstadoCivil;
    private javax.swing.JComboBox<String> jComboBoxGenero;
    private javax.swing.JFormattedTextField jFormattedTextFieldCep;
    private javax.swing.JFormattedTextField jFormattedTextFieldCpf;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataNascimento;
    private javax.swing.JFormattedTextField jFormattedTextFieldNumeroCelular;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCadastroDeFuncionario;
    private javax.swing.JLabel jLabelCarteiraDeTrabalho;
    private javax.swing.JLabel jLabelCep;
    private javax.swing.JLabel jLabelCnh;
    private javax.swing.JLabel jLabelCor;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelCurriculo;
    private javax.swing.JLabel jLabelDataNascimento;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEstadoCivil;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelHabilidade;
    private javax.swing.JLabel jLabelMei;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNumeroCelular;
    private javax.swing.JLabel jLabelRg;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea;
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
    private javax.swing.JTextField jTextFieldCnh;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldMei;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldRg;
    // End of variables declaration//GEN-END:variables

}
