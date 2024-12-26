package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "Eduardo",
                "Vicente"
        );

        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Eduardo", "Vicente"));
        students.add(new Student(2, "Enrique", "Chamaya"));
        students.add(new Student(3, "Juan", "Carrasco"));

        return students;
    }

    @GetMapping("student/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId){
        return new Student(studentId, "Eduardo", "Vicente");
    }

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }

}
