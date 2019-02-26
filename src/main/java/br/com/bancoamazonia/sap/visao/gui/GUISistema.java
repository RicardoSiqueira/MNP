package br.com.bancoamazonia.sap.visao.gui;

import br.com.bancoamazonia.sap.FormatarCampoLetras;
import br.com.bancoamazonia.sap.FormatarCampoNum;
import br.com.bancoamazonia.sap.UpperCaseDocument;
import br.com.bancoamazonia.sap.exception.SapException;
import br.com.bancoamazonia.sap.model.domein.Envolvidos;
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
 * @author 14210
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
        tflGestorNegocio.setText(null);
        tflGestorTecnico.setText(null);
        tflAnalistaResponsavel.setText(null);
        tflCoordenador.setText(null);
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
        Sistema s;
        
        int linhaSelecionada = tbSistemas.getSelectedRow();
        if (linhaSelecionada < 0) {
            throw new SapException("Não foi selecionado nenhum Sistema");
        }
        s = (Sistema) this.lista.get(linhaSelecionada);
        
        return s;
    }
    
    public Envolvidos getRemoverEnvolvidos() throws SapException {
        Envolvidos e;
        int linhaSelecionada = tbSistemas.getSelectedRow();
        if (linhaSelecionada < 0) {
            throw new SapException("Não foi selecionado nenhum Sistema");
        }
        e = (Envolvidos) this.lista.get(linhaSelecionada);
        
        return e;
    }
    
    public Sistema getSistema() throws SapException {
        Sistema s = new Sistema();
        
        if (tfCodSistema.getText().equals("")) {
            tfCodSistema.requestFocus();
            throw new SapException("Informe o código do sistema!");
        } else {
            s.setCodSistema(Integer.parseInt(tfCodSistema.getText()));
        }
        
        if (tfNomeSistema.getText().equals("")) {
            tfNomeSistema.requestFocus();
            throw new SapException("Informe o nome do sistema!");
        } else {
            s.setNome(tfNomeSistema.getText());
        }
        
        if (tfDescricaoSistema.getText().equals("")) {
            tfDescricaoSistema.requestFocus();
            throw new SapException("Informe a descrição do Sistema!");
        } else {
            s.setDescricao(tfDescricaoSistema.getText());
        }
        
        if (jcbAtivo.isSelected()) {
            s.setAtivo(true);
        } else {
            s.setAtivo(false);
        }
        
        return s;
        
    }
    
    public Envolvidos getEnvolvidos() throws SapException {
        Envolvidos e = new Envolvidos();
        
        if (tflGestorNegocio.getText().equals("")) {
            tflGestorNegocio.requestFocus();
            throw new SapException("Informe o Gestor do Negócio!");
        } else {
            e.setGestornegocio(tflGestorNegocio.getText());
        }
        
        if (tflGestorTecnico.getText().equals("")) {
            tflGestorTecnico.requestFocus();
            throw new SapException("Informe o nome do Gestor Tecnico!");
        } else {
            e.setGestortecnico(tflGestorTecnico.getText());
        }
        
        if (tflCoordenador.getText().equals("")) {
            tflCoordenador.requestFocus();
            throw new SapException("Informe o nome do Coordenador !");
        } else {
            e.setCoordenador(tflCoordenador.getText());
        }
        if (tflAnalistaResponsavel.getText().equals("")) {
            tflAnalistaResponsavel.requestFocus();
            throw new SapException("Informe o nome do Analista");
        } else {
            e.setAnalista(tflAnalistaResponsavel.getText());
        }
        return e;
        
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
    
    public void exibirEnvolvidos(List<Envolvidos> lista) {
        this.lista = lista;
        String titulos[] = {
            "Gestor do negocio", "Gestor Tecnico", "Analista", "Coordenador"
        };
        DefaultTableModel model = (DefaultTableModel) tbSistemas.getModel();
        Object objts[][] = new Object[lista.size()][3];
        Iterator resultado = lista.iterator();
        int controle = 0;
        while (resultado.hasNext()) {
            Envolvidos next = (Envolvidos) resultado.next();
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
        lblDescriçãoSistema = new javax.swing.JLabel();
        lblGestorNegocio = new javax.swing.JLabel();
        tflGestorNegocio = new javax.swing.JTextField();
        tfDescricaoSistema = new java.awt.TextArea();
        lblGestorTecnico = new javax.swing.JLabel();
        tflGestorTecnico = new javax.swing.JTextField();
        tflAnalistaResponsavel = new javax.swing.JTextField();
        lblAnalistaResponsavel = new javax.swing.JLabel();
        tflCoordenador = new javax.swing.JTextField();
        lblCoordenador = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Sistemas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14)));

        lblCodAgencia.setText("Código do Sistema:");

        lblNomeAgencia.setText("Nome do Sistema:");

        tfNomeSistema.setToolTipText("Nome do Sistema");

        bntSalvar.setText("Cadastrar");
        bntSalvar.setToolTipText("Cadastrar Sistema");
        bntSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSalvarActionPerformed(evt);
            }
        });

        btnLimparDados.setText("Limpar");
        btnLimparDados.setToolTipText("Limpar Dados de Cadastro");
        btnLimparDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparDadosActionPerformed(evt);
            }
        });

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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código do Sistema", "Nome do Sistema", "Descrição", "Ativo", "Gestor do Negocio", "Gestor Tecnico", "Analista Responsavel", "Coordenador"
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

        lblDescriçãoSistema.setText("Descrição:");

        lblGestorNegocio.setText("Gestor do Negócio:");

        tflGestorNegocio.setToolTipText("Gestor do Negócio");

        lblGestorTecnico.setText("Gestor Técnico:");

        tflGestorTecnico.setToolTipText("Gestor Técnico");

        tflAnalistaResponsavel.setToolTipText("Analista Responsável ");

        lblAnalistaResponsavel.setText("Analista Responsável:");

        tflCoordenador.setToolTipText("Coordenador");

        lblCoordenador.setText("Coordenador:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(bntSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimparDados))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblGestorNegocio)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeAgencia)
                            .addComponent(lblGestorTecnico)
                            .addComponent(lblAnalistaResponsavel)
                            .addComponent(lblDescriçãoSistema)
                            .addComponent(lblCoordenador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfCodSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbAtivo))
                            .addComponent(tflCoordenador, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                            .addComponent(tflAnalistaResponsavel)
                            .addComponent(tflGestorTecnico)
                            .addComponent(tflGestorNegocio)
                            .addComponent(tfNomeSistema))
                        .addContainerGap(557, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDescricaoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(tfCodSistema))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCodAgencia)
                        .addComponent(jcbAtivo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeAgencia)
                    .addComponent(tfNomeSistema))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGestorNegocio)
                    .addComponent(tflGestorNegocio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tflGestorTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGestorTecnico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tflAnalistaResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnalistaResponsavel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCoordenador)
                        .addGap(14, 14, 14)
                        .addComponent(lblDescriçãoSistema))
                    .addComponent(tflCoordenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDescricaoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparDados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setToolTipText("Excluir Sistema");
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
                .addContainerGap(1072, Short.MAX_VALUE)
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

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tfCodSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodSistemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodSistemaActionPerformed

    private void jcbAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAtivoActionPerformed

    }//GEN-LAST:event_jcbAtivoActionPerformed

    private void btnLimparDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparDadosActionPerformed
        limparDados();
    }//GEN-LAST:event_btnLimparDadosActionPerformed

    private void bntSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSalvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntSalvarActionPerformed

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
    private javax.swing.JLabel lblAnalistaResponsavel;
    private javax.swing.JLabel lblCodAgencia;
    private javax.swing.JLabel lblCoordenador;
    private javax.swing.JLabel lblDescriçãoSistema;
    private javax.swing.JLabel lblGestorNegocio;
    private javax.swing.JLabel lblGestorTecnico;
    private javax.swing.JLabel lblNomeAgencia;
    private javax.swing.JTable tbSistemas;
    private javax.swing.JTextField tfCodSistema;
    private java.awt.TextArea tfDescricaoSistema;
    private javax.swing.JTextField tfNomeSistema;
    private javax.swing.JTextField tflAnalistaResponsavel;
    private javax.swing.JTextField tflCoordenador;
    private javax.swing.JTextField tflGestorNegocio;
    private javax.swing.JTextField tflGestorTecnico;
    // End of variables declaration//GEN-END:variables

}
