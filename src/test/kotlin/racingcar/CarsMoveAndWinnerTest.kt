package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.MoveDecider
import java.util.ArrayDeque

class CarsMoveAndWinnerTest {

    class SequenceDecider(booleans: List<Boolean>) : MoveDecider {
        private val seq = ArrayDeque(booleans)

        override fun canMove(): Boolean {
            if (seq.isEmpty()) throw IllegalStateException("sequence exhausted")
            return seq.removeFirst()
        }
    }

    @Test
    @DisplayName("라운드마다 각 자동차를 한 번씩 이동시킨다")
    fun moveOncePerRound() {
        val cars = Cars.fromCommaSeparated("pobi,woni,jun")

        cars.moveOnce(SequenceDecider(listOf(true, true, false)))
        assertThat(cars.values().map { it.distance })
            .containsExactly(1, 1, 0)

        cars.moveOnce(SequenceDecider(listOf(false, true, false)))
        assertThat(cars.values().map { it.distance })
            .containsExactly(1, 2, 0)
    }

    @Test
    @DisplayName("최종 우승자(최댓값 보유자)를 계산한다 - 단독 우승")
    fun winnerSingle() {
        val cars = Cars.fromCommaSeparated("pobi,woni")

        cars.moveOnce(SequenceDecider(listOf(true, false)))
        cars.moveOnce(SequenceDecider(listOf(true, true)))

        assertThat(cars.winners().map { it.name })
            .containsExactly("pobi")
    }

    @Test
    @DisplayName("공동 우승자를 계산한다")
    fun winnerTie() {
        val cars = Cars.fromCommaSeparated("pobi,woni")

        cars.moveOnce(SequenceDecider(listOf(true, true)))

        assertThat(cars.winners().map { it.name })
            .containsExactlyInAnyOrder("pobi", "woni")
    }
}
