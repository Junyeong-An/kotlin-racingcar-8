package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarTest {

    @Test
    @DisplayName("move() 호출 시 위치가 1 증가한다")
    fun moveIncrementsDistance() {
        val car = Car("pobi")
        car.carMove()
        assertThat(car.distance).isEqualTo(1)
    }

    @Test
    @DisplayName("이름이 같으면 같은 자동차로 간주한다 (equals/hashCode)")
    fun equalityByName() {
        val a = Car("pobi")
        val b = Car("pobi")

        assertThat(a).isEqualTo(b)
        assertThat(a.hashCode()).isEqualTo(b.hashCode())
    }

    @Test
    @DisplayName("빈 이름/과도한 길이는 예외가 발생한다")
    fun nameValidation() {
        assertThatThrownBy { Car("") }
            .isInstanceOf(IllegalArgumentException::class.java)

        assertThatThrownBy { Car("abcdef") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
