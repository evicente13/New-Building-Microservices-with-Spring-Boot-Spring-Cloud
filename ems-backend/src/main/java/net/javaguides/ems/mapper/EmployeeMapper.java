package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.EmployeeDTO;
import net.javaguides.ems.entity.Employee;

public class EmployeeMapper {

        public static EmployeeDTO mapToEmployeeDTO(Employee employee){

            EmployeeDTO employeeDTO=new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setFirstName(employee.getFirstName());
            employeeDTO.setLastName(employee.getLastName());
            employeeDTO.setEmail(employee.getEmail());

            return  employeeDTO;
        }

        public static Employee mapToEmployee(EmployeeDTO employeeDTO){

            Employee employee=new Employee();
            employee.setId(employeeDTO.getId());
            employee.setFirstName(employeeDTO.getFirstName());
            employee.setLastName(employeeDTO.getLastName());
            employee.setEmail(employeeDTO.getEmail());

            return employee;

        }

}
