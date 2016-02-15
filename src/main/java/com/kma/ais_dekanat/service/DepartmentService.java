package com.kma.ais_dekanat.service;

import com.kma.ais_dekanat.dao.GenericDAO;
import com.kma.ais_dekanat.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    GenericDAO genericDAO;

    @Transactional
    public List<Department> getAllDepartment() {
        return genericDAO.getAll(Department.class);
    }

    @Transactional
    public void createDepartment(Department department) {
        genericDAO.save(department);
    }


    @Transactional
    public void deleteDepartment(Department department) {
        genericDAO.delete(department);
    }

    @Transactional
    public Department getDepartmentById(Long id) {
        return genericDAO.get(Department.class, id);
    }

    @Transactional
    public void saveOrUpdateCathedra(Department department) {
        genericDAO.saveOrUpdate(department);
    }
}
