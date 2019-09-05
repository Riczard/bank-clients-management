package pl.kuklinski.clientsManagement.database.dao;

import pl.kuklinski.clientsManagement.database.models.ContactStatus;

import javax.persistence.Query;

public class ContactStatusDao extends CommonDao {

    public ContactStatusDao() {
        super();
    }

    public ContactStatus findByName(String status) {
        Query query = getEntityManager().createQuery("select c from ContactStatus c where c.title like :status");
        query.setParameter("status", status);
        return (ContactStatus) query.getResultStream().findFirst().orElse(null);
    }
}
