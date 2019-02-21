/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.visao.gui;

import br.com.bancoamazonia.sap.FormatarCampoLetras;
import javax.swing.ImageIcon;
import br.com.bancoamazonia.sap.FormatarCampoNum;
import br.com.bancoamazonia.sap.UpperCaseDocument;
import br.com.bancoamazonia.sap.exception.SapException;
import br.com.bancoamazonia.sap.model.domein.Empresa;
import br.com.bancoamazonia.sap.visao.ouvinte.OuvinteDeGUIAlterarEmpresa;
import br.com.bancoamazonia.sap.visao.ouvinte.OuvinteDeGUICadEmpresas;
import java.awt.Dimension;
import java.util.List;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 14207
 */
public class GUIEmpresas extends javax.swing.JInternalFrame {
    private List lista;
    private List empresas;
    Empresa empresa;
    GUICadEmpresas guiCadEmpresas;
    FormatarCampoLetras formatar = new FormatarCampoLetras();
    FormatarCampoNum formatarNum = new FormatarCampoNum();
    GUIAlterarEmpresa guiAlterarEmpresa;
    
    public GUIEmpresas() {
        initComponents();
        setFrameIcon(new ImageIcon(this.getClass().getResource("/imagem/iconeBasa.png")));
        tfNome.setDocument(new UpperCaseDocument());
    }
        
