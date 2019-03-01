/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.visao.ouvinte;

import br.com.bancoamazonia.sap.exception.SapException;
import br.com.bancoamazonia.sap.model.domein.Envolvidos;
import br.com.bancoamazonia.sap.model.domein.Sistema;
import br.com.bancoamazonia.sap.model.domein.dao.EnvolvidosJpaDAO;
import br.com.bancoamazonia.sap.model.domein.dao.SistemaJpaDAO;
import br.com.bancoamazonia.sap.visao.gui.GUISistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 14210
 */
public class OuvinteDeGUISistema {

    GUISistema guiSistema;

    public OuvinteDeGUISistema(GUISistema gui) {
        guiSistema = gui;
        guiSistema.btnSalvarSistemaAddActionListener(new OuvinteGravarSistema());
        guiSistema.btnExcluirActionListener(new OuvinteExcluirSistema());
    }

    class OuvinteGravarSistema implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Sistema sistema;
            Envolvidos envolvidos;
            try {

                sistema = guiSistema.getSistema();
                envolvidos = guiSistema.getEnvolvidos();
                SistemaJpaDAO sistemaDAO = new SistemaJpaDAO();
                EnvolvidosJpaDAO envolvidosJpaDAO = new EnvolvidosJpaDAO();
                sistemaDAO.persist(sistema);
                envolvidosJpaDAO.persist(envolvidos);
                guiSistema.showMensagem("Sistema Cadastrado com sucesso!", false);
                guiSistema.limparDados();
                List<Sistema> listas = sistemaDAO.findAll();
                List<Envolvidos> lista = envolvidosJpaDAO.findAll();
                guiSistema.exibirSistema(listas);
                guiSistema.exibirEnvolvidos(lista);

            } catch (SapException ex) {
                guiSistema.showMensagem(ex.getMessage(), true);
            }

        }

    }

    class OuvinteExcluirSistema implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                Sistema sistema = guiSistema.getRemoverSistema();
                StringBuffer msg = new StringBuffer("Confirma a exclusão da sistema abaixo:");
                msg.append("\nCódigo: " + sistema.getcodSistema());
                msg.append("\nNome: " + sistema.getNome());
                msg.append("\nDescricao " + sistema.getDescricao());
                String title = "Exclusão de registro";
                int resp = guiSistema.pedirConfirmacao(msg.toString(), title, JOptionPane.YES_NO_OPTION);

                if (resp == JOptionPane.OK_OPTION) {
                    SistemaJpaDAO empDAO = new SistemaJpaDAO();
                    empDAO.remove(sistema);
                    List ag = empDAO.findAll();
                    guiSistema.exibirSistema(ag);
                    JOptionPane.showMessageDialog(null, "Sistema excluído com sucesso!");
                }
            } catch (SapException ex) {
                guiSistema.exibirMensagem(ex.getMessage(), "Mensagem de erro", true);
            }
        }
    }

}
