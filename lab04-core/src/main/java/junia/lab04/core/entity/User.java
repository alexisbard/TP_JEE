package junia.lab04.core.entity;

import javax.persistence.Entity;

@Entity
public class User extends GenericEntity {

    private String name;
    private String forname;
    private int age;
    private String pseudo;


    public User() {
    }

    public User(String name, String forname, int age, String pseudo) {
        this.name = name;
        this.forname = forname;
        this.age = age;
        this.pseudo = pseudo;
    }


    public String getName() {
        return name;
    }


    public void setName(final String nameValue) {
        name = nameValue;
    }


    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
