
package br.com.bancoamazonia.sap.model.domein.dao;

import br.com.bancoamazonia.sap.exception.SapException;
import br.com.bancoamazonia.sap.model.domein.Envolvidos;
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
public class EnvolvidosJpaDAO {
    
private static  EnvolvidosJpaDAO instance;
    protected EntityManager entityManager;

    public static  EnvolvidosJpaDAO getInstance() {
        if (instance == null) {
            instance = new  EnvolvidosJpaDAO();
        }
        return instance;
    }

    public  EnvolvidosJpaDAO() {
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
    public List<Envolvidos> findAll() {
        return entityManager.createQuery("FROM " + Envolvidos.class.getSimpleName()).getResultList();
    }

    public boolean findByConstraint(Envolvidos envolvidos) {
        int contem = 0;
        String qlString = "FROM " + Envolvidos.class.getSimpleName() + " where GESTOR_NEGOCIO =:GestorNegocio or GESTOR_TECNICO =:GestorTecnico or ANALISTA =:analista or COORDENADOR =:coordenador";
        Query query = entityManager.createQuery(qlString);
        query.setParameter("GestorNegocio", envolvidos.getGestornegocio());
        query.setParameter("GestorTecnico", envolvidos.getGestortecnico());
        query.setParameter("analista", envolvidos.getAnalista());
        query.setParameter("coordenador", envolvidos.getCoordenador());
        
        contem = query.getResultList().size();

        return contem > 0 ? true : false;
    }

    public void persist(Envolvidos envolvidos) throws SapException {
        if (findByConstraint(envolvidos)) {
            throw new SapException("Código da Sistema ou Nome já utilizado");
        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(envolvidos);
                entityManager.getTransaction().commit();
            } catch (ConstraintViolationException ex) {
                ex.printStackTrace();
                entityManager.getTransaction().rollback();
                System.out.println("Inserção executada com falha " + envolvidos.getGestornegocio());
            } finally {
                System.out.println("Inserção executada com sucesso " + envolvidos.getGestornegocio());
//                entityManager.close();
            }
        }
    }

    public void remove(Envolvidos  envolvidos ) {
        try {
            entityManager.getTransaction().begin();
            envolvidos = entityManager.find(Envolvidos.class, envolvidos.getId());
            entityManager.remove(envolvidos);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}

    

