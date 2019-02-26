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
 * @author 14210
 */
@Entity
@Table(name = "ENVOLVIDOS")
public class Envolvidos implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(name = "GESTOR_NEGOCIO", unique = true)
    private String gestornegocio;
    @NotNull
    @Column(name = "GESTOR_TECNICO", unique = true)
    private String gestortecnico;
    @NotNull
    @Column(name = "ANALISTA", unique = true)
    private String analista;
    @NotNull
    @Column(name = "COORDENADOR", unique = true)
    private String coordenador;
    
    public Envolvidos() {
    }
    
    public String getGestornegocio() {
        return gestornegocio;
    }
    
    public void setGestornegocio(String gestornegocio) {
        String oldGestorNegocio = this.gestornegocio;
        this.gestornegocio = gestornegocio;
        changeSupport.firePropertyChange("gestornegocio", oldGestorNegocio, gestornegocio);
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        int oldid = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldid, id);
        
    }
    
    public String getGestortecnico() {
        return gestortecnico;
    }
    
    public void setGestortecnico(String gestortecnico) {
        String oldgestortecnico = this.gestortecnico;
        this.gestortecnico = gestortecnico;
        changeSupport.firePropertyChange("gestortecnico", oldgestortecnico, gestortecnico);
        
    }
    
    public String getAnalista() {
        return analista;
    }
    
    public void setAnalista(String analista) {
        String oldanalista = this.analista;
        this.analista = analista;
        changeSupport.firePropertyChange("analista", oldanalista, analista);
    }
    
    public String getCoordenador() {
        return coordenador;
    }
    
    public void setCoordenador(String coordenador) {
        String oldcoordenador = this.coordenador;
        this.coordenador = coordenador;
        changeSupport.firePropertyChange("coordenador", oldcoordenador, coordenador);
        
        
    }
    
    @Override
    public String toString() {
        return "Envolvidos{" + "id=" + id + ", gestornegocio=" + gestornegocio + ", gestortecnico=" + gestortecnico + ", analista" + analista +", coordenador=" + coordenador + '}';    }
    
    public Object[] arrayEnvolvidos() {
        Object array[] = {String.valueOf(getGestornegocio()), getGestortecnico(), getAnalista(), getCoordenador()};
        return array;
    }
    
     @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.gestornegocio);
        hash = 53 * hash + Objects.hashCode(this.gestortecnico);
        hash = 53 * hash + Objects.hashCode(this.analista);
        hash = 53 * hash + Objects.hashCode(this.coordenador);
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
        final Envolvidos other = (Envolvidos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.gestornegocio, other.gestornegocio)) {
            return false;
        }
        
        if (!Objects.equals(this.gestortecnico, other.gestortecnico)) {
            return false;
        }
        if (!Objects.equals(this.analista, other.analista)) {
            return false;
        }
        if (!Objects.equals(this.coordenador, other.coordenador)) {
            return false;
        }
                
        return true;
    }

    public Object[] array() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    

