package com.example.demospringboot.config;

import com.example.demospringboot.domain.Employee;
import com.example.demospringboot.dto.EmployeeDto;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

public class EmployeeMapper extends CustomMapper<Employee, EmployeeDto> {

    @Override
    public void mapBtoA(EmployeeDto dto, Employee entity, MappingContext context) {
        super.mapBtoA(dto, entity, context);
    }
}
