package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }


//   @Transactional
//   @Override
//   public void addCars(Car car) {
//      userDao.addCars(car);
//   }
//
//   @Transactional(readOnly = true)
//   @Override
//   public List<Car> listCars() {
//      return userDao.listCars();
//   }

}
