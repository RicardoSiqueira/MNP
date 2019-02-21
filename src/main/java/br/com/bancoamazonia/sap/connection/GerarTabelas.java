/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 14207
 */
public class GerarTabelas {
    public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("appSwingCrudUnit");
		factory.close();
	}

}
