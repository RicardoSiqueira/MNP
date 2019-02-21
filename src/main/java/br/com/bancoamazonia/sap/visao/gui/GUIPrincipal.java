/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.visao.gui;

import br.com.bancoamazonia.sap.visao.ouvinte.OuvinteDeGUIAgencia;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author 14207
 */

public class GUIPrincipal extends javax.swing.JFrame{
private static GUISistema guiAgencia;
private static GUIResumoArquivo guiResumoArquivo;
    
    
    
    
    JScrollPane jScrollPane;
    JPanel jPanel;

           
    public GUIPrincipal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);   
        setIcon();
    }  
    
    public int pedirConfirmacao(String mensagem, String titulo, int tipo) {
        int resposta = JOptionPane.showConfirmDialog(null, mensagem, titulo, tipo);
        return resposta;
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagem/r.jpg"));
        Image image = icon.getImage();
        desktopPane =  new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(), getHeight(), this);

            }

        };
        jmSistema = new javax.swing.JMenuBar();
        menuCadastrar = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        itemDeMenuRelResArqPag = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu(){

        };
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SMP- Sistema de Manual de Produção");
        setExtendedState(6);
        setMinimumSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 941, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 617, Short.MAX_VALUE)
        );

        System.out.print(this.getClass().getResource("/imagem/Cadastrar1.png"));
        menuCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Cadastrar1.png"))); // NOI18N
        menuCadastrar.setText("Cadastro");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/pc.png"))); // NOI18N
        jMenuItem3.setText("Sistemas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuCadastrar.add(jMenuItem3);

        jmSistema.add(menuCadastrar);

        menuRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Relatorios.png"))); // NOI18N
        menuRelatorios.setText("Relatórios");

        itemDeMenuRelResArqPag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Aquivos.png"))); // NOI18N
        itemDeMenuRelResArqPag.setText("Relatórios Sistema");
        itemDeMenuRelResArqPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDeMenuRelResArqPagActionPerformed(evt);
            }
        });
        menuRelatorios.add(itemDeMenuRelResArqPag);

        jmSistema.add(menuRelatorios);

        menuSair.setText("Sistema");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/instrucao.png"))); // NOI18N
        jMenuItem2.setText("Sobre");
        menuSair.add(jMenuItem2);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Sair.png"))); // NOI18N
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuSair.add(jMenuItem1);

        jmSistema.add(menuSair);

        setJMenuBar(jmSistema);

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

        getAccessibleContext().setAccessibleName("SMP- Sistema de Manual de Produção");
        getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(957, 676));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    private void itemDeMenuRelResArqPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDeMenuRelResArqPagActionPerformed
        if(guiResumoArquivo == null){
            guiResumoArquivo = new GUIResumoArquivo();
        }
        desktopPane.add(guiResumoArquivo);
        guiResumoArquivo.setVisible(true);
        guiResumoArquivo.setPosicao();
    }//GEN-LAST:event_itemDeMenuRelResArqPagActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         StringBuffer msg = new StringBuffer("Deseja realmente sair do sistema?");
        String title = "SMP - Sistema de Manual de Producao";
        int resp = pedirConfirmacao(msg.toString(), title, JOptionPane.YES_NO_OPTION);
        
        if (resp == JOptionPane.YES_OPTION) {
            System.exit(0);
        }          
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if(guiAgencia == null){
            guiAgencia = new GUISistema();
            OuvinteDeGUIAgencia ouvinte = new OuvinteDeGUIAgencia(guiAgencia);
        }
        desktopPane.add(guiAgencia);
        guiAgencia.setVisible(true);
        guiAgencia.setPosicao();
        guiAgencia.limparDados();
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    
     public void framePrincipalAddWindowListener(WindowListener ouvinte) {
        this.addWindowListener(ouvinte);
    }
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIPrincipal principal = new GUIPrincipal();
                principal.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem itemDeMenuRelResArqPag;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuBar jmSistema;
    private javax.swing.JMenu menuCadastrar;
    private javax.swing.JMenu menuRelatorios;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagem/logo.jpg")));
    }
}
