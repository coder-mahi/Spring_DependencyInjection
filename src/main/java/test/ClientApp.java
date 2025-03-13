package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.di.controller.StudentController;

public class ClientApp {
    public static void main(String[] args) {
        //Container obj creation
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentController controller = context.getBean("stController", StudentController.class);
        System.out.println(controller.process("101", "mahesh", "67", "10000", "1000"));
    }
}