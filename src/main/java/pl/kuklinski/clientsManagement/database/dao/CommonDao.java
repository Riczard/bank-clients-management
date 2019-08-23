package pl.kuklinski.clientsManagement.database.dao;

import pl.kuklinski.clientsManagement.database.dbutils.DbManager;
import pl.kuklinski.clientsManagement.database.models.BaseModel;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.stream.Stream;

public class CommonDao {

    private final EntityManager entityManager;

    public CommonDao() {
        this.entityManager = DbManager.getEntityManager();
    }

    public <T extends BaseModel> void create(T t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
    }

    public <T extends BaseModel> void update(T t) {
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.getTransaction().commit();
    }

    public <T extends BaseModel> Stream<T> queryForAll(Class<T> cls) {
        CriteriaQuery<T> criteria = getCriteriaQuery(cls);
        Root<T> root = criteria.from(cls);
        criteria.select(root);
        return entityManager.createQuery(criteria).getResultStream();
    }

    public <T, I extends BaseModel> T findById(Class<T> cls, long id) {
        return entityManager.find(cls, id);
    }

    private <T extends BaseModel> CriteriaQuery<T> getCriteriaQuery(Class<T> cls) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        return builder.createQuery(cls);
    }

    public <T extends BaseModel> void delete(T t) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
        entityManager.getTransaction().commit();
    }

    public void closeConnection() {
        entityManager.close();
    }
}
