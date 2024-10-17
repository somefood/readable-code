package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeLockerPassesTest {
    
    @DisplayName("이용권에 부합하는 라커권이 있는지 확인한다.")
    @Test
    void findLockerPassBy() {
        // given
        StudyCafeLockerPasses lockerPasses = StudyCafeLockerPasses.of(
            List.of(
                StudyCafeLockerPass.of(StudyCafePassType.FIXED, 1, 1000),
                StudyCafeLockerPass.of(StudyCafePassType.FIXED, 2, 2000)
            )
        );
        StudyCafeSeatPass targetSeatPass = StudyCafeSeatPass.of(
            StudyCafePassType.FIXED, 1, 1000, 10
        );

        // when
        Optional<StudyCafeLockerPass> optional = lockerPasses.findLockerPassBy(targetSeatPass);

        // then
        assertThat(optional).isPresent();
        StudyCafeLockerPass actual = optional.get();
        assertThat(actual).extracting("passType", "duration", "price")
            .contains(StudyCafePassType.FIXED, 1, 1000);
    }

    @DisplayName("이용권에 부합하는 라커권이 없으면 빈 값을 반환한다.")
    @Test
    void findLockerPassWithNoSatisfiedSeatPass() {
        // given
        StudyCafeLockerPasses lockerPasses = StudyCafeLockerPasses.of(
            List.of(
                StudyCafeLockerPass.of(StudyCafePassType.FIXED, 1, 1000),
                StudyCafeLockerPass.of(StudyCafePassType.FIXED, 2, 2000)
            )
        );
        StudyCafeSeatPass targetSeatPass = StudyCafeSeatPass.of(
            StudyCafePassType.HOURLY, 1, 1000, 10
        );

        // when
        Optional<StudyCafeLockerPass> optional = lockerPasses.findLockerPassBy(targetSeatPass);

        // then
        assertThat(optional).isEmpty();
    }
}
