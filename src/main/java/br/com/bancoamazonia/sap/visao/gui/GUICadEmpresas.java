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
import br.com.bancoamazonia.sap.model.domein.Empresa;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author 14207
 */

public class GUICadEmpresas extends javax.swing.JInternalFrame {
    Empresa empresa;
    FormatarCampoLetras formatar = new FormatarCampoLetras();
    FormatarCampoNum formatarNum = new FormatarCampoNum();
    
    public GUICadEmpresas() {
        initComponents();
        tfNome.setDocument(new UpperCaseDocument());
        setFrameIcon(new ImageIcon(this.getClass().getResource("/imagem/iconeBasa.png")));
    }
    
    public void setPosicao(){
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation(15 + (d.width - this.getSize().width)/5, 15 +
                (d.height - this.getSize().height)/5);
    }
    
    public void btnSalvarEmpAddActionListener(ActionListener ouvinte) {
        btnSalvarEmp.addActionListener(ouvinte);
    }
    
    public Empresa getEmpresa() throws SapException {
        
        Empresa emp = new Empresa();
        if(tfCodConv.getText().equals("")){
            tfCodConv.requestFocus();
            throw new SapException("Informe o código do convênio.");
        }else{
            empresa.setCodConv(Integer.parseInt(tfCodConv.getText()));
        }
        
        String nome = tfNome.getText();
        if (nome == null || nome.trim().equals("")) {
            tfNome.requestFocus();
            throw new SapException("Informe o nome do convênio.");
        } else {
            empresa.setNome(nome);                        
        }   
                
        if (tfAgencia.getText().equals("   - ")) {
            tfAgencia.requestFocus();
            throw new SapException("Informe a agência do convênio.");
        } else {
            empresa.setAgencia(tfAgencia.getText());                        
        }  
        
        if (!tfPosto.getText().equals("")) {
            empresa.setPosto(Integer.parseInt(tfPosto.getText()));
        }
       
        if (tfContaCorrente.getText().equals("      - ")) {
            tfContaCorrente.requestFocus();
            throw new SapException("Informe o número da conta do convênio.");
        } else {
            empresa.setNumConta(tfContaCorrente.getText());                        
        }
        
        String cnpj = tfCnpj.getText();
        if (tfCnpj.getText().equals("   .   .   /    -  ")) {
            tfCnpj.requestFocus();
            throw new SapException("Informe o CNPJ do convênio.");
        } else {
            empresa.setCnpj(tfCnpj.getText());                        
        }
             
        return empresa;
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
    
    public void limparDados() {
        tfCodConv.setText(null);
        tfNome.setText(null);
        tfAgencia.setText(null);
        tfPosto.setText(null);
        tfContaCorrente.setText(null);
        tfCnpj.setText(null);
        
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        painelCadastroEmp = new javax.swing.JPanel();
        lblCodConv = new javax.swing.JLabel();
        tfCodConv = new FormatarCampoNum(6);
        btnConvConv = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        tfNome = new FormatarCampoLetras(50);
        new FormatarCampoLetras(50);
        lblAgencia = new javax.swing.JLabel();
        tfAgencia = new javax.swing.JFormattedTextField();
        btnNome = new javax.swing.JButton();
        btnAgencia = new javax.swing.JButton();
        lblPosto = new javax.swing.JLabel();
        tfPosto = new FormatarCampoNum(3);
        lblContaCorrente = new javax.swing.JLabel();
        tfContaCorrente = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblCnpj = new javax.swing.JLabel();
        tfCnpj = new javax.swing.JFormattedTextField();
        jLabelMsgObrigatorioNome = new javax.swing.JLabel();
        jLabelMsgObrigatorioAgencia = new javax.swing.JLabel();
        jLabelMsgObrigatorioContaCorrente = new javax.swing.JLabel();
        jLabelMsgObrigatorioCnpj = new javax.swing.JLabel();
        jLabelMsgObrigatorioCodConv = new javax.swing.JLabel();
        btnSalvarEmp = new javax.swing.JButton();
        btnLimparDados = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Convênios");
        setMaximumSize(new java.awt.Dimension(704, 307));
        setMinimumSize(new java.awt.Dimension(704, 307));
        setPreferredSize(new java.awt.Dimension(704, 307));

        desktopPane.setBackground(new java.awt.Color(255, 255, 255));

        painelCadastroEmp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));
        painelCadastroEmp.setToolTipText("");

