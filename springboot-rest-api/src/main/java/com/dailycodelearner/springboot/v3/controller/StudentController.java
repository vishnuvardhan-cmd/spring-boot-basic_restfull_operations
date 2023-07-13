package com.dailycodelearner.springboot.v3.controller;

import com.dailycodelearner.springboot.v3.bean.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v3")
public class StudentController {

    List<Student> students=new ArrayList<>(Arrays.asList(
            new Student(1,"vishnuvardhan","Bandlamudi"),
            new Student(2,"munner","react"),
            new Student(3,"deepa","node"),
            new Student(4,"sajid","fullstack")
    )
    );

    @GetMapping("student")
    public Student getStudent(){
        return new Student(1,"vishnuvardhan","Bandlamudi");
    }

    @GetMapping("student/all")
    public List<Student> getStudents(){
        return students;

    }

    @GetMapping("student/{id}")
    public Student getStudentById(@PathVariable("id") int id){

        return students.stream().filter(s->s.getId()==id).findAny().orElse(
                new Student(999,"default","default")
        );
    }

    @GetMapping("student/param")
    public Student getStudentByIdUsingRequestParam(@RequestParam int id){

        return students.stream().filter(s->s.getId()==id).findAny().orElse(
                new Student(999,"default","default")
        );
    }

    @PostMapping("/student")
    public int addStudent(@RequestBody Student student){
        students.add(student);
        return 1;
    }

    @PutMapping("/student")
    public List<Student> updateStudent(@RequestBody Student student){
        Student findStudent=students.stream().filter(s->s.getId()==student.getId()).findAny().get();
        findStudent.setId(student.getId());
        findStudent.setFirstName(student.getFirstName());
        findStudent.setLastName(student.getLastName());

        students.set(findStudent.getId()-1,findStudent);

        return students;
    }

    @DeleteMapping("/student")
    public ResponseEntity<List<Student>> deleteStudent(@RequestParam int id){
        students.remove(id-1);
        return ResponseEntity.ok(students);
    }
}
