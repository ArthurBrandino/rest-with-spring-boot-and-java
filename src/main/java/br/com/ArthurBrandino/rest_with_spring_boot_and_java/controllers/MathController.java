package br.com.ArthurBrandino.rest_with_spring_boot_and_java.controllers;

import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ArthurBrandino.rest_with_spring_boot_and_java.exception.UnsupportedMathOperationException;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping ("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne")String numberOne,
            @PathVariable("numberTwo")String numberTwo
    ) throws Exception{
            if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException();
            return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
        @PathVariable ("numberOne")String numberOne,
        @PathVariable ("numberTwo")String numberTwo
        ) throws Exception{
            if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException();

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }
    
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
        @PathVariable ("numberOne")String numberOne,
        @PathVariable ("numberTwo")String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException();

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
        @PathVariable("numberOne")String numberOne,
        @PathVariable("numberTwo")String numberTwo
    ) throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException();
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }
    
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
        @PathVariable("numberOne")String numberOne,
        @PathVariable("numberTwo")String numberTwo
    ) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException();
        return (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
    }

    @RequestMapping("/squareroot/{numberOne}")
    public Double squareroot(
        @PathVariable("numberOne")String numberOne
    ) throws Exception{

        if(!isNumeric(numberOne)) throw new UnsupportedMathOperationException();
        return Math.pow(convertToDouble(numberOne), 1/2);
    }


    private Double convertToDouble(String strNumber)throws Exception{
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException();
        String number = strNumber.replace(",", ".");

        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;

        String number = strNumber.replace(",", ".");

        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }
    
}
