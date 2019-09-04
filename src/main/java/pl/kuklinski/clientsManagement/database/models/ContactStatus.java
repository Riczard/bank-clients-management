package pl.kuklinski.clientsManagement.database.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "AccStatus")
public class ContactStatus implements BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String title;

    @OneToMany(mappedBy = "status")
    private List<Client> clients;

    public ContactStatus() {
    }

    @PreRemove
    private void setStatusInClientToNull() {
        clients.forEach(client -> client.setStatus(null));
    }

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
