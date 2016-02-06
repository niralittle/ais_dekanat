package com.kma.ais_dekanat.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by denysburlakov on 06.02.16.
 */
@Repository
public class TestUserDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public int test(){
        return sessionFactory.getCurrentSession().createQuery("from TestUser ").list().size();
    }

}
