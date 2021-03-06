package com.kma.ais_dekanat;

import com.kma.ais_dekanat.model.Department;
import com.kma.ais_dekanat.service.DepartmentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring/applicationContext.xml")
public class Application {

    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(Application.class, args);

        Department finalTestList = Application.ctx.getBean(DepartmentService.class).getDepartmentById(1); //TODO nira this is not ok
        System.out.println("" + finalTestList.getName());
    }
}
