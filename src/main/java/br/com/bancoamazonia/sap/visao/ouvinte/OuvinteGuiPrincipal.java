/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.visao.ouvinte;

import br.com.bancoamazonia.sap.connection.GerenciadorDoServidor;
import br.com.bancoamazonia.sap.visao.gui.GUIPrincipal;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author 14207
 */
public class OuvinteGuiPrincipal {
    
    
     private GUIPrincipal guiPrincipal;

    public OuvinteGuiPrincipal(GUIPrincipal guiPrincipal) {
        this.guiPrincipal = guiPrincipal;
        guiPrincipal.framePrincipalAddWindowListener(new Ouvinte());
    }
    
     class Ouvinte extends WindowAdapter {

        @Override
        public void windowOpened(WindowEvent e) {
            try {
                GerenciadorDoServidor.iniciarServidor();
            } catch (Exception ex) {
                StringBuffer mensagem = new StringBuffer(ex.getMessage());
                mensagem.append("\nO aplicativo será encerrado!");
                JOptionPane.showMessageDialog(null,
                        mensagem.toString(),
                        "Mensagem de erro",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }

        @Override
        public void windowClosed(WindowEvent e) {
            GerenciadorDoServidor.pararServidor();
        }
    }
    
}
