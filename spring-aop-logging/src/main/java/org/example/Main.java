package org.example;

import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        UserService userService = context.getBean(UserService.class);

        // TODO:注册用到了mailService
        userService.register("test@example.com", "password", "test");
        // TODO:登录也用到了mailService
        userService.login("bob@example.com", "password");
        // UserService class name: UserService$$SpringCGLIB$$0:
        System.out.println(userService.getClass().getName());
    }
}