package com.example.demospringboot.config;

import com.example.demospringboot.domain.Employee;
import com.example.demospringboot.dto.EmployeeDto;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

public class MappingConfig implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {

        mapperFactory.classMap(Employee.class, EmployeeDto.class)
                .customize(new EmployeeMapper())
                .byDefault()
                .register();

        mapperFactory.classMap(Employee.class, EmployeeDto.class)
                .byDefault()
                .register();
    }
}
