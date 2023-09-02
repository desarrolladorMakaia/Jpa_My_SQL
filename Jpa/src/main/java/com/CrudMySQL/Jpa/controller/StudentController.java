package com.CrudMySQL.Jpa.controller;

import com.CrudMySQL.Jpa.model.Student;
import com.CrudMySQL.Jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        List<Student> students = studentService.findAll();
        if (students.size() == 0){
            return new ResponseEntity("NO HAY USUARIOS", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(students,HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Student student = studentService.findById(id);
        if (student != null){
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity("El id " + id + "no ha sido encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student){
        Student student1 = studentService.create(student);
        if (student1 != null){
            return new ResponseEntity<>(student1,HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Error creando el estudiante" , HttpStatus.CONFLICT);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student){
        Student student1 = studentService.update(id, student);
        if (student1 != null){
            return new ResponseEntity<>(student1, HttpStatus.OK);
        } else {
            return new ResponseEntity("Error actualizando el estudiante", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable Long id){
        Boolean isDeleted = studentService.delete(id);
        if (isDeleted){
            return new ResponseEntity<>(isDeleted , HttpStatus.OK);
        } else {
            return new ResponseEntity(isDeleted , HttpStatus.NOT_FOUND);
        }
    }

}
