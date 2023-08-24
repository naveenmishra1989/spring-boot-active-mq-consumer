package com.bridgingcode.springbootactivemqdemo.consumer.component;

import com.bridgingcode.springbootactivemqdemo.model.Data;
import com.bridgingcode.springbootactivemqdemo.repo.SystemMessageRepository;
import com.bridgingcode.springbootactivemqdemo.repo.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
@RequiredArgsConstructor
public class MessageConsumer {

    private final SystemMessageRepository systemMessageRepository;
    private final ObjectMapper mapper;

    @JmsListener(destination = "naveen-queue")
    public void messageListener(String message) {
        final var employees = getEmployees(message);
        List<Employee> saveAll = systemMessageRepository.saveAll(employees);
        log.info("Message received! {}", saveAll);

    }

    private List<Employee> getEmployees(String message){
        List<Employee> employees = new ArrayList<>();
        try {
            Data data = mapper.readValue(message, Data.class);
            for (Employee employee :data.getEmployees()){
                employees.add(employee);
            }
        } catch (JsonProcessingException e) {
            log.error("Error Message:"+e.getMessage());
        }

        return  employees;
    }
}
