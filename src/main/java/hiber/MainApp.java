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

        Car car1 = new Car("Corolla", 150);
        Car car2 = new Car("Impreza", 90);
        Car car3 = new Car("Lancer", 10);
        Car car4 = new Car("Camry", 180);
        userService.add(car1);
        userService.add(car2);
        userService.add(car3);
        userService.add(car4);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        user4.setCar(car4);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> users1 = userService.listUsers();
        for (User user : users1) {
            System.out.println(user);
        }

        List<User> users2 = userService.listUsersByCar("Corolla", 150);
        for (User user : users2) {
            System.out.println(user + " has " + user.getCar());
        }

        context.close();
    }
}