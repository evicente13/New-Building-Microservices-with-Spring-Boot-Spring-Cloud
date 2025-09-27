package net.javaguides.departmentservice.service.impl;

import net.javaguides.departmentservice.dto.DepartmentDTO;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.exception.CodeAlreadyExistsException;
import net.javaguides.departmentservice.mapper.DepartmentMapper;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl  implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        Optional<Department> optionalDepartment = departmentRepository.findByDepartmentCode(departmentDTO.getDepartmentCode());

        if (optionalDepartment.isPresent()) {
            throw new CodeAlreadyExistsException("Department with code " + departmentDTO.getDepartmentCode() + " already exists");
        }

        Department department = DepartmentMapper.MAPPER.departmentDTOToDepartment(departmentDTO);

        Department departmentSaved = departmentRepository.save(department);

        return  DepartmentMapper.MAPPER.departmentToDepartmentDTO(departmentSaved);
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String code) {

        Optional<Department> optionalDepartment = departmentRepository.findByDepartmentCode(code);

        if (!optionalDepartment.isPresent()) {
            throw new CodeAlreadyExistsException("Department with code " + code + " already exists");
        }

        return DepartmentMapper.MAPPER.departmentToDepartmentDTO(optionalDepartment.get());
    }
}
