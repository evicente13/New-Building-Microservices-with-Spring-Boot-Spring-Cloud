package net.javaguides.employeeservice.service.impl;

import net.javaguides.employeeservice.dto.EmployeeDTO;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.mapper.EmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.MAPPER.employeeDTOToEmployee(employeeDTO);

        Employee employeeSaved = employeeRepository.save(employee);

        return EmployeeMapper.MAPPER.employeeDTOToEmployeeDTO(employeeSaved);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long idEmployeeDTO) {
        Employee employee = employeeRepository.findById(idEmployeeDTO).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", idEmployeeDTO)
        );

        return EmployeeMapper.MAPPER.employeeDTOToEmployeeDTO(employee);
    }
}
