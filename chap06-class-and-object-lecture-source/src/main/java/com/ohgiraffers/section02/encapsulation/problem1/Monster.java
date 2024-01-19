package com.ohgiraffers.section02.encapsulation.problem1;

public class Monster {
    String name;
    int hp;

    public void setHp(int hp) {
        if(hp > 0) this.hp = hp;               // this는 메소드 호출 당시의 Monster 객체를 의미
        else this.hp = 0;                       // this.hp는 해당 객체의 hp 공간을 의미
    }
}

