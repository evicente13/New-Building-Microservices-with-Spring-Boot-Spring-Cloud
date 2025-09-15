package net.javaguides.departmentservice.controller;

import net.javaguides.departmentservice.dto.DepartmentDTO;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO  departmentDTO) {
        DepartmentDTO  savedDepartmentDTO = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartmentDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable("department-code") String departmentCode) {
        DepartmentDTO  departmentDTO = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }

}
