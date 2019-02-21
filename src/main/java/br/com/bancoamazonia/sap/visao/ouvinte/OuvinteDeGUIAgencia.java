/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.visao.ouvinte;

import br.com.bancoamazonia.sap.exception.SapException;
import br.com.bancoamazonia.sap.model.domein.Sistema;
import br.com.bancoamazonia.sap.model.domein.dao.SistemaJpaDAO;
import br.com.bancoamazonia.sap.visao.gui.GUISistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 14207
 */
public class OuvinteDeGUIAgencia {

    GUISistema guiAgencia;

    public OuvinteDeGUIAgencia(GUISistema gui) {
        guiAgencia = gui;
        guiAgencia.btnSalvarAgenciaAddActionListener(new OuvinteGravarSistema());
        guiAgencia.btnExcluirActionListener(new OuvinteExcluirSistema());
    }

    class OuvinteGravarSistema implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Sistema sistema;
            try {
                sistema = guiAgencia.getAgencia();
                SistemaJpaDAO sistemaDAO = new SistemaJpaDAO();
               sistemaDAO.persist(sistema);
                guiAgencia.showMensagem("Sistema gravado com sucesso!", false);
                guiAgencia.limparDados();
                List<Sistema> lista = sistemaDAO.findAll();
                guiAgencia.exibirAgencias(lista);
                
                
            } catch (SapException ex) {
                guiAgencia.showMensagem(ex.getMessage(), true);
            } 
            
        }
    }
    
    class OuvinteExcluirSistema implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                Sistema sistema = guiAgencia.getRemoverSistema();
                StringBuffer msg = new StringBuffer("Confirma a exclusão da sistema abaixo:");
                msg.append("\nCódigo: " + sistema.getcodSistema());
                msg.append("\nNome: " + sistema.getNome());
                String title = "Exclusão de registro";
                int resp = guiAgencia.pedirConfirmacao(msg.toString(), title, JOptionPane.YES_NO_OPTION);

                if (resp == JOptionPane.OK_OPTION) {
                    SistemaJpaDAO empDAO = new SistemaJpaDAO();
                    empDAO.remove(sistema);
                    List ag = empDAO.findAll();
                    guiAgencia.exibirAgencias(ag);
                    JOptionPane.showMessageDialog(null, "Sistema excluído com sucesso!");
                }
            } catch (SapException ex) {
                guiAgencia.exibirMensagem(ex.getMessage(), "Mensagem de erro", true);
            }
        }
    }
    
}
