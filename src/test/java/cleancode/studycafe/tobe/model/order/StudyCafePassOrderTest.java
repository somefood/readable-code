package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassOrderTest {

    
    @DisplayName("지정한 할인 금액을 계산한다.")
    @Test
    void getDiscountPrice() {
        // given
        StudyCafePassOrder studyCafePassOrder = StudyCafePassOrder.of(
            StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 100000, 0.1),
            StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 5000)
        );
        int discountPrice = 10000;

        // when
        int actual = studyCafePassOrder.getDiscountPrice();

        // then
        assertThat(actual).isEqualTo(discountPrice);
    }
    
    @DisplayName("라커룸을 가진 선택한 좌석패스의 총 가격을 계산한다.")
    @Test
    void getTotalPriceWithLocker() {
        // given
        StudyCafePassOrder studyCafePassOrder = StudyCafePassOrder.of(
            StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 100000, 0.1),
            StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 5000)
        );
        
        // when
        int actual = studyCafePassOrder.getTotalPrice();
        
        // then
        assertThat(actual).isEqualTo(95000);
    }

    @DisplayName("라커룸이 없는 선택한 좌석패스의 총 가격을 계산한다.")
    @Test
    void getTotalPriceWithNoLocker() {
        // given
        StudyCafePassOrder studyCafePassOrder = StudyCafePassOrder.of(
            StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 4, 4000, 0),
            null
        );

        // when
        int actual = studyCafePassOrder.getTotalPrice();

        // then
        assertThat(actual).isEqualTo(4000);
    }
}
