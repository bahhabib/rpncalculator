package fr.infine.interview.rpn.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class UtilsCalculator {

    public static BigDecimal calculate(String operator, BigDecimal firstOperand, BigDecimal secondOperand) {
        Map<String, BigDecimal> mapOperation = new HashMap<>() {{
            put("+", firstOperand.add(secondOperand));
            put("-", firstOperand.subtract(secondOperand));
            put("*", firstOperand.multiply(secondOperand));
            put("/", firstOperand.divide(secondOperand));
        }};

        return mapOperation.get(operator);


    }

}
