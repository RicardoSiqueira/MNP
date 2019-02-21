/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap;

//import br.com.bancoamazonia.sap.visao.gui.GUIPrincipal;

import br.com.bancoamazonia.sap.model.controle.ControleEmpregado;
import br.com.bancoamazonia.sap.model.controle.ControleEmpresa;
import br.com.bancoamazonia.sap.visao.gui.GUIPrincipal;
import br.com.bancoamazonia.sap.visao.ouvinte.OuvinteGuiPrincipal;
import java.util.Locale;



/**
 *
 * @author 14207
 */

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt","BR"));
	new ControleEmpresa();
        new ControleEmpregado();
        
        GUIPrincipal principal = new GUIPrincipal();
         OuvinteGuiPrincipal ouvinte= new OuvinteGuiPrincipal(principal);
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
        
    }
}
