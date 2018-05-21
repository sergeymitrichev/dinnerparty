package ru.ftob.dinnerparty;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.ftob.dinnerparty.model.User;
import ru.ftob.dinnerparty.service.UserService;
import ru.ftob.dinnerparty.service.UserServiceImpl;

import java.util.Arrays;
import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 Automatic resource management
        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.getEnvironment().setActiveProfiles(Profiles.getActiveDbProfile(), Profiles.REPOSITORY_IMPLEMENTATION);
            appCtx.load("spring/spring-app.xml", "spring/spring-db.xml");
            appCtx.refresh();
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            UserService userService = appCtx.getBean(UserServiceImpl.class);
            List<User> users = userService.getAll();
            users.forEach(System.out::println);
        }
    }
}
