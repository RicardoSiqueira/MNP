/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.visao.ouvinte;

import br.com.bancoamazonia.sap.exception.SapException;
import br.com.bancoamazonia.sap.model.domein.Empregado;
import br.com.bancoamazonia.sap.model.domein.dao.EmpregadoJpaDAO;
import br.com.bancoamazonia.sap.visao.gui.GUIEditar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 14207
 */
public class OuvinteGUIEditar {

    GUIEditar guiEdit;

    public OuvinteGUIEditar(GUIEditar edit) {
        guiEdit = edit;
        guiEdit.btnPesquisarActionListener(new OuvintePesquisarEmpregado());
        guiEdit.btnExcluirActionListener(new OuvinteExcluirEmpregado());
    }

    class OuvinteExcluirEmpregado implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                Empregado empregado = guiEdit.getEmpregado();
                StringBuffer msg = new StringBuffer("Confirma a exclusão do empregado abaixo:");
                msg.append("\nCódigo: " + empregado.getCodEmp());
                msg.append("\nNome: " + empregado.getNome());
                String title = "Exclusão de registro";
                int resp = guiEdit.pedirConfirmacao(msg.toString(), title, JOptionPane.YES_NO_OPTION);

                if (resp == JOptionPane.OK_OPTION) {
                    EmpregadoJpaDAO empDAO = new EmpregadoJpaDAO();
                    empDAO.remove(empregado);
                    List emp = empDAO.findAll();
                    guiEdit.exibirEmpregados(emp);
                    JOptionPane.showMessageDialog(null, "Empregado excluído com sucesso!");
                }
            } catch (SapException ex) {
                guiEdit.exibirMensagem(ex.getMessage(), "Mensagem de erro", true);
            }
        }
    }

    class OuvintePesquisarEmpregado implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                String nome = guiEdit.getNome();
                List<Empregado> lista = new EmpregadoJpaDAO().findNome(nome);
                guiEdit.exibirEmpregados(lista);

            } catch (Exception ex) {
                System.out.println("ERRO");
                ex.fillInStackTrace();
                guiEdit.exibirMensagem(ex.getMessage(), "Mensagem de erro", true);
            }
        }

    }
}
