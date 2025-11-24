package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.model.Cars

class CarsParsingTest {

    @Test
    @DisplayName("쉼표로 구분된 자동차 이름을 파싱하고 공백을 제거한다")
    fun parseCommaSeparatedNames() {
        val cars = Cars.fromCommaSeparated(" pobi , woni, jun ")

        assertThat(cars.values().map { it.name })
            .containsExactly("pobi", "woni", "jun")
    }

    @Test
    @DisplayName("빈 입력은 예외가 발생한다")
    fun nullOrEmptyInputThrows() {

        assertThatThrownBy { Cars.fromCommaSeparated(null) }
            .isInstanceOf(IllegalArgumentException::class.java)

        assertThatThrownBy { Cars.fromCommaSeparated(" , , ") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 예외가 발생한다")
    fun nameTooLongThrows() {
        assertThatThrownBy { Cars.fromCommaSeparated("pobiislong, woni") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("중복 이름이 있으면 예외가 발생한다")
    fun duplicateNameThrows() {
        assertThatThrownBy { Cars.fromCommaSeparated("pobi,pobi") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
