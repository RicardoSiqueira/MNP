/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.visao.ouvinte;

import br.com.bancoamazonia.sap.exception.SapException;
import br.com.bancoamazonia.sap.model.domein.Empresa;
import br.com.bancoamazonia.sap.model.domein.dao.EmpresaJpaDAO;
import br.com.bancoamazonia.sap.visao.gui.GUIAlterarEmpresa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 14207
 */
public class OuvinteDeGUIAlterarEmpresa {
    GUIAlterarEmpresa guiAlterarEmpresa;
    
    public OuvinteDeGUIAlterarEmpresa(GUIAlterarEmpresa gui){
        guiAlterarEmpresa = gui;
        guiAlterarEmpresa.btnSalvarEmpresaAddActionListener(new OuvinteAlterarEmpresa());
    }
    
    class OuvinteAlterarEmpresa implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Empresa empresa;
            try{
                empresa = guiAlterarEmpresa.getEmpresa();
                EmpresaJpaDAO empresaDAO = new EmpresaJpaDAO();
                empresaDAO.merge(empresa);
                guiAlterarEmpresa.showMensagem("Empresa alterada com sucesso", false);
                guiAlterarEmpresa.limparDados();
            }catch(SapException ex){
                guiAlterarEmpresa.showMensagem(ex.getMessage(), true);
            }
        }
    }
}
