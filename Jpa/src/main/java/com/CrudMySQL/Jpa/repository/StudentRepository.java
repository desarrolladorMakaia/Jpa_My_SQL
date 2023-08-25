package com.CrudMySQL.Jpa.repository;

import com.CrudMySQL.Jpa.model.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> findAll();

    Student findById(Long id);

    Student create(Student student);

    Student update(Long id, Student student);

    Boolean delete(Long id);


}
