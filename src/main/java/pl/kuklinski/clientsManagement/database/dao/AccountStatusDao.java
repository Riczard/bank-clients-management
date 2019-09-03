package pl.kuklinski.clientsManagement.database.dao;

import pl.kuklinski.clientsManagement.database.models.AccountStatus;

import javax.persistence.Query;

public class AccountStatusDao extends CommonDao {

    public AccountStatusDao() {
        super();
    }

    public AccountStatus findByName(String status) {
        Query query = getEntityManager().createQuery("select a from AccStatus a where a.title like :status");
        query.setParameter("status", status);
        return (AccountStatus) query.getResultStream().findFirst().orElse(null);
    }
}
