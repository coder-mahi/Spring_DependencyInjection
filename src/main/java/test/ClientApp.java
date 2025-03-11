package test;
import org.springframework.beans.factory.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;
import com.di.controller.*;
public class ClientApp {
    public static void main(String[] args){
        BeanFactory  factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentController controller = factory.getBean("stController",StudentController.class);
        System.out.println(controller.process("101","mahesh","67","10000","1000"));
    }
}
