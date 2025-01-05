package org.example.calculator;

import org.example.contoller.CalculatorController;
import org.example.method.DivideMethod;
import org.example.method.MinusMethod;
import org.example.method.MultiplyMethod;
import org.example.method.PlusMethod;

import org.example.resource.CalculrateResourceImpl;

import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        CalculatorController calculatorController = new CalculatorController();
        CalculrateResourceImpl calculrateResourceImpl = new CalculrateResourceImpl();
        calculatorController.addOperation("/", new DivideMethod());
        calculatorController.addOperation("-", new MinusMethod());
        calculatorController.addOperation("*", new MultiplyMethod());
        calculatorController.addOperation("+", new PlusMethod());

        Scanner scanner = new Scanner(System.in);
        while (true){
        if(calculrateResourceImpl.while_switch1()){
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                calculrateResourceImpl.setNum1(scanner.nextInt());
                calculrateResourceImpl.setWhile_switch1(false);
            }catch (Exception e){
                System.out.println("잘못된 입력입니다. 숫자를 입력해 주세요.");
                scanner.nextLine();
                continue;
            }
        }

        if(calculrateResourceImpl.while_switch2()){
            System.out.print("두 번째 숫자를 입력하세요: ");
            try {
                calculrateResourceImpl.setNum2(scanner.nextInt());
                calculrateResourceImpl.setWhile_switch2(false);
            } catch (Exception e){
                System.out.println("잘못된 입력입니다. 숫자를 입력해 주세요.");
                scanner.nextLine();
                continue;
            }
        }
            System.out.print("+,-,*,/ 를 입력하세요: ");
            String operator = scanner.next();
            try {
                calculrateResourceImpl.setNum1(calculatorController.calculate(calculrateResourceImpl.getNum1(), calculrateResourceImpl.getNum2(), operator) );
                System.out.println("결과: " + calculrateResourceImpl.getNum1());
                calculrateResourceImpl.setWhile_switch2(true);
            } catch (ArithmeticException e) {
                System.out.println("오류: " + e.getMessage());
                scanner.nextLine();
                continue;
            } catch (UnsupportedOperationException e) {
                System.out.println("지원되지 않는 연산입니다.");
                scanner.nextLine();
                continue;
            }
            System.out.print("계속하시겠습니까? (y/n)");
            if(Objects.equals(scanner.next(), "n")){
                break;
            }
        }
    }
}
