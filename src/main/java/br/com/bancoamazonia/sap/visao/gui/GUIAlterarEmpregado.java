/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.visao.gui;

import br.com.bancoamazonia.sap.FormatarCampoLetras;
import br.com.bancoamazonia.sap.FormatarCampoNum;
import br.com.bancoamazonia.sap.UpperCaseDocument;
import br.com.bancoamazonia.sap.exception.SapException;
import br.com.bancoamazonia.sap.model.domein.Empregado;
import br.com.bancoamazonia.sap.model.domein.constante.EstadoEnum;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.validation.ConstraintViolationException;
import javax.swing.JComboBox;

/**
 *
 * @author 14207
 */
public class GUIAlterarEmpregado extends javax.swing.JInternalFrame {
    Empregado empregado;
    private Long idEmpregado;
    FormatarCampoLetras formatLetras = new FormatarCampoLetras();
    FormatarCampoNum formatNum = new FormatarCampoNum();
    Object[] lista = null;
    
    public GUIAlterarEmpregado() {
        EstadoEnum e = EstadoEnum.PA;
        lista = e.values();
        
        initComponents();
        
        tfCodEmp.setDocument(new UpperCaseDocument());
        tfNome.setDocument(new UpperCaseDocument());
        tfAgencia.setDocument(new UpperCaseDocument());
        tfPosto.setDocument(new UpperCaseDocument());
        tfNumConta.setDocument(new UpperCaseDocument());
        tfCpf.setDocument(new UpperCaseDocument());
        tfSalario.setDocument(new UpperCaseDocument());
        tfEndereco.setDocument(new UpperCaseDocument());
        tfNumero.setDocument(new UpperCaseDocument());
        tfCidade.setDocument(new UpperCaseDocument());
        tfBairro.setDocument(new UpperCaseDocument());
        tfComplemento.setDocument(new UpperCaseDocument());
        tfCep.setDocument(new UpperCaseDocument());      
        setFrameIcon(new ImageIcon(this.getClass().getResource("/imagem/iconeBasa.png")));
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    
    public void exibirDados(){
    limparDados();
        tfCodEmp.setText("" + empregado.getCodEmp());
        tfNome.setText(empregado.getNome());
        tfAgencia.setText(empregado.getAgencia());
        tfPosto.setText("" + empregado.getPosto());
        tfNumConta.setText(empregado.getNumConta());
        tfCpf.setText(empregado.getCpf());
        
        tfSalario.setText("" + empregado.getSalario());
        
        tfEndereco.setText(empregado.getEndereco());
        tfComplemento.setText(empregado.getComplemento());
        tfCidade.setText(empregado.getCidade());
        tfNumero.setText("" + empregado.getNumero());
        tfCep.setText(empregado.getCep());
        tfBairro.setText(empregado.getBairro());
        cbEstado.setSelectedItem(empregado.getEstado());
    }
    
    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
        idEmpregado = empregado.getId();
        this.exibirDados();
    }
    
    public void limparDados(){
        tfCodEmp.setText(null);
        tfNome.setText(null);
        tfAgencia.setText(null);
        tfPosto.setText(null);
        tfNumConta.setText(null);
        tfCpf.setText(null);
        tfSalario.setText(null);
        tfEndereco.setText(null);
        tfComplemento.setText(null);
        tfCidade.setText(null);
        tfNumero.setText(null);
        tfCep.setText(null);
        tfBairro.setText(null);
        cbEstado.setSelectedItem(EstadoEnum.SELECIONE);
    }
    
    public void btnSalvarEmpregadoAddActionListener(ActionListener ouvinte){
        btnSalvar.addActionListener(ouvinte);
    }
    
