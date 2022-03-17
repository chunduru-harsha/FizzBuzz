package com.exercise.fizzbuzz.servic;


import static org.assertj.core.api.Assertions.assertThat;
import com.exercise.fizzbuzz.service.FizzBuzzImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FizzBuzzImplTests {

    @Autowired
    FizzBuzzImpl fizzBuzzImpl;

    @Test
    public void nonNumericCharacters(){
        String[] input = {"A"};
        List<String> result = fizzBuzzImpl.validateFizzBuzz(input);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo("Invalid Item");
    }

    @Test
    public void numericFizzCharacter(){
        String[] input = {"3"};
        List<String> result = fizzBuzzImpl.validateFizzBuzz(input);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo("Fizz");
    }

    @Test
    public void numericBuzzCharacter(){
        String[] input = {"5"};
        List<String> result = fizzBuzzImpl.validateFizzBuzz(input);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo("Buzz");
    }

    @Test
    public void numericFizzBuzzCharacter(){
        String[] input = {"15"};
        List<String> result = fizzBuzzImpl.validateFizzBuzz(input);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo("FizzBuzz");
    }

    @Test
    public void nonNumericFizzBuzzCharacter(){
        String[] input = {"23"};
        List<String> result = fizzBuzzImpl.validateFizzBuzz(input);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo("Divided 23 by 3 Divided 23 by 5");
    }
}
