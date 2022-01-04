package repository;


import model.Order;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IRepository<Order>{
    public  final int MAX_BOOOK_COUNT=1;
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
        Query q = s.createQuery("FROM Order where idorder = " + id);
        List<Order> key = q.getResultList();


        if (key.size() > 0) {
            return key.get(0);
        } else {
            return null;
        }
    }

    public boolean canBeOrder(User user) {
        return   getBookNumberOnUser(user)<MAX_BOOOK_COUNT;
    }

    private int getBookNumberOnUser(User user) {
        s = HibernateUtil.getSf().openSession();

        Query q = s.createQuery("FROM Order  WHERE user.id = :userid and status = : status");
        q.setParameter("userid", user.getId());
        q.setParameter("status", Order.OrderStatus.GIVEN.getType());
        return q.getResultList().size();
    }

    @Override
    public List<Order> getModels(String... params) {
        s = HibernateUtil.getSf().openSession();
        if (params[0] != null && params[1] != null) {
            Query q = s.createQuery("FROM Order  WHERE book.id =:bookid and user.id = :userid and giventime = :giventime and status = : status");
            q.setParameter("bookid", params[0]);
            q.setParameter("userid", params[1]);
            q.setParameter("giventime", params[2]);
            q.setParameter("status", params[3]);
            List<Order> key = q.getResultList();
            return key;
        }
        else
            return new ArrayList<>();
    }

    @Override
    public List<Order> getAllModels() {
        s = HibernateUtil.getSf().openSession();
        Query q = s.createQuery("FROM Order " );
        List<Order> key = q.getResultList();


        if (key.size() > 0) {
            return key;
        } else {
            return null;
        }
    }
}
