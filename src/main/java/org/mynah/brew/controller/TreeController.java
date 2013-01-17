package org.mynah.brew.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.mynah.brew.model.Department;
import org.mynah.brew.service.DepartmentService;

@Controller
public class TreeController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/tree")
    public String show() {
        return "tree/show";
    }

    @RequestMapping("/department")
    @ResponseBody
    public List<Department> department() {
        List<Department> departments = departmentService.query(new Department(), Department.class);
        return departments;
    }

}
