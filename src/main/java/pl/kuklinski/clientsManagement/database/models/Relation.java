package pl.kuklinski.clientsManagement.database.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Relation")
public class Relation implements BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String title;

    @OneToMany(mappedBy = "relation")
    private List<Client> clients;

    @PreRemove
    private void setRelationInClientToNull() {
        clients.forEach(client -> client.setRelation(null));
    }

    public Relation() {
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
