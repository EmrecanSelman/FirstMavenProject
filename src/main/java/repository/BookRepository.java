package repository;

import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.HibernateUtil;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IRepository<Book> {
    Session s;
    Transaction t;

    @Override
    public void save(Book book) {
        s = HibernateUtil.sf.openSession();
        t = s.beginTransaction();
        s.save(book);
        t.commit();
        s.close();
    }

    @Override
    public void delete(int id) {
        s = HibernateUtil.sf.openSession();
        t = s.beginTransaction();
        Book book = new Book();
        book.setId(id);
        s.delete(book);
        t.commit();
        s.close();
    }

    @Override
    public void update(Book book) {
        s = HibernateUtil.sf.openSession();
        t = s.beginTransaction();
        s.update(book);
        t.commit();
        s.close();
    }

    @Override
    public Book getModels(long id) {
        s = HibernateUtil.sf.openSession();
        Query q = s.createQuery("FROM Book where id =" + id);
        List<Book> key = q.getResultList();
        if (key.size() > 0) {
            return key.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Book> getModels(String... params) {
        s = HibernateUtil.sf.openSession();
        if (params[0] != null && params[1] != null) {
            Query q = s.createQuery("FROM Book  WHERE bookname = :name and writername = :password ");
            q.setParameter("name",params[0]);
            q.setParameter("password",params[1]);
            List<Book> key = q.getResultList();
            return key;
        }
        else
            return new ArrayList<>();
    }


    @Override
    public List<Book> getAllModels() {
        s = HibernateUtil.sf.openSession();
        Query q = s.createQuery("FROM Book ");
        return q.getResultList();
    }
}
