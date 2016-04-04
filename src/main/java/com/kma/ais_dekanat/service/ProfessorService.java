package com.kma.ais_dekanat.service;

import com.kma.ais_dekanat.dao.GenericDAO;
import com.kma.ais_dekanat.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    GenericDAO genericDAO;

    @Transactional
    public List<Professor> getAllProfessor() {
        return genericDAO.getAll(Professor.class);
    }

    @Transactional
    public void createProfessor(Professor professor) {
        genericDAO.save(professor);
    }


    @Transactional
    public void deleteProfessor(Professor professor) {
        genericDAO.delete(professor);
    }

    @Transactional
    public Professor getProfessorById(Integer id) {
        return genericDAO.get(Professor.class, id);
    }

    @Transactional
    public void saveOrUpdateProfessor(Professor professor) {
        genericDAO.saveOrUpdate(professor);
    }
}
