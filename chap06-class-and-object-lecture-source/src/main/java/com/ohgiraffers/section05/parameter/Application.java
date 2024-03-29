package com.ohgiraffers.section05.parameter;

import java.awt.*;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        /*수업목표. 메소드의 파라미터에 대해 이해하고 사용할 수 있다*/

        /*필기. 매개변수(parameter)로 사용 가능한 자료형
        *  1. 기본 자료형
        *  2. 기본 자료형 배열
        *  3. 클래스 자료형
        *  4. 클래스 자료형 배열
        *  5. 가변 인자
        * */

        ParameterTest pt = new ParameterTest();

        /*목차 1. 기본 자료형을 매개변수로 전달받는 메소드 호출*/
        int num = 20;
        System.out.println("call by value 전: " + num);
        pt.testPrimitiveTypeParameter(num);         // call by value(리터럴 값에 의한 호출)
        System.out.println("call by value 후: " + num);

        /*목차 2. 기본 자료형 배열을 매개변수로 전달받는 메소드 호출*/
        int[] iArr = new int[]{1, 2, 3, 4, 5};
        System.out.println("call by reference 전: " + Arrays.toString(iArr));
        pt.testPrimitiveTypeParameter(iArr);        // call by reference(참조 값에 의한 호출)
        System.out.println("call by reference 후: " + Arrays.toString(iArr));

        /*목차 3. 클래스 자료형을 매개변수로 전달받는 메소드 호출*/
        Rectangle r1 = new Rectangle(12.5, 22.5);

//        r1.calArea();
//        r1.calRound();

        pt.testClassTypeParameter(r1);

        /*목차 4. */

        /*목차 5. 가변 인자를 매개변수로 전달받는 메소드 호출*/
        pt.testVariableLengthArrayParameter();
        pt.testVariableLengthArrayParameter("홍길동");
        pt.testVariableLengthArrayParameter("유관순", "볼링");
        pt.testVariableLengthArrayParameter(new String[]{"강감찬", "낚시", "독서"});
    }
}
