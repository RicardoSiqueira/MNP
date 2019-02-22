package br.com.bancoamazonia.sap.model.domein.dao;

import br.com.bancoamazonia.sap.exception.SapException;
import br.com.bancoamazonia.sap.model.domein.Sistema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author 14210
 */
public class SistemaJpaDAO {

    private static SistemaJpaDAO instance;
    protected EntityManager entityManager;

    public static SistemaJpaDAO getInstance() {
        if (instance == null) {
            instance = new SistemaJpaDAO();
        }
        return instance;
    }

    public SistemaJpaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("appSwingCrudUnit");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    @SuppressWarnings("unchecked")
    public List<Sistema> findAll() {
        return entityManager.createQuery("FROM " + Sistema.class.getSimpleName()).getResultList();
    }

    public boolean findByConstraint(Sistema sistema) {
        int contem = 0;
        String qlString = "FROM " + Sistema.class.getSimpleName() + " where NOME =:nome or COD_SISTEMA =:codigo or DESCRICAO =:descricao";
        Query query = entityManager.createQuery(qlString);
        query.setParameter("nome", sistema.getNome());
        query.setParameter("codigo", sistema.getcodSistema());
        query.setParameter("descricao", sistema.getDescricao());
        contem = query.getResultList().size();

        return contem > 0 ? true : false;
    }

    public void persist(Sistema sistema) throws SapException {
        if (findByConstraint(sistema)) {
            throw new SapException("Código da Sistema ou Nome já utilizado");
        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(sistema);
                entityManager.getTransaction().commit();
            } catch (ConstraintViolationException ex) {
                ex.printStackTrace();
                entityManager.getTransaction().rollback();
                System.out.println("Inserção executada com falha " + sistema.getNome());
            } finally {
                System.out.println("Inserção executada com sucesso " + sistema.getNome());
//                entityManager.close();
            }
        }
    }

    public void remove(Sistema sistema) {
        try {
            entityManager.getTransaction().begin();
            sistema = entityManager.find(Sistema.class, sistema.getId());
            entityManager.remove(sistema);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}
