package com.exercise.fizzbuzz.controller;

import java.util.ArrayList;
import java.util.List;

import com.exercise.fizzbuzz.service.IFizzBuzz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzAPIController {

    @Autowired
    public IFizzBuzz fizzBuzz;

    @RequestMapping(value = "/exercise", method = RequestMethod.POST)
    public ResponseEntity<List<String>> getFizzBuzz(@RequestBody String[] inputArray) {
        List<String> result = new ArrayList<>();

        if(inputArray == null || inputArray.length == 0){
            result.add("Invalid Item");
        }else{
            result = fizzBuzz.validateFizzBuzz(inputArray);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
