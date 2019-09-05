package pl.kuklinski.clientsManagement.database.dao;

import pl.kuklinski.clientsManagement.database.models.OfferStatus;

import javax.persistence.Query;

public class OfferStatusDao extends CommonDao{

    public OfferStatusDao() {
        super();
    }

    public OfferStatus findByName(String name) {
        Query query = getEntityManager().createQuery("select o from OfferStatus o where o.title=:name");
        query.setParameter("name", name);
        return (OfferStatus) query.getResultStream().findFirst().orElse(null);
    }
}
