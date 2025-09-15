package net.javaguides.employeeservice.controller;

import net.javaguides.employeeservice.dto.EmployeeDTO;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO  departmentDTO) {
        EmployeeDTO savedEmployeeDTO = employeeService.saveEmployee(departmentDTO);
        return new  ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id-employee}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "id-employee") Long idEmployee) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(idEmployee);
        return new  ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

}
