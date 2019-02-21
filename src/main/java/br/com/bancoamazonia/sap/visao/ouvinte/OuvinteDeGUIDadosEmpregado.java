/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.visao.ouvinte;

import br.com.bancoamazonia.sap.exception.SapException;
import br.com.bancoamazonia.sap.model.domein.Empregado;
import br.com.bancoamazonia.sap.model.domein.dao.EmpregadoJpaDAO;
import br.com.bancoamazonia.sap.visao.gui.GUIDadosEmpregado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;

/**
 *
 * @author 14207
 */
public class OuvinteDeGUIDadosEmpregado {

    GUIDadosEmpregado guiDadosEmpregado;

    public OuvinteDeGUIDadosEmpregado(GUIDadosEmpregado gui) {
        guiDadosEmpregado = gui;
        guiDadosEmpregado.btnIncluirAddActionListener(new OuvinteGravarEmpregado());
    }

    class OuvinteGravarEmpregado implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Empregado empregado;
            try {
                empregado = guiDadosEmpregado.getEmpregado();
                EmpregadoJpaDAO empDAO = new EmpregadoJpaDAO();
                empDAO.persist(empregado);
                guiDadosEmpregado.showMensagem("Empregado gravado com sucesso!", false);
                guiDadosEmpregado.limparDados();
            } catch (SapException ex) {
                guiDadosEmpregado.showMensagem(ex.getMessage(), true);
            }
        }
    }
}
