package br.com.ArthurBrandino.rest_with_spring_boot_and_java.request.converters;
import br.com.ArthurBrandino.rest_with_spring_boot_and_java.exception.UnsupportedMathOperationException;

public class NumberConverter {
    public static Double convertToDouble(String strNumber)throws Exception{
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException();
        String number = strNumber.replace(",", ".");

        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;

        String number = strNumber.replace(",", ".");

        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }
}
