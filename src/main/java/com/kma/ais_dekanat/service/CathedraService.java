package com.kma.ais_dekanat.service;

import com.kma.ais_dekanat.dao.GenericDAO;
import com.kma.ais_dekanat.model.Cathedra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CathedraService {
    @Autowired
    GenericDAO genericDAO;

    @Transactional
    public List<Cathedra> getAllCathedras() {
        return genericDAO.getAll(Cathedra.class);
    }

    @Transactional
    public void createCathedra(Cathedra cathedra) {
        genericDAO.save(cathedra);
    }


    @Transactional
    public void deleteCathedra(Cathedra cathedra) {
        genericDAO.delete(cathedra);
    }

    @Transactional
    public Cathedra getChathedraById(Long id) {
        return genericDAO.get(Cathedra.class, id);
    }

    @Transactional
    public void saveOrUpdateCathedra(Cathedra cathedra) {
        genericDAO.saveOrUpdate(cathedra);
    }

   // public List<Cathedra>getAllCathedrasByDepartmentId(Long id){}
}