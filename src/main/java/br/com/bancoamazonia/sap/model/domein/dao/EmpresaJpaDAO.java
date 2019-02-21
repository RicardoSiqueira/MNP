/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bancoamazonia.sap.model.domein.dao;

import br.com.bancoamazonia.sap.exception.SapException;
import br.com.bancoamazonia.sap.model.domein.Empregado;
import br.com.bancoamazonia.sap.model.domein.Empresa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 14207
 */
public class EmpresaJpaDAO {

    private static EmpresaJpaDAO instance;
    protected EntityManager entityManager;

    public static EmpresaJpaDAO getInstance() {
        if (instance == null) {
            instance = new EmpresaJpaDAO();
        }
        return instance;
    }

    public EmpresaJpaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("appSwingCrudUnit");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Empresa getById(final int id) {
        return entityManager.find(Empresa.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Empresa> findAll() {
        return entityManager.createQuery("FROM " + Empresa.class.getName()).getResultList();
    }

    public List<Empresa> findNome(String nome) {
        if (nome == null || nome.trim().equals("")) {
            return findAll();
        }
        return entityManager.createQuery("FROM " + Empresa.class.getSimpleName() + " WHERE nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public boolean findByConstraint(Empresa empresa) {

        int contem = 0;
        contem = entityManager.createQuery("FROM " + Empresa.class.getSimpleName() + " where CNPJ =:CNPJ or COD_CONVENIO =:codigo ").setParameter("CNPJ", empresa.getCnpj()).setParameter("codigo", empresa.getCodConv()).getResultList().size();

        return contem > 0 ? true : false;
    }

    public void persist(Empresa empresa) throws SapException {
        if (findByConstraint(empresa)) {
            throw new SapException("CNPJ ou Código do Convênio já utilizado");
        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(empresa);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                entityManager.getTransaction().rollback();
                System.out.println("Inserção falhou " + empresa.getNome());
            } finally {
                System.out.println("Inserção feita com sucesso " + empresa.getNome());
            }
        }

    }

    public void merge(Empresa empresa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(empresa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Empresa empresa) {
        try {
            entityManager.getTransaction().begin();
            empresa = entityManager.find(Empresa.class, empresa.getId());
            entityManager.remove(empresa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Empresa empresa = getById(id);
            remove(empresa);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        EmpresaJpaDAO d = new EmpresaJpaDAO();
        List<Empresa> lista = d.findAll();

        System.out.println("lista " + lista.size());
        for (Empresa empresa : lista) {
            System.out.println("empresa = " + empresa.toString());
        }
    }
}
