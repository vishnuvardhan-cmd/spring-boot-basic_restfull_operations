package com.dailycodelearner.springboot.v3.controller;

import com.dailycodelearner.springboot.v3.bean.Student;
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
        return new ArrayList<>(Arrays.asList(
                new Student(1,"vishnuvardhan","Bandlamudi"),
                new Student(2,"munner","react"),
                new Student(3,"deepa","node"),
                new Student(4,"sajid","fullstack")
        )
        );

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
}
