package junia.lab04.core.entity;

import javax.persistence.Entity;

@Entity
public class Product extends GenericEntity{


    private String name;
    private String type;
    private String note;
    private String status;
    private long ownerID;

    public Product() {
    }

    public long getOwnerID() { return ownerID; }

    public void setOwnerID(long ownerID) { this.ownerID = ownerID; }

    public String getNote() { return note; }

    public void setNote(String note) { this.note = note; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getType() { return type; }

    public void setType(String articleType) { this.type = articleType; }

    public String getName() {
        return name;
    }


    public void setName(final String nameValue) {
        name = nameValue;
    }




}
