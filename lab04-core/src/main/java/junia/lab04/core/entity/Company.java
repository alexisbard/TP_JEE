package junia.lab04.core.entity;

import javax.persistence.Entity;

@Entity
public class Company extends GenericEntity{


    private String name;
    private String articleType;
    private String note;
    private String status;

    public Company() {
    }

    public String getNote() { return note; }

    public void setNote(String note) { this.note = note; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getArticleType() { return articleType; }

    public void setArticleType(String articleType) { this.articleType = articleType; }

    public String getName() {
        return name;
    }


    public void setName(final String nameValue) {
        name = nameValue;
    }




}
