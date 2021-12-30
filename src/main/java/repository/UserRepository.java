package repository;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IRepository<User> {
    Session s;
    Transaction t;
    private UserRepository() {}
    private static UserRepository instance;
    public static UserRepository getInstance()
    {
        if (instance == null)
            instance = new UserRepository();

        return instance;
    }


    @Override
    public void save(User user) {
        s = HibernateUtil.getSf().openSession();
        t = s.beginTransaction();
        s.save(user);
        t.commit();
        s.close();
    }

    @Override
    public void delete(int id) {
        s = HibernateUtil.getSf().openSession();
        t = s.beginTransaction();
        User user = new User();
        user.setId(id);
        s.delete(user);
        t.commit();
        s.close();
    }

    @Override
    public void update(User user) {
        s = HibernateUtil.getSf().openSession();
        t = s.beginTransaction();
        s.update(user);
        t.commit();
        s.close();
    }

    @Override
    public User getModels(long id) {
        s = HibernateUtil.getSf().openSession();
      /*  CriteriaBuilder cr = s.getCriteriaBuilder();
        CriteriaQuery <User> criteriaQuery = cr.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);
        Predicate likeRestriction = cr.and(
                cr.equal(userRoot.get("id"),id));
        criteriaQuery.select(userRoot).where(likeRestriction);
        TypedQuery<User> query =s.createQuery(criteriaQuery);
         List<User> key =  query.getResultList();
       */
        Query q = s.createQuery("FROM User where id = " + id);
        List<User> key = q.getResultList();


        if (key.size() > 0) {
            return key.get(0);
        } else {
            return null;
        }
    }



    @Override
    public List<User> getModels(String... params) {
        s = HibernateUtil.getSf().openSession();
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
        s = HibernateUtil.getSf().openSession();
        Query q = s.createQuery("FROM User ");
        return q.getResultList();
    }
}
