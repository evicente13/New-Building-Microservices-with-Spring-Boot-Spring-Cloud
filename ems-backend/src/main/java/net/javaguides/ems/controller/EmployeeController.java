package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDTO;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody  EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployeeDTO =  employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDTO employeeDTO =  employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> allEmployeeDTO =  employeeService.getAllEmployee();
        return new ResponseEntity<>(allEmployeeDTO, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody  EmployeeDTO employeeDTO) {
        EmployeeDTO updateEmployeeDTO =  employeeService.updateEmployee(employeeId, employeeDTO);
        return new ResponseEntity<>(updateEmployeeDTO, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long employeeId) {

        employeeService.deleteEmployee(employeeId);

        return new ResponseEntity<>("Employee deleted successfully!.", HttpStatus.OK);
    }

}