    public Empregado getEmpregado() throws SapException{
        Empregado empregado = new Empregado();
        empregado.setId(idEmpregado);
        if(tfCodEmp.getText().equals("")){
            tfCodEmp.requestFocus();
            throw new SapException("Informe o código do empregado!");
        }else{
            try{
                empregado.setCodEmp(Integer.parseInt(tfCodEmp.getText()));
            }catch(ConstraintViolationException ex){
                if(ex.getMessage().trim().startsWith("Entrada Duplicada")){
                    throw new SapException("Código do empregado já existe!");
                }else{
                    throw new SapException("Erro ao salvar cadastro!");
                 
                }
            }    
        }
        
        String nome = tfNome.getText();
        if(nome == null || nome.trim().equals("")){
            tfNome.requestFocus();
            throw new SapException("Informe o nome do empregado!");
        }else{
            empregado.setNome(tfNome.getText());
        }
        
        if(tfAgencia.getText().equals("   - ")){
            tfAgencia.requestFocus();
            throw new SapException("Informe a agência do empregado!");
        }else{
            empregado.setAgencia(tfAgencia.getText());
        }
        
        if (!tfPosto.getText().equals("")) {
            empregado.setPosto(Integer.parseInt(tfPosto.getText()));
        }  
        
        if(tfNumConta.getText().equals("      - ")){
            tfNumConta.requestFocus();
            throw new SapException("Informe o número da conta do empregado!");
        }else{
            empregado.setNumConta(tfNumConta.getText());
        }
        
        if(tfSalario.getText().equals("")){
            tfSalario.requestFocus();
            throw new SapException("Informe o salário do empregado");
        }else{
            NumberFormat nf = NumberFormat.getInstance();
            try {
                empregado.setSalario(nf.parse(tfSalario.getText().replaceAll("[aA-zZ$]", "")).doubleValue());
            } catch (ParseException ex) {
                Logger.getLogger(GUIDadosEmpregado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(tfCpf.getText().equals("   .   .   -  ")){
            tfCpf.requestFocus();
            throw new SapException("Informe o cpf do empregado!");
        }else{
            empregado.setCpf(tfCpf.getText());
        }
        
        empregado.setEndereco(tfEndereco.getText());
        
        if (!tfNumero.getText().equals("")) {
            empregado.setNumero(Integer.parseInt(tfNumero.getText()));
        }
        
        empregado.setCep(tfCep.getText());
        empregado.setComplemento(tfComplemento.getText());
        empregado.setBairro(tfBairro.getText());
        empregado.setCidade(tfCidade.getText());
        empregado.setEstado((EstadoEnum) cbEstado.getSelectedItem());  
        
        return empregado;
    }
    
    public void showMensagem(String mensagem, boolean isErro) {
        if (isErro) {
            JOptionPane.showMessageDialog(null,
                    mensagem,
                    "Mensagem de erro",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    mensagem,
                    "Mensagem de sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }   
    
    public EstadoEnum[] listaEstados(){
        return EstadoEnum.values();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        btnSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblCodEmp = new javax.swing.JLabel();
        tfCodEmp = new FormatarCampoNum(6);
        btnProcurarCodEmp = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        tfNome = new FormatarCampoLetras(50);
        jButton2 = new javax.swing.JButton();
        lblAgencia = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblPosto = new javax.swing.JLabel();
        tfPosto = new FormatarCampoNum(3);
        jLabel1 = new javax.swing.JLabel();
        tfEndereco = new FormatarCampoLetras(50);
        jLabel2 = new javax.swing.JLabel();
        tfComplemento = new FormatarCampoLetras(50);
        jLabel3 = new javax.swing.JLabel();
        tfCidade = new FormatarCampoLetras(50);
        jLabel4 = new javax.swing.JLabel();
        tfNumero = new FormatarCampoNum(4);
        jLabel7 = new javax.swing.JLabel();
        tfBairro = new FormatarCampoLetras(50);
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblConta = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        tfAgencia = new javax.swing.JFormattedTextField();
        tfNumConta = new javax.swing.JFormattedTextField();
        tfCpf = new javax.swing.JFormattedTextField();
        tfSalario = new javax.swing.JFormattedTextField();
        tfCep = new javax.swing.JFormattedTextField();
        cbEstado = new javax.swing.JComboBox<>(lista);
        btnLimparDados = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setForeground(java.awt.Color.red);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Alterar Dados do Empregado");
        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(605, 391));
        setMinimumSize(new java.awt.Dimension(605, 391));

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\14207\\Desktop\\imgSys\\salvar.png")); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("Salvar Alterações");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Empregado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        lblCodEmp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCodEmp.setText("Código do Empregado:");

        tfCodEmp.setToolTipText("");

        btnProcurarCodEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8-binóculos-22 (2).png"))); // NOI18N
        btnProcurarCodEmp.setToolTipText("Procurar Empregados por Código");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNome.setText("Nome:");

        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8-binóculos-22 (2).png"))); // NOI18N
        jButton2.setToolTipText("Procurar Empregados por Nome");

        lblAgencia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAgencia.setText("Agência");

        lblCpf.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCpf.setText("CPF:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8-binóculos-22 (2).png"))); // NOI18N
        jButton1.setToolTipText("Procurar Agências Existentes");

        lblPosto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPosto.setText("Posto:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Endereço:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Complemento:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Cidade");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Número:");

        jLabel7.setText("CEP:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Bairro:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Estado:");

        lblConta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblConta.setText("Conta:");

        lblSalario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSalario.setText("Salário:");

        try {
            tfAgencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfAgencia.setToolTipText("Agência com Dígito");
        tfAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAgenciaActionPerformed(evt);
            }
        });

        try {
            tfNumConta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tfSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        tfSalario.setText("R$");

        try {
            tfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(lblCodEmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCodEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnProcurarCodEmp)
                .addGap(182, 182, 182))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAgencia))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(lblCpf)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfCidade)
                                    .addComponent(tfEndereco, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfComplemento, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(42, 42, 42))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfCpf, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jButton1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSalario)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(lblPosto))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEstado, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfBairro)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfPosto, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblConta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfNumConta, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfSalario, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfNome)
                        .addGap(0, 0, 0)
                        .addComponent(jButton2)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProcurarCodEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCodEmp)
                        .addComponent(tfCodEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNome)))
                        .addGap(20, 20, 20)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAgencia)
                            .addComponent(tfAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPosto)
                            .addComponent(lblConta)
                            .addComponent(tfNumConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfPosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalario)
                    .addComponent(lblCpf)
                    .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnLimparDados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLimparDados.setIcon(new javax.swing.ImageIcon("C:\\Users\\14207\\Desktop\\imgSys\\limpardados.png")); // NOI18N
        btnLimparDados.setText("Limpar");
        btnLimparDados.setToolTipText("Limpar Campos");
        btnLimparDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparDadosActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(btnSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnLimparDados, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimparDados)
                .addGap(18, 18, 18))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparDados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparDadosActionPerformed
        limparDados();
    }//GEN-LAST:event_btnLimparDadosActionPerformed

    private void tfAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAgenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAgenciaActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIAlterarEmpregado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIAlterarEmpregado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIAlterarEmpregado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIAlterarEmpregado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIAlterarEmpregado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimparDados;
    private javax.swing.JButton btnProcurarCodEmp;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<Object> cbEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAgencia;
    private javax.swing.JLabel lblCodEmp;
    private javax.swing.JLabel lblConta;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPosto;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JFormattedTextField tfAgencia;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfCodEmp;
    private javax.swing.JTextField tfComplemento;
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JFormattedTextField tfNumConta;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfPosto;
    private javax.swing.JFormattedTextField tfSalario;
    // End of variables declaration//GEN-END:variables
}
