package net.javaguides.employeeservice.mapper;

import net.javaguides.employeeservice.dto.EmployeeDTO;
import net.javaguides.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO employeeDTOToEmployeeDTO(Employee employee);

    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);

}
