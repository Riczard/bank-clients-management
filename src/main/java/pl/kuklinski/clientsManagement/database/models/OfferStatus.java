package pl.kuklinski.clientsManagement.database.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class OfferStatus implements BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String title;

    @OneToMany(mappedBy = "offerStatus")
    private List<Client> clients;

    @PreRemove
    private void setOfferInClientToNull() {
        clients.forEach(client -> client.setOfferStatus(null));
    }

    public OfferStatus() {
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
