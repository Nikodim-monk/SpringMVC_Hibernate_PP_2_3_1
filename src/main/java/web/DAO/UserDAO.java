package web.DAO;

import web.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private long SCH;
    private List<User> users = new ArrayList<>();

    {
        users.add(new User(++SCH, "Андрей", (byte) 46));
        users.add(new User(++SCH, "Иван", (byte) 50));
        users.add(new User(++SCH, "Сидор", (byte) 54));
        users.add(new User(++SCH, "Michael", (byte) 30));
        users.add(new User(++SCH, "John", (byte) 36));
    }

    public List<User> getAllUsers() {
        return users;
    }
    public User getUserById(int id) {
        return users.get(id-1);
    }

    public void addNewUser(User user) {
        user.setId(++SCH);
        users.add(user);
    }

}
