/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.model.domein.constante;

import javax.swing.JComboBox;

/**
 *
 * @author 14207
 */
public enum EstadoEnum {
    SELECIONE("NÃO SELECIONADO",0),
    AC("Acre",1), 
    AL("Alagoas",2), 
    AP("Amapá",3), 
    AM("Amazonas",4), 
    BA("Bahia",5), 
    CE("Ceará",6), 
    DF("Distrito Federal",7), 
    ES("Espírito Santo",8), 
    GO("Goiás",9), 
    MA("Maranhão",10), 
    MT("Mato Grosso",11), 
    MS("Mato Grosso do Sul",12), 
    MG("Minas Gerais",13), 
    PA("Pará",14), 
    PB("Paraíba",15), 
    PR("Paraná",16), 
    PE("Pernambuco",17), 
    PI("Piauí",18), 
    RJ("Rio de Janeiro",19), 
    RN("Rio Grande do Norte",20), 
    RS("Rio Grande do Sul",21), 
    RO("Rondônia",22), 
    RR("Roraima",23), 
    SC("Santa Catarina",24), 
    SP("São Paulo",25), 
    SE("Sergipe",26), 
    TO("Tocantins",27);
     
    private String descricao;
    private Integer codigo; 
    
    private EstadoEnum(String descricao, Integer codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }
     
    public String getDescricao() {
        return descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
    
    public JComboBox listaEstados(){
        return new JComboBox(this.values());
    }
    
}

