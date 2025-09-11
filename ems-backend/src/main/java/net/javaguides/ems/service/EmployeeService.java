package net.javaguides.ems.service;

import net.javaguides.ems.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO  createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long employeeId);

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO  updateEmployee(Long employeeId,EmployeeDTO employeeDTO);

    void deleteEmployee(Long employeeId);

}
