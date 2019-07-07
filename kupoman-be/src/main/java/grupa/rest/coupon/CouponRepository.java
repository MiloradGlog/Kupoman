package grupa.rest.coupon;


import grupa.app.HibernateUtil;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static java.lang.reflect.Array.get;

public class CouponRepository {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Coupon getByID(int id){
        Coupon coupon;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        coupon = session.get(Coupon.class, id);

        session.close();

        return coupon;
    }

    public void addCoupon(Coupon coupon){

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(coupon);
        session.getTransaction().commit();
        session.close();

        System.out.println("Uspesno dodat kupon: "+ coupon.getNaziv());
    }

    public void deleteCoupon(int id){

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Coupon coupon = session.get(Coupon.class, id);
        if (coupon == null){
            System.out.println("Nema tog kupona, vrednost je null");
        } else {
            session.lock(coupon, LockMode.OPTIMISTIC_FORCE_INCREMENT);
            session.delete(coupon);
            session.getTransaction().commit();
            System.out.println("Uspesno obrisan kupon: "+ coupon.getNaziv());
        }
        session.close();
    }

}
