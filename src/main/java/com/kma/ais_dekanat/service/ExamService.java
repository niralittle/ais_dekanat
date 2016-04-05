package com.kma.ais_dekanat.service;

import com.kma.ais_dekanat.dao.GenericDAO;
import com.kma.ais_dekanat.model.FinalTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by denysburlakov on 05.04.16.
 */
@Service
public class ExamService {
    @Autowired
    GenericDAO genericDAO;

    @Transactional
    public List<FinalTest> getAllExams(){
        return genericDAO.getAll(FinalTest.class);
    }

}
