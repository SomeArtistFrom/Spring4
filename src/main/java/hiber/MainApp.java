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

        Car car1 = new Car("Kia Rio", 16543001);
        Car car2 = new Car("Skoda Octavia", 54738282);
        Car car3 = new Car("Lada", 6353);
        User user1 = new User("Inna", "Polovinchik", "user1@mail.ru");
        User user2 = new User("Irina", "Vyu", "user2@mail.ru");

        user1.setCar(car1);
        user2.setCar(car2);

        userService.add(user1);
        userService.add(user2);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().toString());
            System.out.println();
        }

        userService.findUser(car1);
        userService.findUser(car2);
        userService.findUser(car3);

        System.out.println("==");
        context.close();
    }
}
