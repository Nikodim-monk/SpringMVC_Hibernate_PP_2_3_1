package web.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import web.model.User;
import web.util.Util;

import java.util.List;

public class UserDAO {

    private SessionFactory sessionFactory = Util.mineHiberConnection();

    {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users " +
                            "(UserID INT PRIMARY KEY AUTO_INCREMENT, UserName varchar(15), UserAge int)")
                    .addEntity(User.class).executeUpdate();
//            session.save(new User( "Андрей", (byte) 46));
//            session.save(new User( "Иван", (byte) 50));
//            session.save(new User( "Сидор", (byte) 54));
//            session.save(new User( "Michael", (byte) 30));
//            session.save(new User("John", (byte) 36));
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> users;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            users = session.createQuery("SELECT i FROM User i", User.class).getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
    public User getUserById(int id) {
        User user = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            try {
                session.beginTransaction();
                user = session.get(User.class, id);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                throw new RuntimeException(e);
            }
        }
        return user;
    }
    public void addNewUser(User user) {
        try (Session session = sessionFactory.getCurrentSession()) {
            try {
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                session.createSQLQuery("rollback").executeUpdate();
                throw new RuntimeException(e);
            }
        }
    }
    public void updateUser(User user, int id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            try {
                session.beginTransaction();
                User updateUser = session.get(User.class, id);
                updateUser.setName(user.getName());
                updateUser.setAge(user.getAge());
                session.getTransaction().commit();
            } catch (HibernateException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void UserDelete(int id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            try {
                session.beginTransaction();
                session.remove(session.get(User.class, id));
                session.getTransaction().commit();
            } catch (HibernateException e) {
                session.createSQLQuery("rollback").executeUpdate();
                throw new RuntimeException(e);
            }
        }
    }
}
