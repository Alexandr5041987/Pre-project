package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;


public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Name1", "Surname1", "Email1@gmail.com");
      User user2 = new User("Name2", "Surname2", "Email2@gmail.com");
      User user3 = new User("Name3", "Surname3", "Email3@gmail.com");
      User user4 = new User("Name4", "Surname4", "Email4@gmail.com");

      Car car1 = new Car("Car1", 2024);
      Car car2 = new Car("Car2", 2000);
      Car car3 = new Car("Car3", 2);
      Car car4 = new Car("Car4", 1);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));

      for (User user : userService.listUsers()) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car= " + user.getCar());
         System.out.println();
      }

      System.out.println(userService.getUserByCar("Car4", 1));
      context.close();
   }
}
