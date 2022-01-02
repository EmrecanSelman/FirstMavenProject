package repository;

import model.Order;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class OrderRepository implements IRepository<Order>{

    Session s;
    Transaction t;
    private OrderRepository() {}
    private static OrderRepository instance;
    public static OrderRepository getInstance()
    {
        if (instance == null)
            instance = new OrderRepository();

        return instance;
    }


    @Override
    public void save(Order model) {
        s = HibernateUtil.getSf().openSession();
        t = s.beginTransaction();
        s.save(model);
        t.commit();
        s.close();
    }

    @Override
    public void delete(int id) {
        s = HibernateUtil.getSf().openSession();
        t = s.beginTransaction();
        Order order = new Order();
        order.setIdorder(id);
        s.delete(order);
        t.commit();
        s.close();
    }

    @Override
    public void update(Order model) {
        s = HibernateUtil.getSf().openSession();
        t = s.beginTransaction();
        s.update(model);
        t.commit();
        s.close();
    }

    @Override
    public Order getModels(long id) {
        s = HibernateUtil.getSf().openSession();
        Query q = s.createQuery("FROM User where id = " + id);
        List<Order> key = q.getResultList();


        if (key.size() > 0) {
            return key.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Order> getModels(String... params) {
        return null;
    }

    @Override
    public List<Order> getAllModels() {
        return null;
    }
}
