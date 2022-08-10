package web.model;

public class User {

    private Long id;

    private String Name;

    private byte age;

    public User() {
    }

    public User(Long id, String name, byte age) {
        this.id = id;
        Name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }
}
