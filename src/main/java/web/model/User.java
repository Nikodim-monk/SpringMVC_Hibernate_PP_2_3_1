package web.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private int Id;
    @Column(name = "UserName")
//    @NotEmpty
    private String Name;
    @Column(name = "UserAge")
    private byte Age;

    public User() {
    }

    public User(String name, byte age) {
        this.Name = name;
        this.Age = age;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
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
