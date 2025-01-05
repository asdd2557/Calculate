package org.example.contoller;

import org.example.resource.CalculrateInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * CalculatorController는 다양한 연산자를 기반으로 계산을 수행하는 컨트롤러 클래스입니다.
 * 연산자와 계산 로직(인터페이스)을 매핑하여 동적으로 계산을 수행합니다.
 */
public class CalculatorController {

    // 연산자와 해당 연산 로직(인터페이스)을 매핑하는 Map
    private final Map<String, CalculrateInterface> calculrateInterfaceMap = new HashMap<>();

    /**
     * 새로운 연산자와 연산 로직을 추가합니다.
     *
     * @param operator 연산자 (예: "+", "-", "*", "/")
     * @param calculrateInterface 연산 로직을 구현한 인터페이스
     */
    public void addOperation(String operator, CalculrateInterface calculrateInterface){
        calculrateInterfaceMap.put(operator, calculrateInterface);
    }

    /**
     * 지정된 연산자와 값을 기반으로 계산을 수행합니다.
     *
     * @param a 첫 번째 피연산자
     * @param b 두 번째 피연산자
     * @param operator 연산자 (예: "+", "-", "*", "/")
     * @return 계산 결과
     * @throws UnsupportedOperationException 연산자에 해당하는 연산 로직이 없는 경우 예외 발생
     */
    public int calculate(int a, int b, String operator){
        CalculrateInterface calculrateInterface = calculrateInterfaceMap.get(operator);
        if(calculrateInterface == null){
            throw new UnsupportedOperationException("인터페이스가 Null입니다.");
        }
        return calculrateInterface.Event(a,b);
    }

}
