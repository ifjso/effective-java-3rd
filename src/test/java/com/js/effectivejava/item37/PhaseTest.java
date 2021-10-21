package com.js.effectivejava.item37;

import static org.assertj.core.api.Assertions.assertThat;

import com.js.effectivejava.item37.Phase.Transition;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PhaseTest {

    @ParameterizedTest
    @MethodSource("providePhasesAndExpected")
    @DisplayName("이전, 이후 상태에 대한 전이를 검증한다.")
    void testTransition(Phase from, Phase to, Transition expected) {
        Transition actual = Transition.from(from ,to);
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> providePhasesAndExpected() {
        return Stream.of(
            Arguments.of(Phase.SOLID, Phase.LIQUID, Transition.MELT),
            Arguments.of(Phase.LIQUID, Phase.SOLID, Transition.FREEZE),
            Arguments.of(Phase.LIQUID, Phase.GAS, Transition.BOIL),
            Arguments.of(Phase.GAS, Phase.LIQUID, Transition.CONDENSE),
            Arguments.of(Phase.SOLID, Phase.GAS, Transition.SUBLIME),
            Arguments.of(Phase.GAS, Phase.SOLID, Transition.DEPOSIT),
            Arguments.of(Phase.GAS, Phase.PLASMA, Transition.IONIZE),
            Arguments.of(Phase.PLASMA, Phase.GAS, Transition.DEIONIZE));
    }
}
