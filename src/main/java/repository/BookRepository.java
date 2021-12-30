package repository;

import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class BookRepository implements IRepository<Book> {
    Session s;
    Transaction t;
    private BookRepository() {}
    private static BookRepository instance;
    public static BookRepository getInstance()
    {
        if (instance == null)
            instance = new BookRepository();

        return instance;
    }

    @Override
    public void save(Book book) {
        s = HibernateUtil.getSf().openSession();
        t = s.beginTransaction();
        s.persist(book);
        t.commit();
        s.close();
    }

    @Override
    public void delete(int id) {
        s = HibernateUtil.getSf().openSession();
        t = s.beginTransaction();
        Book book = new Book();
        book.setId(id);
        s.delete(book);
        t.commit();
        s.close();
    }

    @Override
    public void update(Book book) {
        s = HibernateUtil.getSf().openSession();
        t = s.beginTransaction();
        s.update(book);
        t.commit();
        s.close();
    }

    @Override
    public Book getModels(long id) {
        s = HibernateUtil.getSf().openSession();
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

        /* ObservableList<Book> bookObservableListList = FXCollections.observableArrayList();
        s = HibernateUtil.sf.openSession();
        List<Book> eList = s.
                createCriteria(Book.class).list();
        for (Book ent : eList) {
            bookObservableListList.add(ent);
        }
        return bookObservableListList; */
            s = HibernateUtil.getSf().openSession();
            Query q = s.createQuery("FROM Book  WHERE bookname =:bookname and writer = :writer and pagenumber = :pagenumber ");
            q.setParameter("bookname", params[0]);
            q.setParameter("writer", params[1]);
            q.setParameter("pagenumber", params[1]);
            List<Book> key = q.getResultList();
            return  key;

//like command in sql
    }
        @Override
        public List<Book> getAllModels () {
            s = HibernateUtil.getSf().openSession();
            Query q = s.createQuery("FROM Book ");
            return q.getResultList();
        }
    }

