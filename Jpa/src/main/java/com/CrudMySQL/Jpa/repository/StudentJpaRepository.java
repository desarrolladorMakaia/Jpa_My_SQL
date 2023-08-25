package com.CrudMySQL.Jpa.repository;

import com.CrudMySQL.Jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentJpaRepository extends JpaRepository<Student, Long> {

    @Query("SELECT e FROM student e JOIN e.course c WHERE c.name = :nombreCurso")
    List<Student> findEstudiantesPorNombreCurso(String nombreCurso);



}
