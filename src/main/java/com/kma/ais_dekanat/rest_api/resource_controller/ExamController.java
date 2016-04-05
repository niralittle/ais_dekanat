package com.kma.ais_dekanat.rest_api.resource_controller;


import com.kma.ais_dekanat.model.FinalTest;
import com.kma.ais_dekanat.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by denysburlakov on 05.04.16.
 */
@RestController
public class ExamController {
    @Autowired
    private ExamService examService;

    @RequestMapping(value = "/exam/", method = RequestMethod.GET)
    public List<FinalTest> getCathedraByDepId() {
        // CathedraService cathedraService = Application.ctx.getBean(CathedraService.class);
        List<FinalTest> exams = examService.getAllExams();

        if (exams != null) {
            return exams;
        }
        return null;
    }
}
