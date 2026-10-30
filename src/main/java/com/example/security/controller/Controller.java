package com.example.security.controller;

import com.example.security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller{

    @GetMapping("/")
public String greet(){
    return "hello";
}

    public List<Student> students = new ArrayList<>(List.of(

            new Student(1,"aaa","10"),
            new Student(2,"bbb","90")
    ));


@GetMapping("/student")
public List<Student> getStudent(){
    return students;
}

@GetMapping("/csrf-token")
public CsrfToken gettoken(HttpServletRequest request){

    return (CsrfToken) request.getAttribute("_csrf");
}


@PostMapping("/student")
public List<Student> addStudent(@RequestBody Student student){
     students.add(student);
     return students;
}
}