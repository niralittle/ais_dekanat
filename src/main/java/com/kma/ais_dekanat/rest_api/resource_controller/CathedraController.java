package com.kma.ais_dekanat.rest_api.resource_controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kma.ais_dekanat.model.Cathedra;
import com.kma.ais_dekanat.model.Department;
import com.kma.ais_dekanat.service.CathedraService;
import com.kma.ais_dekanat.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CathedraController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    CathedraService cathedraService;

    @RequestMapping(value = "/cathedra/list", method = RequestMethod.GET)
    @JsonView(Cathedra.Views.Internal.class)
    public List<Cathedra> getCathedraByDepId(@RequestParam(value = "id") String id) {
        // CathedraService cathedraService = Application.ctx.getBean(CathedraService.class);
        List<Cathedra> cathedraList = cathedraService.getAllCathedrasByDepartmentId(Integer.parseInt(id));

        if (cathedraList != null) {
            return cathedraList;
        }
        return null;
    }

    @RequestMapping(value = "/cathedra/department", method = RequestMethod.GET)
    public List<Department> getAllDepartment() {
        List<Department> allDepartment = departmentService.getAllDepartment();
        if (allDepartment != null) {
            return allDepartment;
        }
        return null;
    }
}
