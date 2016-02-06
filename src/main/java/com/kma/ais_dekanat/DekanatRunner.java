package com.kma.ais_dekanat;

import com.kma.ais_dekanat.dao.TestUserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by denysburlakov on 06.02.16.
 */
public class DekanatRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        TestUserDAO testUserDAO = applicationContext.getBean(TestUserDAO.class);
        System.out.println(testUserDAO.test());
    }
}
