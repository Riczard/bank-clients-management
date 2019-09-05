package pl.kuklinski.clientsManagement.database.dao;

import pl.kuklinski.clientsManagement.database.models.Relation;

import javax.persistence.Query;

public class RelationDao extends CommonDao {

    public RelationDao() {
        super();
    }

    public Relation findByName(String clientData) {
        Query query = getEntityManager().createQuery("select r from Relation r where r.title like :relation");
        query.setParameter("relation", clientData);
        return (Relation) query.getResultStream().findFirst().orElse(null);
    }
}
