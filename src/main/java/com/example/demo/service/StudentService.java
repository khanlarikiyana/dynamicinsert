package com.example.demo.service;

import com.example.demo.dto.Dto;
import com.example.demo.model.sql.QStudent;
import com.example.demo.model.sql.TbStudent;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.StudentRepositoryWithJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentRepositoryWithJpa studentRepositoryWithJpa;

    @Transactional
    public List<TbStudent> getAllStudents() {
        var students = studentRepository.findAll();
        students.forEach(tbStudent -> System.out.println(tbStudent.getFirstname()));
        return students;
    }

    @Transactional
    public List<QStudent> getAllStudentsWithJpa() {
        var students = studentRepositoryWithJpa.findAll();
        return students;
    }

    //please add update and insert and delete methods
    @Transactional
    public TbStudent insertStudentWithJpa(Dto dto) {
        TbStudent student = new TbStudent();
        student.setId(dto.getId());
        student.setFirstname(dto.getFirstName());
        student.setLastname(dto.getLastName());
        student.setStuAge(dto.getStuAge());
        return studentRepository.insert(student);


    }

}
