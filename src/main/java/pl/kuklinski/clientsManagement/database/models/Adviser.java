package pl.kuklinski.clientsManagement.database.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Adviser")
public class Adviser implements BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @OneToMany(mappedBy = "adviser")
    private List<Client> clients;

    @PreRemove
    private void setAdviserInClientToNull() {
        clients.forEach(client -> client.setAdviser(null));
    }

    public Adviser() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public String getAdviserFullName() {
        return name + " " + surname;
    }
}
