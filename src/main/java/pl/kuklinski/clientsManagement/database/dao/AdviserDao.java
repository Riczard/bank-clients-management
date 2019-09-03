package pl.kuklinski.clientsManagement.database.dao;

import pl.kuklinski.clientsManagement.database.models.Adviser;

import javax.persistence.Query;

public class AdviserDao extends CommonDao{

    public AdviserDao() {
        super();
    }

    public Adviser findByNameAndSurname(String[] adviserData) {
        Query query = getEntityManager().createQuery("select a from Adviser a where a.name like :name AND  a.surname like :surname");
        query.setParameter("name", adviserData[0]);
        query.setParameter("surname", adviserData[1]);
        return (Adviser) query.getResultStream().findFirst().orElse(null);
    }
}
