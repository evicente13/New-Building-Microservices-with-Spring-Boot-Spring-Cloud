package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.EmployeeDTO;
import net.javaguides.employeeservice.entity.Employee;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long idEmployeeDTO);

}