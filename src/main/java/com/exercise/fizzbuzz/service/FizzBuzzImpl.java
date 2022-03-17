package com.exercise.fizzbuzz.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class FizzBuzzImpl implements  IFizzBuzz{

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    @Override
    public List<String> validateFizzBuzz(String[] inputArray) {
        List<String> result = new ArrayList<>();

        for (String i: inputArray) {

            if(!isNumeric(i)){
                result.add("Invalid Item");
                continue;
            }
            int item = Integer.parseInt(i);

            if (item%15 == 0) {
                result.add("FizzBuzz");
            }
            else if (item%3 == 0) {
                result.add("Fizz");
            }
            else if (item%5 == 0) {
                result.add("Buzz");
            }
            else {
                result.add("Divided "+item +" by 3 "+"Divided "+item +" by 5");
            }
        }

        return result;
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