    public void setPosicao(){
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width)/2, (d.height - this.getSize().height)/2);
    }
    
     public void limparDados(){
        tfCodConv.setText(null);
        tfNome.setText(null);
    }
     
    public void limparTabela(){
        while (tEmpresas.getModel().getRowCount() > 0) {  
           ((DefaultTableModel) tEmpresas.getModel()).removeRow(0);  
        }
    }
   
    public void exibirEmpresas(List<Empresa> lista){
        this.lista = lista;
        String titulos[] = {"Cod Convênio", "Nome", "Agência", "Posto", "Conta Corrente", "CNPJ"};
        DefaultTableModel model = (DefaultTableModel) tEmpresas.getModel();
        this.removerLinhasDaTabela(model);
        
        Object objts[][] = new Object[lista.size()][6];
        Iterator resultado = lista.iterator();
        int controle = 0;
        while (resultado.hasNext()) {
            Empresa next = (Empresa) resultado.next();
            System.out.println(next.toString());
            objts[controle] = next.array();
            System.out.println(controle);
            controle++;
        }
        model.setDataVector(objts, titulos);
    }
          
    private void removerLinhasDaTabela(DefaultTableModel model) {
        while (model.getRowCount() > 0) {
            int ultimaLinha = model.getRowCount() - 1;
            model.removeRow(ultimaLinha);
        }
    }
     
    public void exibirMensagem(String mensagem, String titulo, boolean isErro) {
        int tipo;
        if (isErro) {
            tipo = JOptionPane.ERROR_MESSAGE;
        } else {
            tipo = JOptionPane.INFORMATION_MESSAGE;
        }
        JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
    }
   
    public Empresa getEmpresa() throws SapException {
        Empresa empresa = null;
        int linhaSelecionada = tEmpresas.getSelectedRow();
        if (linhaSelecionada < 0) {
            throw new SapException("Não foi selecionado nenhum registro");
        }
        empresa = (Empresa) this.lista.get(linhaSelecionada);
        
        return empresa;
    }
    
    public void btnPesquisarEmpresaAddActionListener(ActionListener ouvinte){
        btnPesquisarEmpresa.addActionListener(ouvinte);
    }
    
    public void btnExcluirEmpresaActionListener(ActionListener ouvinte){
        btnExcluir.addActionListener(ouvinte);
    }
       
    public int pedirConfirmacao(String mensagem, String titulo, int tipo) {
        int resposta = JOptionPane.showConfirmDialog(null, mensagem, titulo, tipo);
        return resposta;
    }
    
    public String getNome(){
        return tfNome.getText();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        lblCodConv = new javax.swing.JLabel();
        tfCodConv = new FormatarCampoNum(6);
        jLabel1 = new javax.swing.JLabel();
        tfNome = new FormatarCampoLetras(50);
        ;
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnPesquisarEmpresa = new javax.swing.JButton();
        limparDados = new javax.swing.JButton();
        btnNovoConv = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tEmpresas = new javax.swing.JTable();
        btnLimparTabela = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Convênios");
        setMaximumSize(new java.awt.Dimension(805, 533));
        setMinimumSize(new java.awt.Dimension(805, 533));
        setPreferredSize(new java.awt.Dimension(805, 533));

        desktopPane.setBackground(new java.awt.Color(255, 255, 255));
        desktopPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), null, null));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(220, 220, 220), null, null));

        lblCodConv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCodConv.setText("Código do Convênio:");

        tfCodConv.setToolTipText("Código do Convênio. Somente Números");
        tfCodConv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodConvActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nome:");

        tfNome.setToolTipText("Nome da Empresa");
        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8-binóculos-22 (2).png"))); // NOI18N
        jButton3.setToolTipText("Procurar Convênio Pelo Código Cadastrado");
        jButton3.setMaximumSize(new java.awt.Dimension(55, 20));
        jButton3.setMinimumSize(new java.awt.Dimension(55, 20));
        jButton3.setPreferredSize(new java.awt.Dimension(55, 20));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8-binóculos-22 (2).png"))); // NOI18N
        jButton4.setToolTipText("Procurar Convênios Pelo Nome Cadastrado");
        jButton4.setMaximumSize(new java.awt.Dimension(55, 20));
        jButton4.setMinimumSize(new java.awt.Dimension(55, 20));
        jButton4.setPreferredSize(new java.awt.Dimension(55, 20));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblCodConv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCodConv)
                .addGap(0, 0, 0)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome)
                .addGap(0, 0, 0)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCodConv)
                        .addComponent(tfCodConv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnPesquisarEmpresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPesquisarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8-pesquisar-22 (1).png"))); // NOI18N
        btnPesquisarEmpresa.setText("Pesquisar");
        btnPesquisarEmpresa.setToolTipText("Pesquisar Convênios");
        btnPesquisarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarEmpresaActionPerformed(evt);
            }
        });

        limparDados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        limparDados.setIcon(new javax.swing.ImageIcon("C:\\Users\\14207\\Desktop\\imgSys\\limpardados.png")); // NOI18N
        limparDados.setText("Limpar");
        limparDados.setToolTipText("Limpar Dados de Pesquisa");
        limparDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparDadosActionPerformed(evt);
            }
        });

        btnNovoConv.setBackground(new java.awt.Color(204, 204, 204));
        btnNovoConv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNovoConv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Adicionar.png"))); // NOI18N
        btnNovoConv.setText("Novo Convênio");
        btnNovoConv.setToolTipText("Cadastrar Novo Convênio");
        btnNovoConv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoConvActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon("C:\\Users\\14207\\Desktop\\imgSys\\delete.png")); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setToolTipText("Excluir registro Selecionado na Tabela");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tEmpresas.setBackground(new java.awt.Color(204, 204, 204));
        tEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cod Convênio", "Nome", "Agência", "Posto", "Conta Corrente", "CNPJ"
            }
        ));
        tEmpresas.setToolTipText("Tabela de Registros de Convênios");
        tEmpresas.setGridColor(new java.awt.Color(204, 204, 204));
        tEmpresas.setShowHorizontalLines(false);
        tEmpresas.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tEmpresas);

        btnLimparTabela.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLimparTabela.setIcon(new javax.swing.ImageIcon("C:\\Users\\14207\\Desktop\\imgSys\\limpardados.png")); // NOI18N
        btnLimparTabela.setText("Limpar Tabela");
        btnLimparTabela.setToolTipText("Limpar Dados na Tabela");
        btnLimparTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparTabelaActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Editar.png"))); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setToolTipText("Alterar Registro Selecionado na Tabela");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        desktopPane.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnPesquisarEmpresa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(limparDados, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnNovoConv, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnExcluir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnLimparTabela, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnAlterar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPesquisarEmpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limparDados))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopPaneLayout.createSequentialGroup()
                        .addComponent(btnLimparTabela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                        .addComponent(btnNovoConv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)))
                .addContainerGap())
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(limparDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPesquisarEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimparTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNovoConv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparTabelaActionPerformed
        limparTabela();
    }//GEN-LAST:event_btnLimparTabelaActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoConvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoConvActionPerformed
        Empresa empresa = new Empresa();
        this.abrirGUICadEmpresas(empresa);
    }//GEN-LAST:event_btnNovoConvActionPerformed

    private void limparDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparDadosActionPerformed
        limparDados();
    }//GEN-LAST:event_limparDadosActionPerformed

    private void btnPesquisarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarEmpresaActionPerformed
        //        exibirEmpresas(new EmpresaJpaDAO().findAll());
    }//GEN-LAST:event_btnPesquisarEmpresaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed

    }//GEN-LAST:event_tfNomeActionPerformed

    private void tfCodConvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodConvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodConvActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        Empresa empresa = null;
        try{
            empresa = this.getEmpresa();
            this.abrirGUIAlterarEmpresa(empresa);
        }catch (SapException ex){
            this.exibirMensagem(ex.getMessage(), "Mensagem de erro", true);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed
    
    public void abrirGUIAlterarEmpresa(Empresa empresa){
        if (guiAlterarEmpresa == null) {
            guiAlterarEmpresa = new GUIAlterarEmpresa();
            OuvinteDeGUIAlterarEmpresa ouvinte = new OuvinteDeGUIAlterarEmpresa(guiAlterarEmpresa);
        }
        this.getParent().add(guiAlterarEmpresa);
        guiAlterarEmpresa.setPosicao();
        guiAlterarEmpresa.setEmpresa(empresa);
        guiAlterarEmpresa.setVisible(true);
        try{
            guiAlterarEmpresa.setSelected(true);
        }catch(PropertyVetoException ex){
            exibirMensagem("Não foi poss[ivel selecionar a janela GUIAlterarEmpresa", 
                    "SAP - Empresa", true);
        }
    }
    
    private void abrirGUICadEmpresas(Empresa empresa){
        if(guiCadEmpresas == null){
            guiCadEmpresas = new GUICadEmpresas();
            OuvinteDeGUICadEmpresas ouvinte = new OuvinteDeGUICadEmpresas(guiCadEmpresas);
        }
        this.getParent().add(guiCadEmpresas);
        guiCadEmpresas.setPosicao();
        guiCadEmpresas.setEmpresa(empresa);
        guiCadEmpresas.setVisible(true);
        guiCadEmpresas.limparDados();
        try{
            guiCadEmpresas.setSelected(true);
        }catch (PropertyVetoException ex){
            exibirMensagem("Não foi possível selecionar a janela de cadastro de empresas", 
                    "SAP - Empresas", true);
        }
    }
        
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
            java.util.logging.Logger.getLogger(GUIEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIEmpresas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIEmpresas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimparTabela;
    private javax.swing.JButton btnNovoConv;
    private javax.swing.JButton btnPesquisarEmpresa;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCodConv;
    private javax.swing.JButton limparDados;
    private javax.swing.JTable tEmpresas;
    private javax.swing.JTextField tfCodConv;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

       
}
