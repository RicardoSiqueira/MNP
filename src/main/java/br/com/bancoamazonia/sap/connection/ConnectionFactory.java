/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 14207
 */

public class ConnectionFactory {
    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:~/sap";
    private static final String USER = "admin";
    private static final String PASS = "admin";
    
    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }
    
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement pstmt) {

        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
        closeConnection(con);
    }

    public static void closeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
        closeConnection(con, pstmt);
    }
}


