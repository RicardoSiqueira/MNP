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
import br.com.bancoamazonia.sap.model.domein.Sistema;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 14207
 */
public class GUISistema extends javax.swing.JInternalFrame {

    private List sistemas;
    private List lista;
    FormatarCampoLetras format = new FormatarCampoLetras();
    Sistema sistema;

    public GUISistema() {
        initComponents();
        setFrameIcon(new ImageIcon(this.getClass().getResource("/imagem/iconeBasa.png")));
        tfNomeSistema.setDocument(new UpperCaseDocument());
    }

    public void limparDados() {
        tfCodSistema.setText(null);
        tfNomeSistema.setText(null);
        tfDescricaoSistema.setText(null);
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    public void btnSalvarSistemaAddActionListener(ActionListener ouvinte) {
        bntSalvar.addActionListener(ouvinte);
    }

    public void btnExcluirActionListener(ActionListener ouvinte) {
        btnExcluir.addActionListener(ouvinte);
    }

    public Sistema getRemoverSistema() throws SapException {
        Sistema sistema;
        int linhaSelecionada = tbSistemas.getSelectedRow();
        if (linhaSelecionada < 0) {
            throw new SapException("Não foi selecionado nenhum Sistema");
        }
        sistema = (Sistema) this.lista.get(linhaSelecionada);

        return sistema;
    }

    public Sistema getSistema() throws SapException {
        Sistema sistema = new Sistema();

        if (tfCodSistema.getText().equals("")) {
            tfCodSistema.requestFocus();
            throw new SapException("Informe o código do sistema!");
        } else {
            sistema.setCodSistema(Integer.parseInt(tfCodSistema.getText()));
        }

        if (tfNomeSistema.getText().equals("")) {
            tfNomeSistema.requestFocus();
            throw new SapException("Informe o nome do sistema!");
        } else {
            sistema.setNome(tfNomeSistema.getText());
        }
        
         if (tfDescricaoSistema.getText().equals("")) {
            tfDescricaoSistema.requestFocus();
            throw new SapException("Informe a descrição do Sistema!");
        } else {
            sistema.setDescricao(tfDescricaoSistema.getText());
        }

        if (jcbAtivo.isSelected()) {
           sistema.setAtivo(true);
        } else {
            sistema.setAtivo(false);
        }

        return sistema;

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

    public void exibirSistema(List<Sistema> lista) {
        this.lista = lista;
        String titulos[] = {
            "Código do Sistema", "Nome do Sistema", "Descricao", "Ativo"
        };
        DefaultTableModel model = (DefaultTableModel) tbSistemas.getModel();
        Object objts[][] = new Object[lista.size()][3];
        Iterator resultado = lista.iterator();
        int controle = 0;
        while (resultado.hasNext()) {
            Sistema next = (Sistema) resultado.next();
            objts[controle] = next.array();
            controle++;
        }
        model.setDataVector(objts, titulos);
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

    public int pedirConfirmacao(String mensagem, String titulo, int tipo) {
        int resposta = JOptionPane.showConfirmDialog(null, mensagem, titulo, tipo);
        return resposta;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        lblCodAgencia = new javax.swing.JLabel();
        lblNomeAgencia = new javax.swing.JLabel();
        tfNomeSistema = new FormatarCampoLetras(50);
        bntSalvar = new javax.swing.JButton();
        btnLimparDados = new javax.swing.JButton();
        jcbAtivo = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSistemas = new javax.swing.JTable();
        tfCodSistema = new FormatarCampoNum(4);
        lblNomeAgencia1 = new javax.swing.JLabel();
        tfDescricaoSistema = new FormatarCampoLetras(50);
        btnExcluir = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Sistemas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14)));

        lblCodAgencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCodAgencia.setText("Código do Sistema:");

        lblNomeAgencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNomeAgencia.setText("Nome do Sistema:");

        tfNomeSistema.setToolTipText("Nome do Sistema");

        bntSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bntSalvar.setText("Salvar");
        bntSalvar.setToolTipText("Salvar Sistema");
        bntSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSalvarActionPerformed(evt);
            }
        });

        btnLimparDados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimparDados.setText("Limpar");
        btnLimparDados.setToolTipText("Limpar Dados de Cadastro");
        btnLimparDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparDadosActionPerformed(evt);
            }
        });

        jcbAtivo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbAtivo.setSelected(true);
        jcbAtivo.setText("Sistema Ativo");
        jcbAtivo.setToolTipText("Ativar e Desativar Agência");
        jcbAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAtivoActionPerformed(evt);
            }
        });

        tbSistemas.setBackground(new java.awt.Color(240, 240, 240));
        tbSistemas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbSistemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código do Sistema", "Nome do Sistema", "Descrição", "Ativo"
            }
        ));
        tbSistemas.setToolTipText("Tabela de Sistemas Cadastrados");
        tbSistemas.setShowHorizontalLines(false);
        tbSistemas.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tbSistemas);

        tfCodSistema.setToolTipText("Código do Sistema");
        tfCodSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodSistemaActionPerformed(evt);
            }
        });

        lblNomeAgencia1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNomeAgencia1.setText("Descrição:");

        tfDescricaoSistema.setToolTipText("Descrição Sistema");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(bntSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimparDados)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNomeAgencia1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCodAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfCodSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcbAtivo))
                            .addComponent(tfDescricaoSistema)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblNomeAgencia)
                                .addGap(18, 18, 18)
                                .addComponent(tfNomeSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodAgencia)
                    .addComponent(jcbAtivo)
                    .addComponent(tfCodSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeAgencia)
                    .addComponent(tfNomeSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNomeAgencia1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDescricaoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparDados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        tfNomeSistema.getAccessibleContext().setAccessibleDescription("Nome do Sistema");
        tfCodSistema.getAccessibleContext().setAccessibleName("Código do Sistema");

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparDadosActionPerformed
        limparDados();
    }//GEN-LAST:event_btnLimparDadosActionPerformed

    private void bntSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntSalvarActionPerformed

    private void jcbAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAtivoActionPerformed

    }//GEN-LAST:event_jcbAtivoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tfCodSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodSistemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodSistemaActionPerformed

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
            java.util.logging.Logger.getLogger(GUISistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUISistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUISistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUISistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUISistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSalvar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimparDados;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbAtivo;
    private javax.swing.JLabel lblCodAgencia;
    private javax.swing.JLabel lblNomeAgencia;
    private javax.swing.JLabel lblNomeAgencia1;
    private javax.swing.JTable tbSistemas;
    private javax.swing.JTextField tfCodSistema;
    private javax.swing.JTextField tfDescricaoSistema;
    private javax.swing.JTextField tfNomeSistema;
    // End of variables declaration//GEN-END:variables
}
