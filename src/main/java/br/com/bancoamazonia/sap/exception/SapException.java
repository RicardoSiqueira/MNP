/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.exception;

/**
 *
 * @author 14207 - Leandro Augusto
 */
public class SapException extends Exception {
       public SapException(){
           super("Erro de causa desconhecida");
       }
       
       public SapException(String msg){
           super(msg);
       }
}