        lblCodConv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCodConv.setText("Código do Convênio:");

        tfCodConv.setToolTipText("Código do Convênio. Somente Números");
        tfCodConv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodConvActionPerformed(evt);
            }
        });

        btnConvConv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8-binóculos-22 (2).png"))); // NOI18N
        btnConvConv.setToolTipText("Procurar Códigos de Convênios");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNome.setText("Nome:");

        tfNome.setToolTipText("Nome do Convênio");
        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        lblAgencia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAgencia.setText("Agência:");

        try {
            tfAgencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfAgencia.setToolTipText("Agência");

        btnNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8-binóculos-22 (2).png"))); // NOI18N
        btnNome.setToolTipText("Procurar Nome de Convênios");
        btnNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNomeActionPerformed(evt);
            }
        });

        btnAgencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8-binóculos-22 (2).png"))); // NOI18N
        btnAgencia.setToolTipText("Procurar Agências Existentes");

        lblPosto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPosto.setText("Posto:");

        tfPosto.setToolTipText("Posto do Convênio");
        tfPosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPostoActionPerformed(evt);
            }
        });

        lblContaCorrente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblContaCorrente.setText("Conta Corrente:");

        try {
            tfContaCorrente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfContaCorrente.setToolTipText("Número de Conta Corrente do Convênio");

        lblCnpj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCnpj.setText("CNPJ:");

        try {
            tfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCnpj.setToolTipText("CNPJ da Convêniada");
        tfCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCnpjActionPerformed(evt);
            }
        });

        jLabelMsgObrigatorioNome.setText("<html><font color=\"red\">*</font>");

        jLabelMsgObrigatorioAgencia.setText("<html><font color=\"red\">*</font>");

        jLabelMsgObrigatorioContaCorrente.setText("<html><font color=\"red\">*</font>");

        jLabelMsgObrigatorioCnpj.setText("<html><font color=\"red\">*</font>");

        jLabelMsgObrigatorioCodConv.setText("<html><font color=\"red\">*</font>");

        javax.swing.GroupLayout painelCadastroEmpLayout = new javax.swing.GroupLayout(painelCadastroEmp);
        painelCadastroEmp.setLayout(painelCadastroEmpLayout);
        painelCadastroEmpLayout.setHorizontalGroup(
            painelCadastroEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCadastroEmpLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(painelCadastroEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelCadastroEmpLayout.createSequentialGroup()
                        .addComponent(lblCodConv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMsgObrigatorioCodConv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(tfCodConv)
                        .addGap(0, 0, 0)
                        .addComponent(btnConvConv)
                        .addGap(221, 221, 221))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelCadastroEmpLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(painelCadastroEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCadastroEmpLayout.createSequentialGroup()
                                .addComponent(lblCnpj)
                                .addGap(23, 23, 23)
                                .addComponent(jLabelMsgObrigatorioCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCnpj)
                                .addGap(264, 264, 264))
                            .addGroup(painelCadastroEmpLayout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelMsgObrigatorioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNome)
                                .addGap(0, 0, 0)
                                .addComponent(btnNome))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCadastroEmpLayout.createSequentialGroup()
                                .addComponent(lblAgencia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelMsgObrigatorioAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(tfAgencia)
                                .addGap(0, 0, 0)
                                .addComponent(btnAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPosto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfPosto)
                                .addGap(18, 18, 18)
                                .addComponent(lblContaCorrente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelMsgObrigatorioContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(tfContaCorrente)))))
                .addGap(142, 142, 142))
            .addComponent(jSeparator1)
        );
        painelCadastroEmpLayout.setVerticalGroup(
            painelCadastroEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroEmpLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(painelCadastroEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConvConv, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelCadastroEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCodConv)
                        .addComponent(tfCodConv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelMsgObrigatorioCodConv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(painelCadastroEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelCadastroEmpLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(painelCadastroEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMsgObrigatorioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNome)))
                    .addComponent(btnNome, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(painelCadastroEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelCadastroEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAgencia)
                        .addComponent(tfAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelMsgObrigatorioAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelCadastroEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPosto)
                        .addComponent(tfPosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblContaCorrente)
                        .addComponent(tfContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelMsgObrigatorioContaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(painelCadastroEmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCnpj)
                    .addComponent(tfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMsgObrigatorioCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnSalvarEmp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalvarEmp.setIcon(new javax.swing.ImageIcon("C:\\Users\\14207\\Desktop\\imgSys\\salvar.png")); // NOI18N
        btnSalvarEmp.setText("Salvar");
        btnSalvarEmp.setToolTipText("Salvar Cadastro");
        btnSalvarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarEmpActionPerformed(evt);
            }
        });

        btnLimparDados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLimparDados.setIcon(new javax.swing.ImageIcon("C:\\Users\\14207\\Desktop\\imgSys\\limpardados.png")); // NOI18N
        btnLimparDados.setText("Limpar");
        btnLimparDados.setToolTipText("Limpar Campos de Cadastro");
        btnLimparDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparDadosActionPerformed(evt);
            }
        });

        desktopPane.setLayer(painelCadastroEmp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnSalvarEmp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnLimparDados, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addContainerGap(539, Short.MAX_VALUE)
                .addComponent(btnSalvarEmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimparDados)
                .addGap(11, 11, 11))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelCadastroEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(painelCadastroEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparDados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparDadosActionPerformed
        limparDados();
    }//GEN-LAST:event_btnLimparDadosActionPerformed

    private void btnSalvarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarEmpActionPerformed
        //        Empresa empresa = new Empresa();
        //        empresa.setCodConv(Integer.parseInt(tfCodConv.getText()));
        //        empresa.setNome(tfNome.getText());
        //        empresa.setAgencia(tfAgencia.getText());
        //        empresa.setPosto(Integer.parseInt(tfPosto.getText()));
        //        empresa.setNumConta(tfContaCorrente.getText());
        //        empresa.setCnpj(tfCnpj.getText());
        //        EmpresaJpaDAO.getInstance().merge(empresa);
        //        limparDados();
        //        JOptionPane.showMessageDialog(this, "Cadastro salvo com sucesso!!");
    }//GEN-LAST:event_btnSalvarEmpActionPerformed

    private void tfCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCnpjActionPerformed

    private void tfPostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPostoActionPerformed

    private void btnNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNomeActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

    private void tfCodConvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodConvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodConvActionPerformed

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
            java.util.logging.Logger.getLogger(GUICadEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUICadEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUICadEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUICadEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUICadEmpresas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgencia;
    private javax.swing.JButton btnConvConv;
    private javax.swing.JButton btnLimparDados;
    private javax.swing.JButton btnNome;
    private javax.swing.JButton btnSalvarEmp;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabelMsgObrigatorioAgencia;
    private javax.swing.JLabel jLabelMsgObrigatorioCnpj;
    private javax.swing.JLabel jLabelMsgObrigatorioCodConv;
    private javax.swing.JLabel jLabelMsgObrigatorioContaCorrente;
    private javax.swing.JLabel jLabelMsgObrigatorioNome;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAgencia;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblCodConv;
    private javax.swing.JLabel lblContaCorrente;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPosto;
    private javax.swing.JPanel painelCadastroEmp;
    private javax.swing.JFormattedTextField tfAgencia;
    private javax.swing.JFormattedTextField tfCnpj;
    private javax.swing.JTextField tfCodConv;
    private javax.swing.JFormattedTextField tfContaCorrente;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPosto;
    // End of variables declaration//GEN-END:variables

}
