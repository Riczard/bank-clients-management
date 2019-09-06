package pl.kuklinski.clientsManagement.javaFX.modelFX;

public class CreditFX {

    private String title;
    private String type;

    public CreditFX() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return title;
    }
}
