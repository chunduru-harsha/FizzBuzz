package com.exercise.fizzbuzz.controller;

import com.exercise.fizzbuzz.service.FizzBuzzImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(classes={FizzBuzzAPIController.class})
public class FizzBuzzAPIControllerTests {

    @Autowired
    private FizzBuzzAPIController controller;

    @MockBean
    FizzBuzzImpl fizzBuzz;


    @Test
    public void getFizzBuzz(){

        String[] input = {"3"};

        when(fizzBuzz.validateFizzBuzz(any())).thenReturn(new ArrayList<>());

        ResponseEntity<List<String>> response = controller.getFizzBuzz(input);

        //verify
        verify(fizzBuzz, times(1)).validateFizzBuzz(input);

        //assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getFizzBuzz_EmptyArray(){

        String[] input = new String[0];
        List<String> result = new ArrayList<>();
        result.add("Invalid Item");

        ResponseEntity<List<String>> response = controller.getFizzBuzz(input);

        List<String> responseOutput = response.getBody();

        //verify
        verify(fizzBuzz, times(0)).validateFizzBuzz(input);

        //assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(result.get(0),responseOutput.get(0));
    }
}
