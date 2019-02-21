/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.visao.ouvinte;

import br.com.bancoamazonia.sap.exception.SapException;
import br.com.bancoamazonia.sap.model.controle.ControleEmpresa;
import br.com.bancoamazonia.sap.model.domein.Empresa;
import br.com.bancoamazonia.sap.model.domein.dao.EmpresaJpaDAO;
import br.com.bancoamazonia.sap.visao.gui.GUICadEmpresas;
import br.com.bancoamazonia.sap.visao.gui.GUIPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 14207
 */
public class OuvinteDeGUICadEmpresas {
    GUICadEmpresas guiCadEmpresas;
    
    public  OuvinteDeGUICadEmpresas(GUICadEmpresas gui){
        guiCadEmpresas = gui;
        guiCadEmpresas.btnSalvarEmpAddActionListener(new OuvinteGravarEmpresa());
    }

    public OuvinteDeGUICadEmpresas(GUIPrincipal guiPrincipal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    class OuvinteGravarEmpresa implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            Empresa empresa;
            try{
                empresa = guiCadEmpresas.getEmpresa();
                EmpresaJpaDAO empDAO = new EmpresaJpaDAO();
                empDAO.persist(empresa);
                guiCadEmpresas.showMensagem("Empresa cadastrada com sucesso!", false);
                guiCadEmpresas.limparDados();
            }catch(SapException ex){
                guiCadEmpresas.showMensagem(ex.getMessage(), true);
            }
        }
    }
}
