package web.DAO;

import web.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static long SCH;
    private List<User> users = new ArrayList<>();

    {
        users.add(new User(++SCH, "Андрей", (byte) 46));
        users.add(new User(++SCH, "Иван", (byte) 50));
        users.add(new User(++SCH, "Сидор", (byte) 54));
        users.add(new User(++SCH, "Michael", (byte) 30));
        users.add(new User(++SCH, "John", (byte) 36));
    }

    public List<User> getCars(byte count) {
        return users.subList(0, count);
    }
}
