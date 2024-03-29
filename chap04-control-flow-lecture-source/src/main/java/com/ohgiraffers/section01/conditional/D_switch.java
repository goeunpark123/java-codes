package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class D_switch {
    public void testSimpleSwitchStatement() {

        /*수업목표. switch문 단독 사용 시 흐름을 이해하고 적용할 수 있다.*/
        Scanner sc = new Scanner(System.in);

        System.out.println("본인의 등급 입력(G: 골드, S: 실버, B: 브론즈): ");
        char grade = sc.next().charAt(0);

        int point = 0;

        switch (grade) {
            case 'G': point += 10;
            case 'S': point += 10;
            case 'B': point += 10;
            default:
                System.out.println("등급 입력 오류");
        }

        if (point != 0) System.out.println("당신의 등급은 " + grade + "이며, 현재 포인트는 " + point + "입니다.");
    }
}
