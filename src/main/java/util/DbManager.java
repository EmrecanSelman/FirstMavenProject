package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.autoconfigure.security.SecurityProperties;


import java.util.List;

public class DbManager {

    private static DbManager instance = null;

   public SessionFactory sessionFactory;
    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private DbManager()
    {

        // configures settings from hibernate.cfg.xml
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        Session session = sessionFactory.getCurrentSession();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session.beginTransaction();

            List users = session.createQuery("from User").getResultList();
            session.save(users);
        } catch (Exception e) {
            // handle the exception
        }
    }

    // Static method
    // Static method to create instance of Singleton class
    public static DbManager getInstance()
    {
        if (instance == null)
            instance = new DbManager();


        return instance;
    }

}
