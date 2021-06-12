package ma.atmar.AppAtmar.HelperClasses;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Produits implements Serializable {
    int id;
    String title , description;

    public Produits(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
