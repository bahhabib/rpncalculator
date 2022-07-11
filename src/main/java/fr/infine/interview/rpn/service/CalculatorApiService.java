package fr.infine.interview.rpn.service;

import fr.infine.interview.rpn.generator.controller.RpnApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class CalculatorApiService implements RpnApiDelegate {
    @Autowired
    private ICalculatorService calculatorService;

    @Override
    public ResponseEntity<Integer> createStack() {
        return ResponseEntity.ok(calculatorService.createStack());
    }

    @Override
    public ResponseEntity<List<BigDecimal>> getStackById(Integer stackId) {
        return ResponseEntity.ok(Arrays.asList((BigDecimal[]) calculatorService.getStackById(stackId).toArray(new BigDecimal[0])));
    }

    @Override
    public ResponseEntity<Void> addElement(Integer stackID, BigDecimal element) {
        calculatorService.addElement(stackID, element);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> clear(Integer stackID) {
        calculatorService.clear(stackID);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> compute(Integer stackId, String operator) {
        calculatorService.compute(stackId, operator);
        return ResponseEntity.ok().build();
    }


}