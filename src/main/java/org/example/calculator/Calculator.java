package org.example.calculator;

import org.example.contoller.Calculator_Controller;
import org.example.method.Divide_Method;
import org.example.method.Minus_Method;
import org.example.method.Multiply_Method;
import org.example.method.Plus_Method;

import org.example.resource.Calculrate_Resource_Impl;

import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Calculator_Controller calculator_controller = new Calculator_Controller();
        Calculrate_Resource_Impl calculrate_resource_impl = new Calculrate_Resource_Impl();
        calculator_controller.addOperation("/", new Divide_Method());
        calculator_controller.addOperation("-", new Minus_Method());
        calculator_controller.addOperation("*", new Multiply_Method());
        calculator_controller.addOperation("+", new Plus_Method());

        Scanner scanner = new Scanner(System.in);
        while (true){
        if(calculrate_resource_impl.while_switch1()){
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                calculrate_resource_impl.setNum1(scanner.nextInt());
                calculrate_resource_impl.setWhile_switch1(false);
            }catch (Exception e){
                System.out.println("잘못된 입력입니다. 숫자를 입력해 주세요.");
                scanner.nextLine();
                continue;
            }
        }

        if(calculrate_resource_impl.while_switch2()){
            System.out.print("두 번째 숫자를 입력하세요: ");
            try {
                calculrate_resource_impl.setNum2(scanner.nextInt());
                calculrate_resource_impl.setWhile_switch2(false);
            } catch (Exception e){
                System.out.println("잘못된 입력입니다. 숫자를 입력해 주세요.");
                scanner.nextLine();
                continue;
            }
        }



            System.out.print("+,-,*,/ 를 입력하세요: ");
            String operator = scanner.next();
            try {
                calculrate_resource_impl.setNum1(calculator_controller.calculate(calculrate_resource_impl.getNum1(), calculrate_resource_impl.getNum2(), operator) );
                System.out.println("결과: " + calculrate_resource_impl.getNum1());
                calculrate_resource_impl.setWhile_switch2(true);
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
