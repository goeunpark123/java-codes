package com.ohgiraffers.section01.generic;

public class Application {
    public static void main(String[] args) {

        /*수업목표. 제네릭에 대해 이해할 수 있다*/

        GenericTest<Integer> gt1 = new GenericTest<>();     // 뒤의 다이아몬드 연산자 공백 가능

        gt1.setValue(1);        // auto-boxing 값 전달

        System.out.println(gt1.getValue());
        System.out.println(gt1.getValue() instanceof Integer);

        GenericTest<String> gt2 = new GenericTest<>();

        gt2.setValue("피카츄");
        System.out.println(gt2.getValue());
        System.out.println(gt2.getValue() instanceof String);

        /*필기.
        *  제네릭 클래스는 다양한 자료형으로 사용 가능하여 클래스 하나만으로 높은 활용 가치(구현의 편리성)
        *  매개변수나 반환형도 제네릭 타입으로 지정되어 해당 타입에 대해 명확한 처리 가능(타입의 안전성)*/


    }
}
