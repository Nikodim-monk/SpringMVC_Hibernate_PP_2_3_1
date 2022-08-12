package model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "age")
    private byte Age;

    public User() {
    }

    public User(Long id, String name, byte age) {
        this.Id = id;
        Name = name;
        this.Age = age;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public byte getAge() {
        return Age;
    }

    public void setAge(byte age) {
        this.Age = age;
    }
}
