package fr.jmottez.lessons.spring.spring4;

import fr.jmottez.lessons.spring.spring4.user.domain.model.UserModel;
import fr.jmottez.lessons.spring.spring4.user.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class RunnerApplication {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfiguration.class);

		UserService userService = (UserService) context.getBean("userService");

		UserModel model0 = new UserModel();
		model0.setFirstName("John");
		model0.setLastName("Doe");
		userService.save(model0);

		UserModel model1 = new UserModel();
		model1.setFirstName("John123");
		model1.setLastName("Doe123");
		userService.save(model1);

		List<UserModel> users = userService.findAll();
		users.stream().forEach(user -> System.out.println("user:" + user.getFirstName() + " " + user.getLastName()));

	}

}
