package com.js.effectivejava.item14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PhoneNumber compareTo 검증")
public class PhoneNumberComparisonTest {

    PhoneNumber pnOne = new PhoneNumber(100, 100, 1000);
    PhoneNumber pnTwo = new PhoneNumber(101, 100, 1000);
    PhoneNumber pnThree = new PhoneNumber(100, 101, 1000);
    PhoneNumber pnFour = new PhoneNumber(100, 101, 1001);
    PhoneNumber pnFive = new PhoneNumber(100, 100, 1000);

    List<PhoneNumber> phoneNumbers = List.of(pnOne, pnTwo, pnThree, pnFour, pnFive);

    @Test
    @DisplayName("오름차순 정렬일 경우")
    void test_ascending_comparison_by() {
        List<PhoneNumber> ascendingPhoneNumbers = phoneNumbers.stream()
                .sorted()
                .collect(Collectors.toList());

        assertThat(ascendingPhoneNumbers).usingFieldByFieldElementComparator()
                .containsExactly(pnOne, pnFive, pnThree, pnFour, pnTwo);
    }

    @Test
    @DisplayName("내림차순 정렬일 경우")
    void test_descending_comparison_by() {
        List<PhoneNumber> descendingPhoneNumbers = phoneNumbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        assertThat(descendingPhoneNumbers).usingFieldByFieldElementComparator()
                .containsExactly(pnTwo, pnFour, pnThree, pnFive, pnOne);
    }
}
