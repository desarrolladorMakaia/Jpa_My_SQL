package com.CrudMySQL.Jpa.repository;

import com.CrudMySQL.Jpa.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{


    private StudentJpaRepository studentJpaRepository;

    @Autowired
    public StudentRepositoryImpl(StudentJpaRepository studentJpaRepository){
        this.studentJpaRepository= studentJpaRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentJpaRepository.findAll().size()>0 ? studentJpaRepository.findAll() :null;
    }

    @Override
    public Student findById(Long id) {
        return studentJpaRepository.findById(id).isPresent() ? studentJpaRepository.findById(id).get() :null;
    }

    @Override
    public Student create(Student student) {
        return studentJpaRepository.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        Student studendFound = findById(id);
        if (studendFound != null){
            studendFound.setFirstName(student.getFirstName());
            studendFound.setLastName(student.getLastName());
            studendFound.setBirthDate(student.getBirthDate());
            return studentJpaRepository.save(studendFound);
        }else {
             return null;
        }
    }

    @Override
    public Boolean delete(Long id) {
        Student studentFound = findById(id);
        if (studentFound != null){
            studentJpaRepository.delete(studentFound);
            return  true;
        }else {
            return false;
        }
    }
}
