package pl.kuklinski.clientsManagement.database.dao;

import pl.kuklinski.clientsManagement.database.models.Client;

import javax.persistence.Query;
import java.util.Optional;

public class ClientDao extends CommonDao {

    public ClientDao() {
        super();
    }

    public Client findByPesel(String pesel) {
        Query query = getEntityManager().createQuery("select c from Client c where c.pesel like :pesel");
        query.setParameter("pesel", pesel.trim());
        return (Client) query.getResultList().stream().findFirst().orElse(null);
    }
}
