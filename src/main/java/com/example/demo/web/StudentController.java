package com.example.demo.web;

import com.example.demo.dto.Dto;
import com.example.demo.model.jpa.Student;
import com.example.demo.model.sql.TbStudent;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<TbStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/students")
    public String insertStudentWithJpa(@RequestBody Dto dto){
        studentService.insertStudentWithJpa(dto);
        return "insertWithJpa"+dto;
    }
//    @PutMapping("/students")
//    public String  updateStudentWithJpa(@RequestBody Dto dto)
//    {
//        studentService.updateStudentWithJpa(dto);
//        return "updateWithJpa"+dto;
//
//    }


}
