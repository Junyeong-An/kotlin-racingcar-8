package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.view.RacingPresenter

class RacingPresenterTest {

    @Test
    @DisplayName("자동차 진행상황을 문자열로 포맷한다")
    fun formatProgress() {
        val car = Car("pobi")
        car.carMove()
        car.carMove()

        val presenter = RacingPresenter()

        assertThat(presenter.formatProgressLine(car))
            .isEqualTo("pobi : --")
    }

    @Test
    @DisplayName("우승자 이름을 쉼표로 조인한다")
    fun formatWinners() {
        val a = Car("pobi")
        val b = Car("woni")

        val presenter = RacingPresenter()

        assertThat(presenter.formatWinnersNames(listOf(a, b)))
            .isEqualTo("pobi, woni")
    }
}
