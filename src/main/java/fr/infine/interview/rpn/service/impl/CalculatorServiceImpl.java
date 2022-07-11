package fr.infine.interview.rpn.service.impl;


import fr.infine.interview.rpn.service.ICalculatorService;
import fr.infine.interview.rpn.utils.UtilsCalculator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
class CalculatorServiceImpl implements ICalculatorService {

    private static Map<Integer, Stack> mapStack;

    static {
        mapStack = new HashMap<>();
    }


    @Override
    public Integer createStack() {
        Integer key = mapStack.keySet().size() + 1;
        Stack<Double> stack = new Stack<Double>();
        mapStack.put(key, stack);
        return key;
    }

    @Override
    public Stack getStackById(Integer stackId) {
        Stack<Double> stack = mapStack.get(stackId);
        return stack;
    }

    @Override
    public void addElement(Integer stackId, BigDecimal element) {
        Stack<BigDecimal> stack = mapStack.get(stackId);
        stack.push(element);
    }

    @Override
    public void clear(Integer stackId) {
        mapStack.get(stackId).clear();
    }

    @Override
    public void compute(Integer stackId, String operator) {
        Stack<BigDecimal> stack = getStackById(stackId);
        BigDecimal firstOperand = stack.pop();
        BigDecimal secondOperand = stack.pop();
        stack.push(UtilsCalculator.calculate(operator, firstOperand, secondOperand));
    }
}



