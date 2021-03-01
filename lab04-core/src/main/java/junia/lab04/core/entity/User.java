package junia.lab04.core.entity;

import javax.persistence.Entity;

@Entity
public class User extends GenericEntity {

    private String name;
    private String surname;
    private int age;
    private String pseudo;

    public User() {
    }

    public String getName() {
        return name;
    }


    public void setName(final String nameValue) {
        name = nameValue;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
