/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.visao.ouvinte;

import br.com.bancoamazonia.sap.model.controle.ControleEmpresa;
import br.com.bancoamazonia.sap.exception.SapException;
import br.com.bancoamazonia.sap.model.domein.Empregado;
import br.com.bancoamazonia.sap.model.domein.Empresa;
import br.com.bancoamazonia.sap.model.domein.dao.EmpregadoJpaDAO;
import br.com.bancoamazonia.sap.model.domein.dao.EmpresaJpaDAO;
import br.com.bancoamazonia.sap.visao.gui.GUIEmpresas;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author 14207
 */
public class OuvinteDeGUIEmpresas {
      GUIEmpresas guiEmpresas;
    
    public OuvinteDeGUIEmpresas(GUIEmpresas gui){
        guiEmpresas = gui;
        guiEmpresas.btnPesquisarEmpresaAddActionListener(new OuvintePesquisarEmpresa());
        guiEmpresas.btnExcluirEmpresaActionListener(new OuvinteExcluirEmpresa());
    }
    
    class OuvinteExcluirEmpresa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                Empresa empresa = guiEmpresas.getEmpresa();
                StringBuffer msg = new StringBuffer("Confirma a exclusão da empresa abaixo:");
                msg.append("\nCódigo do Convênio: " + empresa.getCodConv());
                msg.append("\nNome: " + empresa.getNome());
                String title = "Exclusão de registro";
                int resp = guiEmpresas.pedirConfirmacao(msg.toString(), title, JOptionPane.YES_NO_OPTION);
                
                if (resp == JOptionPane.OK_OPTION) {
                    EmpresaJpaDAO empDAO = new EmpresaJpaDAO();
                    empDAO.remove(empresa);
                    List emp = empDAO.findAll();
                    guiEmpresas.exibirEmpresas(emp);
                    JOptionPane.showMessageDialog(null, "Empregado excluído com sucesso!");
                }
            }catch(SapException ex){
                guiEmpresas.exibirMensagem(ex.getMessage(), "Mensagem de erro", true);
            }
        }
    }
    
    class OuvintePesquisarEmpresa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                String nome = guiEmpresas.getNome();
                List<Empresa> lista = new EmpresaJpaDAO().findNome(nome);
                guiEmpresas.exibirEmpresas(lista);
            }catch(Exception ex){
                 guiEmpresas.exibirMensagem(ex.getMessage(), "Mensagem de erro", true);
            }
        }
        
        
    }
}
