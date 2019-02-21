/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.visao.ouvinte;

import br.com.bancoamazonia.sap.exception.SapException;
import br.com.bancoamazonia.sap.model.domein.Empregado;
import br.com.bancoamazonia.sap.model.domein.dao.EmpregadoJpaDAO;
import br.com.bancoamazonia.sap.visao.gui.GUIAlterarEmpregado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 14207
 */
public class OuvinteDeGUIAlterarEmpregado {
    GUIAlterarEmpregado guiAlterarEmpregado;
    
    public OuvinteDeGUIAlterarEmpregado(GUIAlterarEmpregado gui){
        guiAlterarEmpregado = gui;
        guiAlterarEmpregado.btnSalvarEmpregadoAddActionListener(new OuvinteAlterarEmpregado());
    }
    
    class OuvinteAlterarEmpregado implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Empregado empregado;
            try{
                empregado = guiAlterarEmpregado.getEmpregado();
                EmpregadoJpaDAO empDAO = new EmpregadoJpaDAO();
                empDAO.merge(empregado);
                guiAlterarEmpregado.showMensagem("Empregado alterado com sucesso!", false);
                guiAlterarEmpregado.limparDados();

            }catch (SapException ex){
                guiAlterarEmpregado.showMensagem(ex.getMessage(), true);
            }
        }
    }
}
