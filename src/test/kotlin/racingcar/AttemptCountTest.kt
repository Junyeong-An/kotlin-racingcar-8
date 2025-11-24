package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.model.AttemptCount

class AttemptCountTest {

    @Test
    @DisplayName("정상 입력은 정수 값으로 변환된다")
    fun valid() {
        assertThat(AttemptCount.from("3").value()).isEqualTo(3)
    }

    @Test
    @DisplayName("숫자가 아니면 예외가 발생한다")
    fun nonNumericThrows() {
        assertThatThrownBy { AttemptCount.from("a12") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("1 미만이면 예외가 발생한다")
    fun lessThanOneThrows() {
        assertThatThrownBy { AttemptCount.from("0") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
