/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author 14207
 */
public final class FormatarCampoLetras extends JTextField{
    private int maxCaracteres = -1;
    
    public FormatarCampoLetras() {
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
         
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jTextFieldKeyTyped(evt);}});
    }
 
    public FormatarCampoLetras(int maximo) {    
       super();
       setMaximoCaracteres(maximo);// define o tamanho máximo que deve ser aceito no jtextfield que foi recebido no  construtor
   
        addKeyListener(new java.awt.event.KeyAdapter() {
    
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt) {
            jTextFieldKeyTyped(evt);}});
        
    }
   
    private void jTextFieldKeyTyped(KeyEvent evt) {
        String caracteres=".<>;:/?!@#$%¨&*()-_=+/?;:>.<,|";// lista de caracters que não devem ser aceitos
            if(caracteres.contains(evt.getKeyChar() + "")){// se o character que gerou o evento estiver na lista
                evt.consume();//aciona esse propriedade para eliminar a ação do evento
            }
    
        if((getText().length()>=getMaximoCaracteres())&&(getMaximoCaracteres()!=-1)){
        //if para saber se precisa verificar também o tamanho da string do campo
        // maior ou igual ao tamanho máximo, cancela e nao deixa inserir mais
            evt.consume();
            setText(getText().substring(0,getMaximoCaracteres()));
        // esta linha acima é para remover os caracters inválidos caso o usuário tenha copiado o //conteúdo de algum lugar ou seja com tamanho maior que o definido
        }
 
    }
 
    public int getMaximoCaracteres() {
        return maxCaracteres;
    }
    public void setMaximoCaracteres(int maximoCaracteres) {
        this.maxCaracteres = maximoCaracteres;
    }
}
