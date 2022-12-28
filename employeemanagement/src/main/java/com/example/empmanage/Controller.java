package com.example.empmanage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    Repository repo;

    @RequestMapping("/addEmployee")
    @ResponseBody
    public Optional<Empentity> add(@RequestParam String employeeId, String employeeName, String employeeEmail, String dept)
    {Empentity obj = new Empentity();
    obj.setEmployeeId(employeeId);
    obj.setEmployeeName(employeeName);
    obj.setEmployeeEmail(employeeEmail);
    obj.setDept(dept);
    repo.save(obj);
    return repo.findById(employeeId);
    }

    @RequestMapping("/deleteEmployee")
    @ResponseBody
    public Optional<Empentity> del(@RequestParam String employeeId)
    {
        repo.deleteById(employeeId);
        return repo.findById(employeeId);
    }

    @RequestMapping("/getAllEmployee")
    @ResponseBody
    public List<Empentity> all()
    {
        return repo.findAll();
    }

    @RequestMapping("getEmployee")
    @ResponseBody
    public Optional<Empentity> get(@RequestParam String employeeId)
    {
        return repo.findById(employeeId);
    }
}
