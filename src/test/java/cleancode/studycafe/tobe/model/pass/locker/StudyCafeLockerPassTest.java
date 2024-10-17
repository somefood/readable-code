package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudyCafeLockerPassTest {

    @DisplayName("동일한 패스 타입인지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"HOURLY", "WEEKLY", "FIXED"})
    void isSamePassType(String type) {
        // given
        StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(type);
        StudyCafeLockerPass studyCafeLockerPass = StudyCafeLockerPass.of(
            studyCafePassType,
            1,
            5000
        );
        
        // when
        boolean result = studyCafeLockerPass.isSamePassType(studyCafePassType);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("동일한 기간인지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void isSameDuration(int duration) {
        // given
        StudyCafeLockerPass studyCafeLockerPass = StudyCafeLockerPass.of(
            StudyCafePassType.FIXED,
            duration,
            1000
        );

        // when
        boolean sameDuration = studyCafeLockerPass.isSameDuration(duration);

        // then
        assertThat(sameDuration).isTrue();
    }
}
