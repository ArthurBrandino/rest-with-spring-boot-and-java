package br.com.ArthurBrandino.rest_with_spring_boot_and_java.math;

import org.springframework.stereotype.Service; // Import necessário

@Service
public class SimpleMath {
    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double mean(Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo) / 2.0;
    }

    public Double squareRoot(Double number) {
        return Math.sqrt(number);
    }
}
