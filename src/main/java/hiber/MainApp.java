package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        Car car1 = Car.builder()
                .model("Corolla")
                .series(150)
                .build();
        Car car2 = Car.builder()
                .model("Impreza")
                .series(90)
                .build();
        Car car3 = Car.builder()
                .model("Lancer")
                .series(10)
                .build();
        Car car4 = Car.builder()
                .model("Camry")
                .series(180)
                .build();

        carService.add(car1);
        carService.add(car2);
        carService.add(car3);
        carService.add(car4);

        User user1 = User.builder()
                .firstName("User1")
                .lastName("Lastname1")
                .email("user1@mail.ru")
                .car(car1)
                .build();
        User user2 = User.builder()
                .firstName("User2")
                .lastName("Lastname2")
                .email("user2@mail.ru")
                .car(car2)
                .build();
        User user3 = User.builder()
                .firstName("User3")
                .lastName("Lastname3")
                .email("user3@mail.ru")
                .car(car3)
                .build();
        User user4 = User.builder()
                .firstName("User4")
                .lastName("Lastname4")
                .email("user4@mail.ru")
                .car(car4)
                .build();

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
