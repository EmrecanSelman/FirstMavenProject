package repository;

import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {


    private static  final SessionFactory sessionFactory = buildSessionFactory();



    private static  SessionFactory buildSessionFactory() {
        try {
            Configuration cfg = new Configuration();
            SessionFactory sessionFactory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
            return sessionFactory;
        } catch (Exception ex) {

            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSf() {
        return sessionFactory;
    }

}


