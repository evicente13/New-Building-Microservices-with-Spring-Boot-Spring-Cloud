package net.javaguides.employeeservice.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.javaguides.employeeservice.dto.APIResponseDTO;
import net.javaguides.employeeservice.dto.DepartmentDTO;
import net.javaguides.employeeservice.dto.EmployeeDTO;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.mapper.EmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //@Autowired
    //private RestTemplate restTemplate;

    //@Autowired
    //private WebClient webClient;

    @Autowired
    private APIClient apiClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.MAPPER.employeeDTOToEmployee(employeeDTO);

        Employee employeeSaved = employeeRepository.save(employee);

        return EmployeeMapper.MAPPER.employeeDTOToEmployeeDTO(employeeSaved);
    }

    @Override
    public APIResponseDTO getEmployeeById(Long idEmployeeDTO) {

        Employee employee = employeeRepository.findById(idEmployeeDTO).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", idEmployeeDTO)
        );

        /*
        ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),
                DepartmentDTO.class);

        DepartmentDTO  departmentDTO = responseEntity.getBody();
         */

        /*DepartmentDTO  departmentDTO = webClient.get()
                .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono( DepartmentDTO.class)
                .block();
         */

        DepartmentDTO  departmentDTO = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDTO employeeDTO = EmployeeMapper.MAPPER.employeeDTOToEmployeeDTO(employee);

        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setEmployee(employeeDTO);
        apiResponseDTO.setDepartment(departmentDTO);

        return apiResponseDTO;
    }
}
