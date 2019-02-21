/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.connection;

import java.sql.SQLException;
import org.h2.tools.Server;

/**
 *
 * @author 14207
 */
public class GerenciadorDoServidor {
     private static Server servidor;

    public static void iniciarServidor() throws Exception {
        try {
            servidor = Server.createTcpServer();
            servidor.start();
        } catch (SQLException ex) {
            StringBuffer mensagem = new StringBuffer("Não foi possível iniciar o servidor");
            mensagem.append("\nMotivo: " + ex.getMessage());
            throw new Exception(mensagem.toString());
        }
    }

    public static void pararServidor() {
        servidor.stop();
    }
}
