package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void findUser(Car car) {
        Object carOwner;
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT u FROM User u " +
                        "WHERE u.car.model = :model AND u.car.series = :series", User.class);
        query.setParameter("model", car.getModel());
        query.setParameter("series", car.getSeries());

        List<Object> results = query.getResultList();
        if (!results.isEmpty()) {
            carOwner = results.get(0);
            System.out.println("Владелец машины " + car.toString() + " = " + carOwner.toString() + '\n');
        } else {
            System.out.println("Владельца машины " + car.toString() + " не найдено." + '\n');
        }
    }
}