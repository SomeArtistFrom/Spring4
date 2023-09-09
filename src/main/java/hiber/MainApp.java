package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
      // UserService userService2 = context.getBean(UserService.class);
       // Car car = new Car("Lada", 16543001);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        //userService.add(n);

//        userService2.addCars(new Car("Lada", 16543001));
//        userService2.addCars(new Car("Scoda Octavia", 543289252));
//        userService2.addCars(new Car("Bus", 543288790));
//        userService2.addCars(new Car("Kia Rio", 1200075111));

       // userService.addCars(Lada);
//        List<Car> cars = userService.listCars();
//        for (Car car : cars) {
//            System.out.println("Id = " + car.getId());
//            System.out.println("Model = " + car.getModel());
//            System.out.println("Serial = " + car.getSeries());
//            System.out.println();
//        }

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
//      if  (users.contains("User1")){
//          int x =users.indexOf("User1");
//          users.add();
//      }

        System.out.println("==");
        context.close();
    }
}
