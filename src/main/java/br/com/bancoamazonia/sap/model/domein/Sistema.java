/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.model.domein;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 14207
 */
@Entity
@Table(name = "SISTEMA")
public class Sistema implements AbstractEntity, Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "COD_SISTEMA", unique = true)
    private Integer codSistema;

    @NotNull
    @Column(name = "NOME")
    private String nome;
    
    @Column(name = "ATIVO")
    private boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Integer getcodSistema() {
        return codSistema;
    }

    public void setCodAgencia(Integer codSistema) {
        Integer oldcodSistema = this.codSistema;
        this.codSistema = codSistema;
        changeSupport.firePropertyChange("codAgencia", codSistema, codSistema);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }
    
    public boolean getAtivo(){
        return ativo;
    }
    
    public void setAtivo(boolean ativo){
        boolean oldAtivo = this.ativo;
        this.ativo = ativo;
        changeSupport.firePropertyChange("ativo", oldAtivo, ativo);
    }

    @Override
    public String toString() {
        return "Sistema{" + "id=" + id + ", codSistema=" + codSistema + ", nome=" + nome + ", ativo=" + ativo + '}';    }

    public Object[] array() {
        Object array[] = {String.valueOf(getcodSistema()), getNome(), getAtivo()};
        return array;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.codSistema);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.ativo);
        return hash;
    }
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sistema other = (Sistema) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.codSistema, other.codSistema)) {
            return false;
        }
        
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        
        if (!Objects.equals(this.ativo, other.ativo)) {
            return false;
        }
                
        return true;
    }
}
