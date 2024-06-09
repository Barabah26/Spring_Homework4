package com.example.spring_homework4.controller;

import com.example.spring_homework4.domain.Customer;
import com.example.spring_homework4.dto.customer.CustomerDtoRequest;
import com.example.spring_homework4.mapper.customer.CustomerDtoMapperResponse;
import com.example.spring_homework4.service.CustomerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private CustomerDtoMapperResponse customerDtoMapperResponse;

    @Test
    void getCustomer() throws Exception {

    }

    @Test
    void getAllCustomers() throws Exception {
        // Create a dummy customer for testing
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
        customer.setAge(30);

        // Create a dummy Page object containing the customer
        Page<Customer> page = new PageImpl<>(Collections.singletonList(customer));

        // Mock the behavior of customerService.findAll() to return the dummy Page
        when(customerService.findAll(0, Integer.MAX_VALUE, PageRequest.of(0, 10))).thenReturn(page);

        // Perform the GET request to "/customers"
        mockMvc.perform(MockMvcRequestBuilders.get("/customers").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("John Doe")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email", Matchers.is("john.doe@example.com")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].age", Matchers.is(30)));
    }



    @Test
    void createCustomer() throws Exception {
        CustomerDtoRequest request = new CustomerDtoRequest();
        request.setName("Alice");
        request.setEmail("alice@example.com");
        request.setAge(25);

        when(customerService.save(any(Customer.class))).thenReturn(new Customer());

        mockMvc.perform(MockMvcRequestBuilders.post("/customers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                // Add more assertions here if needed
                .andReturn();
    }


    @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void createAccountForCustomer() {
    }

    @Test
    void deleteAccountFromCustomer() {
    }
}