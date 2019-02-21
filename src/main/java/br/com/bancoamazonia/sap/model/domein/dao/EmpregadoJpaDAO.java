/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.model.domein.dao;

import br.com.bancoamazonia.sap.exception.SapException;
import br.com.bancoamazonia.sap.model.domein.Empregado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author 14207
 */
public class EmpregadoJpaDAO {

    private static EmpregadoJpaDAO instance;
    protected EntityManager entityManager;

    public static EmpregadoJpaDAO getInstance() {
        if (instance == null) {
            instance = new EmpregadoJpaDAO();
        }
        return instance;
    }

    public EmpregadoJpaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("appSwingCrudUnit");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Empregado getById(final int id) {
        return entityManager.find(Empregado.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Empregado> findAll() {
        return entityManager.createQuery("FROM " + Empregado.class.getSimpleName()).getResultList();
    }

    public List<Empregado> findNome(String nome) {
        if (nome == null || nome.trim().equals("")) {
            return findAll();
        }
        return entityManager.createQuery("FROM " + Empregado.class.getSimpleName() + " WHERE nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public boolean findByConstraint(Empregado empregado) {

        int contem = 0;
        contem = entityManager.createQuery("FROM " + Empregado.class.getSimpleName() + " where CPF =:CPF or COD_EMPREGADO =:codigo ").setParameter("CPF", empregado.getCpf()).setParameter("codigo", empregado.getCodEmp()).getResultList().size();

        return contem > 0 ? true : false;
    }

    public void persist(Empregado empregado) throws SapException {
        if (findByConstraint(empregado)) {
            throw new SapException("CPF ou Código de Empregado já utilizado");

        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(empregado);
                entityManager.getTransaction().commit();
            } catch (ConstraintViolationException ex) {
                ex.printStackTrace();
                entityManager.getTransaction().rollback();
                System.out.println("Inserção executada com falha " + empregado.getNome());
            } finally {
                System.out.println("Inserção executada com sucesso " + empregado.getNome());
                entityManager.close();
            }
        }

    }

    public void merge(Empregado empregado) {
        try {
            entityManager.getTransaction().begin();
            System.out.println("empregado" + empregado.toString());
            entityManager.merge(empregado);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Empregado empregado) {
        try {
            entityManager.getTransaction().begin();
            empregado = entityManager.find(Empregado.class, empregado.getId());
            entityManager.remove(empregado);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

//      public void removeById(final int id){
//          try{
//              Empregado empregado = getById(id);
//              remove(empregado);
//          }catch(Exception ex){
//              ex.printStackTrace();
//          }
//      }         
    public static void main(String args[]) {
        EmpregadoJpaDAO d = new EmpregadoJpaDAO();
        List<Empregado> lista = d.findAll();

        System.out.println("lista " + lista.size());
        for (Empregado empregado : lista) {
            System.out.println("empregado =" + empregado.toString());
        }
    }

}
