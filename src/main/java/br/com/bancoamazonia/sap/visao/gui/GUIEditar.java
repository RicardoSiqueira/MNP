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
import br.com.bancoamazonia.sap.model.domein.Empregado;
import br.com.bancoamazonia.sap.visao.ouvinte.OuvinteDeGUIAlterarEmpregado;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 14207
 */
public class GUIEditar extends javax.swing.JInternalFrame {

    FormatarCampoLetras formatar = new FormatarCampoLetras();
    FormatarCampoNum formatarNum = new FormatarCampoNum();
    private List empregados;
    private List lista;
    GUIAlterarEmpregado guiAlterarEmpregado;

    public GUIEditar() {
        initComponents();
        setFrameIcon(new ImageIcon(this.getClass().getResource("/imagem/iconeBasa.png")));
        tfNome.setDocument(new UpperCaseDocument());
    }

    public void limparDados() {
        tfCodEmp.setText(null);
        tfNome.setText(null);
    }

    public void limparTabela() {
        while (tabelaEmpregados.getModel().getRowCount() > 0) {
            ((DefaultTableModel) tabelaEmpregados.getModel()).removeRow(0);
        }
    }

    public void exibirEmpregados(List<Empregado> lista) {
        this.lista = lista;
        String titulos[] = {
            "Cod Empregado", "Nome", "Agencia", "Posto", "Conta", "Salário", "Endereço", "Número", "Complemento", "Bairro", "CEP", "Cidade", "Estado", "CPF"
        };
        DefaultTableModel model = (DefaultTableModel) tabelaEmpregados.getModel();
        this.removerLinhasDaTabela(model);
        Object objts[][] = new Object[lista.size()][14];
        Iterator resultado = lista.iterator();
        int controle = 0;
        while (resultado.hasNext()) {
            Empregado next = (Empregado) resultado.next();
            objts[controle] = next.array();
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

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public void btnPesquisarActionListener(ActionListener ouvinte) {
        btnPesquisar.addActionListener(ouvinte);
    }

    public void btnExcluirActionListener(ActionListener ouvinte) {
        btnExcluir.addActionListener(ouvinte);
    }

    public Empregado getEmpregado() throws SapException {
        Empregado empregado = null;
        int linhaSelecionada = tabelaEmpregados.getSelectedRow();
        if (linhaSelecionada < 0) {
            throw new SapException("Não foi selecionado nenhum empregado");
        }
        empregado = (Empregado) this.lista.get(linhaSelecionada);

        return empregado;
    }

    public int pedirConfirmacao(String mensagem, String titulo, int tipo) {
        int resposta = JOptionPane.showConfirmDialog(null, mensagem, titulo, tipo);
        return resposta;
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

    public String getNome() {
        return tfNome.getText();
    }

    private void abrirGUIAlterarEmpregado(Empregado empregado) {
        if (guiAlterarEmpregado == null) {
            guiAlterarEmpregado = new GUIAlterarEmpregado();
            OuvinteDeGUIAlterarEmpregado ouvinte = new OuvinteDeGUIAlterarEmpregado(guiAlterarEmpregado);
        }
        this.getParent().add(guiAlterarEmpregado);
        guiAlterarEmpregado.setPosicao();
        guiAlterarEmpregado.setEmpregado(empregado);
        guiAlterarEmpregado.setVisible(true);
        try {
            guiAlterarEmpregado.setSelected(true);
        } catch (PropertyVetoException ex) {
            exibirMensagem("Não foi possível selecionar a janela GUIAlterarEmpregado",
                    "SAP - Empregados", true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        lblCodEmp = new javax.swing.JLabel();
        tfCodEmp = new FormatarCampoNum(6);
        btnCodEmp = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        tfNome = new FormatarCampoLetras(50);
        btnNome = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnLimparDados = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaEmpregados = new javax.swing.JTable();
        btnLimparTabela = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Empregado");
        setMaximumSize(new java.awt.Dimension(806, 549));
        setMinimumSize(new java.awt.Dimension(806, 549));

        desktopPane.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Pesquisa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lblCodEmp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCodEmp.setText("Código do Empregado:");

        tfCodEmp.setToolTipText("Código do Empregado. Somente Números");

        btnCodEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8-binóculos-22 (2).png"))); // NOI18N
        btnCodEmp.setToolTipText("Procurar Empregados Cadastrados pelo Código");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNome.setText("Nome:");

        tfNome.setToolTipText("Nome do empregado");
        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        btnNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8-binóculos-22 (2).png"))); // NOI18N
        btnNome.setToolTipText("Procurar empregados cadastrados pelo nome");
        btnNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblCodEmp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCodEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnCodEmp)
                .addGap(34, 34, 34)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnNome)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCodEmp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCodEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnPesquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8-pesquisar-22 (1).png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setToolTipText("Pesquisar dados do empregado");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnLimparDados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLimparDados.setIcon(new javax.swing.ImageIcon("C:\\Users\\14207\\Desktop\\imgSys\\limpardados.png")); // NOI18N
        btnLimparDados.setText("Limpar ");
        btnLimparDados.setToolTipText("Limpar dados de pesquisa");
        btnLimparDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparDadosActionPerformed(evt);
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

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon("C:\\Users\\14207\\Desktop\\imgSys\\delete.png")); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setToolTipText("Excluir Registro Selecionado na Tabela");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tabelaEmpregados.setAutoCreateRowSorter(true);
        tabelaEmpregados.setBackground(new java.awt.Color(240, 240, 240));
        tabelaEmpregados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod Emp", "Nome", "Agência", "Posto", "Conta", "Salário", "Endereço", "Número", "Complemento", "Bairro", "CEP", "Cidade", "Estado", "CPF"
            }
        ));
        tabelaEmpregados.setToolTipText("Tabela de registros do empregado");
        tabelaEmpregados.setGridColor(new java.awt.Color(255, 255, 255));
        tabelaEmpregados.setShowHorizontalLines(false);
        tabelaEmpregados.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tabelaEmpregados);

        btnLimparTabela.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLimparTabela.setIcon(new javax.swing.ImageIcon("C:\\Users\\14207\\Desktop\\imgSys\\limpardados.png")); // NOI18N
        btnLimparTabela.setText("Limpar Tabela");
        btnLimparTabela.setToolTipText("Limpar Dados da Tabela");
        btnLimparTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparTabelaActionPerformed(evt);
            }
        });

        desktopPane.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnPesquisar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnLimparDados, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnAlterar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnExcluir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(btnLimparTabela, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopPaneLayout.createSequentialGroup()
                        .addComponent(btnLimparTabela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(desktopPaneLayout.createSequentialGroup()
                                .addComponent(btnPesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLimparDados))
                            .addGroup(desktopPaneLayout.createSequentialGroup()
                                .addComponent(btnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluir)))))
                .addContainerGap())
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimparDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
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

    private void btnNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNomeActionPerformed

    private void btnLimparDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparDadosActionPerformed
        limparDados();
    }//GEN-LAST:event_btnLimparDadosActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        Empregado empregado = null;
        try {
            empregado = this.getEmpregado();
            this.abrirGUIAlterarEmpregado(empregado);
        } catch (SapException ex) {
            this.exibirMensagem(ex.getMessage(), "Mensagem de erro", true);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnLimparTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparTabelaActionPerformed
        limparTabela();
    }//GEN-LAST:event_btnLimparTabelaActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(GUIEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIEditar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCodEmp;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimparDados;
    private javax.swing.JButton btnLimparTabela;
    private javax.swing.JButton btnNome;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCodEmp;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tabelaEmpregados;
    private javax.swing.JTextField tfCodEmp;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
