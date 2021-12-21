import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Deprecated
public class UserRepositoryOld {

    Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class);
    SessionFactory sf = cfg.buildSessionFactory();
    Session session = sf.openSession();

    @Transactional
    public User save(User user){

        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }
    @Transactional
    public List<User> getAllUser(){
      /*  session.getTransaction().begin();
        List userList = session.createQuery("from model.User ").list();
        session.getTransaction().commit();
        session.close();
        return userList;

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<model.User> cq = cb.createQuery(model.User.class);
        Root<model.User> rootEntry = cq.from(model.User.class);
        CriteriaQuery<model.User> all = cq.select(rootEntry);

        TypedQuery<model.User> allQuery = session.createQuery(all);
        return allQuery.getResultList();
 */     session.getTransaction().begin();
        session = sf.openSession();
        Query q = session.createQuery("FROM User ");
        session.getTransaction().commit();
        List<User> ls = q.getResultList();
        return ls;
    }


    public User getUser(long id ){
        Session session = sf.getCurrentSession();
        User ci = (User) session.get(User.class, id);

        return ci;

    }
    @Transactional
    public void updateUser(User updateUser,long id){
        Session session = sf.getCurrentSession();
        User user = (User) session.get(User.class,id);
        if(user!=null){
            user.setName(updateUser.getName());
            user.setPassword(updateUser.getPassword());
            session.update(user);
        } }
    @Transactional
    public void deleteUser(long id){
    Session session = sf.getCurrentSession();
    User user = (User) session.load(User.class,id);
    if(null != user){
        session.delete(user);
    } }

}
