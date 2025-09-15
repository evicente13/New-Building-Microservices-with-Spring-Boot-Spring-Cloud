package net.javaguides.departmentservice.service.impl;

import net.javaguides.departmentservice.dto.DepartmentDTO;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.mapper.DepartmentMapper;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl  implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        Department department = DepartmentMapper.MAPPER.departmentDTOToDepartment(departmentDTO);

        Department departmentSaved = departmentRepository.save(department);

        return  DepartmentMapper.MAPPER.departmentToDepartmentDTO(departmentSaved);
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String code) {

        Department department = departmentRepository.findByDepartmentCode(code);
        return DepartmentMapper.MAPPER.departmentToDepartmentDTO(department);
    }
}
