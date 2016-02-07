package com.kma.ais_dekanat;

import com.kma.ais_dekanat.dao.GenericDAO;
import com.kma.ais_dekanat.dao.GenericDAOHibernateImpl;
import com.kma.ais_dekanat.model.Room;
import com.kma.ais_dekanat.service.RoomService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by denysburlakov on 06.02.16.
 */
public class DekanatRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        RoomService roomService = applicationContext.getBean(RoomService.class);
        Room room = new Room();
        room.setName("Test room");
        roomService.createRoom(room);
        for(Room roomFromDB: roomService.getAllRooms()){
            System.out.println(roomFromDB.getName());
        }
    }
}
