package DAO;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private List<User> users = new ArrayList<>();

    {
        users.add(new User(1l, "Андрей", (byte) 46));
        users.add(new User(2l, "Иван", (byte) 50));
        users.add(new User(3l, "Сидор", (byte) 54));
        users.add(new User(4l, "Michael", (byte) 30));
        users.add(new User(5l, "John", (byte) 36));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.get(id - 1);
    }

    public void addNewUser(User user) {
        user.setId((long) users.size()+1);
        users.add(user);
    }

    public void updateUser(User user, int id) {
        User userNotUpdate = getUserById(id);
        userNotUpdate.setName(user.getName());
        userNotUpdate.setAge(user.getAge());
    }

    public void UserDelete(int id) {
        users.remove(id - 1);
        for (int i = 0; i < users.size(); i++) {
            users.get(i).setId((long) (i+1));
        }
    }
}
