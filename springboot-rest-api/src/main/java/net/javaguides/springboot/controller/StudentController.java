package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Eduardo",
                "Vicente"
        );

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Eduardo", "Vicente"));
        students.add(new Student(2, "Enrique", "Chamaya"));
        students.add(new Student(3, "Juan", "Carrasco"));

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId){
        Student student = new Student(studentId, "Eduardo", "Vicente");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //Spring Boot REST API with Path Variable
    // {id} - URI template variable
    //http://localhost:8080/students/2/Eduardo/Vicente

    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        Student student = new Student(studentId, firstName, lastName);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //Spring  boot REST API with Rquest Param
    //http://localhost:8080/students/query?id=1&firstName=Eduardo&lastName=Vicente
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        Student student = new Student(id, firstName, lastName);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //Spring boot Rest Api that handles HTTP Post Request
    //@PostMapping and @RequestBody
    @PostMapping("create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }

}
