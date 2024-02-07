package com.ohgiraffers.assertions.section02.assertj;


import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class AssertJTests {

    /*수업목표. test third party lib인 Assertj의 사용법에 대해 이해할 수 있다*/

    /*목차 1. 문자열 테스트*/
    /*필기. 문자열의 패턴으로 검증을 하기 때문에 일치성 여부보다 다양한 테스트 가능*/
    @Test
    @DisplayName("문자열 테스트")
    void testStringgValidation() {

        // given
        String expected = "hello world";

        // when
        String actual = new String(expected);

        // then
        Assertions.assertThat(actual).isNotEmpty().isNotBlank().contains("hello").doesNotContain("hahaha")
                .startsWith("h").endsWith("d").isEqualTo("hello world");

    }

    /*목차 2. 숫자 테스트*/
    /*필기. 범위값을 검증하는 단정문(메소드)를 통해 다양한 테스트 가능*/
    @Test
    @DisplayName("숫자 테스트")
    void testIntegerValidation() {
        double pi = Math.PI;

        Double actual = Double.valueOf(pi);

        Assertions.assertThat(actual).isPositive().isGreaterThan(3).isLessThan(4).isEqualTo(Math.PI);
    }

    /*목차 3. 날짜 테스트*/
    /*필기. 날짜 객체가 가지는 년, 월, 일, 시, 분, 초, 밀리초, 나노초까지도 검증 가능하며 특정 날짜 범위, 이전, 이후 테스트 가능*/
    @Test
    @DisplayName("날짜 테스트")
    void testLocalDateTimeValidation() {
        String birthday = "2014-09-18T16:42:00.000";

        LocalDateTime theDay = LocalDateTime.parse(birthday);

        Assertions.assertThat(theDay).hasYear(2014).hasMonthValue(9).hasDayOfMonth(18)
                .isBetween("2014-01-01T00:00.000", "2014-12-31T23:59:59.999").isBefore(LocalDateTime.now());
    }

    /*목차 4. 예외 테스트*/
    /*필기. 예외 타입, 메세지 등의 내용 테스트 가능*/
    @Test
    @DisplayName("예외 테스트")
    void testExceptionValidation() {
        Throwable thrown = AssertionsForClassTypes.catchThrowable(() -> {
            throw new IllegalArgumentException("잘못된 파라미터를 입력하셨습니다.");
        });

        Assertions.assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("파라미터");
    }

    /*목차 5. filter를 이용한 단정문 테스트*/
    /*필기. 특정 filter를 자바 람다식을 이용하여 표현 가능*/

//    @Test
//    @DisplayName("filtering assertion 테스트")
//    void testFilteringAssertion() {
//
//        Member member1 = new Member(1, "user01", "홍길동", 20);
//        Member member2 = new Member(2, "user02", "유관순", 16);
//        Member member3 = new Member(3, "user03", "이순신", 40);
//        Member member4 = new Member(4, "user04", "신사임당", 43);
//        Member member5 = new Member(5, "user05", "임꺽정", 19);
//
//        List<Member> members = Arrays.asList(member1, member2, member3, member4, member5);
//
//        /*설명. 3, 4번 회원이 성인인지 확인*/
//        Assertions.assertThat(members)
//                .filteredOn(member -> member.getAge() > 20).containsOnly(member3, member4);
//    }

    /*목차 6. 객체 프로퍼티 검증*/
    /*필기. 객체 프로퍼티를 추출하여 filter 가능(getter 함수 없이도 프로퍼팉 필터링 가능)*/

    @Test
    @DisplayName("filtering assertion 테스트")
    void testPropertyValidation() {

        Member member1 = new Member(1, "user01", "홍길동", 20);
        Member member2 = new Member(2, "user02", "유관순", 16);
        Member member3 = new Member(3, "user03", "이순신", 40);
        Member member4 = new Member(4, "user04", "신사임당", 43);
        Member member5 = new Member(5, "user05", "임꺽정", 19);

        List<Member> members = Arrays.asList(member1, member2, member3, member4, member5);

        Assertions.assertThat(members)
                .filteredOn("age", 20).containsOnly(member1);
    }
}
