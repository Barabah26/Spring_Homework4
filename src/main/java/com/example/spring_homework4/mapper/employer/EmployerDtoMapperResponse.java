package com.example.spring_homework4.mapper.employer;

import com.example.spring_homework4.domain.Customer;
import com.example.spring_homework4.domain.Employer;
import com.example.spring_homework4.dto.employer.EmployerDtoResponse;
import com.example.spring_homework4.mapper.DtoMapperFacade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerDtoMapperResponse extends DtoMapperFacade<Employer, EmployerDtoResponse> {

    public EmployerDtoMapperResponse() {
        super(Employer.class, EmployerDtoResponse.class);
    }

    @Override
    protected void decorateDto(EmployerDtoResponse dto, Employer entity) {
        List<String> customerNames = entity.getCustomers().stream()
                .map(Customer::getName)
                .toList();
        dto.setCustomersNames(customerNames);
    }
}
