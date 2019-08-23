package pl.kuklinski.clientsManagement.database.models;

import javax.persistence.*;

@Entity
public class AccountStatus implements BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private String title;

    public AccountStatus() {
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
}
