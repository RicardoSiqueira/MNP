package br.com.bancoamazonia.sap.model.domein;

import br.com.bancoamazonia.sap.model.domein.constante.EstadoEnum;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 14207
 */
@Entity
@Table(name = "EMPREGADOS")
public class Empregado implements AbstractEntity, Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "COD_EMPREGADO", unique = true)
    private Integer codEmp;

    @NotNull
    @Column(name = "NOME")
    private String nome;

    @NotNull
    @Column(name = "AGENCIA")
    private String agencia;

    @Column(name = "POSTO")
    private Integer posto;

    @NotNull
    @Column(name = "NUM_CONTA")
    private String numConta;

    @NotNull
    @Column(name = "SALARIO")
    private Double salario;

    /*@Column(name = "TIPO_CONTA")
    private String tipoConta;*/
    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "CIDADE")
    private String cidade;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ESTADO")
    private EstadoEnum estado;

    @Column(name = "CPF", unique = true)
    private String cpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Integer getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(Integer codEmp) {
        Integer oldCodEmp = this.codEmp;
        this.codEmp = codEmp;
        changeSupport.firePropertyChange("codEmp", oldCodEmp, codEmp);
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
        if (posto == null || posto.equals(null)) {
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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        Double oldSalario = this.salario;
        this.salario = salario;
        changeSupport.firePropertyChange("salario", oldSalario, salario);
    }

    public String getEndereco() {
        if (endereco == null || endereco.equals(null)) {
            return "";
        }
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
    }

    public Integer getNumero() {
        if (numero == null || numero.equals(null)) {
            return 0;
        }
        return numero;
    }

    public void setNumero(Integer numero) {
        Integer oldNumero = this.numero;
        this.numero = numero;
        changeSupport.firePropertyChange("numero", oldNumero, numero);
    }

    public String getComplemento() {
        if (complemento == null || complemento.equals(null)) {
            return "";
        }
        return complemento;
    }

    public void setComplemento(String complemento) {
        String oldComplemento = this.complemento;
        this.complemento = complemento;
        changeSupport.firePropertyChange("complemento", oldComplemento, complemento);
    }

    public String getBairro() {
        if (bairro == null || bairro.equals(null)) {
            return "";
        }
        return bairro;
    }

    public void setBairro(String bairro) {
        String oldBairro = this.bairro;
        this.bairro = bairro;
        changeSupport.firePropertyChange("bairro", oldBairro, bairro);
    }

    public String getCep() {
        if (cep == null || cep.equals(null)) {
            return "";
        }
        return cep;
    }

    public void setCep(String cep) {
        String oldCep = this.cep;
        this.cep = cep;
        changeSupport.firePropertyChange("cep", oldCep, cep);
    }

    public String getCidade() {
        if (cidade == null || cidade.equals(null)) {
            return "";
        }
        return cidade;
    }

    public void setCidade(String cidade) {
        String oldCidade = this.cidade;
        this.cidade = cidade;
        changeSupport.firePropertyChange("cidade", oldCidade, cidade);
    }

    public EstadoEnum getEstado() {
//	if (estado == null || estado.equals(estado.SELECIONE)) {
//            return estado.SELECIONE;
//        }
        return estado;
    }

    public void setEstado(EstadoEnum estado) {
        EstadoEnum oldEstado = this.estado;
        this.estado = estado;
        changeSupport.firePropertyChange("estado", oldEstado, estado);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.codEmp);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.agencia);
        hash = 53 * hash + Objects.hashCode(this.posto);
        hash = 53 * hash + Objects.hashCode(this.numConta);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.endereco);
        hash = 53 * hash + Objects.hashCode(this.numero);
        hash = 53 * hash + Objects.hashCode(this.complemento);
        hash = 53 * hash + Objects.hashCode(this.bairro);
        hash = 53 * hash + Objects.hashCode(this.cep);
        hash = 53 * hash + Objects.hashCode(this.cidade);
        hash = 53 * hash + Objects.hashCode(this.estado);
        hash = 53 * hash + Objects.hashCode(this.cpf);
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
        final Empregado other = (Empregado) obj;
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.agencia, other.agencia)) {
            return false;
        }
        if (!Objects.equals(this.numConta, other.numConta)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.codEmp, other.codEmp)) {
            return false;
        }
        if (!Objects.equals(this.posto, other.posto)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empregado{" + "id=" + id + ", codEmp=" + codEmp + ", nome=" + nome + ", agencia=" + agencia + ", posto=" + posto + ", numConta=" + numConta + ", salario=" + salario + ", endereco=" + endereco + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", estado=" + estado + ", cpf=" + cpf + '}';
    }

    public Object[] array() {
        Object array[] = {String.valueOf(getCodEmp()), getNome(), getAgencia(), String.valueOf(getPosto()), getNumConta(), String.valueOf(getSalario()), getEndereco(), String.valueOf(getNumero()), getComplemento(), getBairro(), getCep(), getCidade(), getEstado().name(), getCpf()};
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
