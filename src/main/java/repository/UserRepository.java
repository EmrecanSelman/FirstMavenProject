package repository;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IRepository<User> {
    Session s;
    Transaction t;

    @Override
    public void save(User user) {
        s = HibernateUtil.sf.openSession();
        t = s.beginTransaction();
        s.save(user);
        t.commit();
        s.close();
    }

    @Override
    public void delete(int id) {
        s = HibernateUtil.sf.openSession();
        t = s.beginTransaction();
        User user = new User();
        user.setId(id);
        s.delete(user);
        t.commit();
        s.close();
    }

    @Override
    public void update(User user) {
        s = HibernateUtil.sf.openSession();
        t = s.beginTransaction();
        s.update(user);
        t.commit();
        s.close();
    }

    @Override
    public User getModels(long id) {
        s = HibernateUtil.sf.openSession();
        Query q = s.createQuery("FROM User where id =" + id);
        List<User> key = q.getResultList();
        if (key.size() > 0) {
            return key.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<User> getModels(String... params) {
        s = HibernateUtil.sf.openSession();
        if (params[0] != null && params[1] != null) {
            Query q = s.createQuery("FROM User  WHERE name = :name and password = :password ");
            q.setParameter("name",params[0]);
            q.setParameter("password",params[1]);
            List<User> key = q.getResultList();
            return key;
        }
        else
            return new ArrayList<>();
    }


    @Override
    public List<User> getAllModels() {
        s = HibernateUtil.sf.openSession();
        Query q = s.createQuery("FROM User ");
        return q.getResultList();
    }
}
