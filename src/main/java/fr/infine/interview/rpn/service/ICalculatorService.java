package fr.infine.interview.rpn.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Stack;

@Service
public interface ICalculatorService {


    public Integer createStack();

    public Stack getStackById(Integer stackId);

    public void addElement(Integer stackID, BigDecimal element);
    public void clear(Integer stackID);
    public void compute(Integer stackId, String operator);

}
