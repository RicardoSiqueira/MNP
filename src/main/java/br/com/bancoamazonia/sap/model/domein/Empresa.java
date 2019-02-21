package br.com.bancoamazonia.sap.model.domein;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;



/**
 *
 * @author 14207 
 */

@Entity
@Table(name = "EMPRESAS")
public class Empresa implements AbstractEntity, Serializable{
    
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(name = "COD_CONVENIO", unique = true)
    private Integer codConv;
    
    @NotNull
    @Column(name = "NOME")
    private String nome;
    
    @NotNull
    @Column(name = "AGENCIA")
    private String agencia;
    
    @Column(name = "POSTO")
    private Integer posto;
    
    @NotNull
    @Column(name = "CONTA_CORRENTE")
    private String numConta;
    
    @NotNull
    @Column(name = "CNPJ", unique = true)
    private String cnpj;

    public Long getId() {
    	return id;
    }

    public void setId(Long id) {
    	Long oldId = this.id;
	this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Integer getCodConv() {
        return codConv;
    }

    public void setCodConv(Integer codConv) {
    	Integer oldCodConv = this.codConv;
	this.codConv = codConv;
        changeSupport.firePropertyChange("codEmp", oldCodConv, codConv);
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	String oldNome = this.nome;
	this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getAgencia() {
	return agencia;
    }

    public void setAgencia(String agencia) {
	String oldAgencia = this.agencia;
	this.agencia = agencia;
        changeSupport.firePropertyChange("agencia", oldAgencia, agencia);
    }

    public Integer getPosto() {
        if (posto == null || posto.equals("")) {
            return 0;
        }
	return posto;
    }

    public void setPosto(Integer posto) {
    	Integer oldPosto = this.posto;
	this.posto = posto;
        changeSupport.firePropertyChange("posto", oldPosto, posto);
    }

    public String getNumConta() {
	return numConta;
    }

    public void setNumConta(String numConta) {
    	String oldNumConta = this.numConta;
	this.numConta = numConta;
        changeSupport.firePropertyChange("numConta", oldNumConta, numConta);
    }

    public String getCnpj() {
	return cnpj;
    }

    public void setCnpj(String cnpj) {
	String oldCnpj = this.cnpj;
    	this.cnpj = cnpj;
        changeSupport.firePropertyChange("cpf", oldCnpj, cnpj);
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.codConv);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.agencia);
        hash = 53 * hash + Objects.hashCode(this.posto);
        hash = 53 * hash + Objects.hashCode(this.numConta);
        hash = 53 * hash + Objects.hashCode(this.cnpj);
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
        
        final Empresa other = (Empresa) obj;
        
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.agencia, other.agencia)) {
            return false;
        }
        if (!Objects.equals(this.numConta, other.numConta)) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.codConv, other.codConv)) {
            return false;
        }
        if (!Objects.equals(this.posto, other.posto)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", codConv=" + codConv + ", nome=" + nome + ", agencia=" + agencia + ", posto=" + posto + ", numConta=" + numConta + ", cnpj=" + cnpj + '}';
    }

    public Object[] array(){
        Object array[] = {String.valueOf(getCodConv()),getNome(),getAgencia(),String.valueOf(getPosto()),getNumConta(),getCnpj()};
        return array;
    } 
    
    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("appSwingCrudUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
