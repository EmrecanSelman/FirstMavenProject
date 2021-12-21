package repository;

import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
       static  final SessionFactory sf;
static {
    try{
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class);
       sf = cfg.buildSessionFactory();

    }catch (Throwable ex){
        throw new ExceptionInInitializerError(ex);
    }


}

}
