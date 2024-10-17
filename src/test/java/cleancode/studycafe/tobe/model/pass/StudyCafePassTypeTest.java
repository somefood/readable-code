package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassTypeTest {

    @DisplayName("선택한 패스권이 라커 컬렉션 안에 속한지 확인한다.")
    @Test
    void isLockerType() {
        // given
        StudyCafePassType lockerPass = StudyCafePassType.FIXED;
        
        // when
        boolean isLockerType = lockerPass.isLockerType();

        // then
        assertThat(isLockerType).isTrue();
    }
    
    @DisplayName("선택한 패스권이 라커 컬렉션 안에 속하지 않는지 확인한다.")
    @Test
    void isNotLockerType() {
        // given
        StudyCafePassType lockerPass = StudyCafePassType.HOURLY;
        
        // when
        boolean isNotLockerType = lockerPass.isNotLockerType();

        // then
        assertThat(isNotLockerType).isTrue();
    }
}
