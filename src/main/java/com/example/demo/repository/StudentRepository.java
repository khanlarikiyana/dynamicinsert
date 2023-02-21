package com.example.demo.repository;

import com.example.demo.model.sql.TbStudent;
import com.querydsl.core.types.QBean;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.demo.model.sql.QStudent.student;
import static com.querydsl.core.types.Projections.bean;


@Repository
public class StudentRepository {

    private static final QBean<TbStudent> qTbStudent = bean(TbStudent.class, student.all());
    @Autowired
    private SQLQueryFactory sqlQueryFactory;

    public List<TbStudent> findAll() {
        return sqlQueryFactory.select(qTbStudent).from(student).fetch();
    }

    public TbStudent insert(TbStudent entity) {
        sqlQueryFactory
                .insert(student)
                .populate(entity)
                .executeWithKey(student.id);
        return entity;
    }


//    public Long update(Long id) {
//        sqlQueryFactory
//                .update(student)
//                .where(student.id.eq(Long.valueOf("1301")))
//                .execute();
//        return id;
//    }

  
}
