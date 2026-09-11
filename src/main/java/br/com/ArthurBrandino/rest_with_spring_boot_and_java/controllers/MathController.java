package br.com.ArthurBrandino.rest_with_spring_boot_and_java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ArthurBrandino.rest_with_spring_boot_and_java.exception.UnsupportedMathOperationException;
import br.com.ArthurBrandino.rest_with_spring_boot_and_java.math.SimpleMath;
import br.com.ArthurBrandino.rest_with_spring_boot_and_java.request.converters.NumberConverter;
@RestController
@RequestMapping ("/math")
public class MathController {

    @Autowired
    private SimpleMath math;

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
        @PathVariable ("numberOne")String numberOne,
        @PathVariable ("numberTwo")String numberTwo)
        throws Exception{
            if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException();
            return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
        @PathVariable ("numberOne")String numberOne,
        @PathVariable ("numberTwo")String numberTwo
        ) throws Exception{
            if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException();
            return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
        @PathVariable ("numberOne")String numberOne,
        @PathVariable ("numberTwo")String numberTwo
    ) throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException();
        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
        @PathVariable("numberOne")String numberOne,
        @PathVariable("numberTwo")String numberTwo
    ) throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException();
        return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
        @PathVariable("numberOne")String numberOne,
        @PathVariable("numberTwo")String numberTwo
    ) throws Exception{
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw new UnsupportedMathOperationException();
        return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping("/square-root/{number}")
    public Double squareRoot(
        @PathVariable("number")String number
    ) throws Exception{
        if(!NumberConverter.isNumeric(number)) throw new UnsupportedMathOperationException();
        return math.squareRoot(NumberConverter.convertToDouble(number));
    }
}
