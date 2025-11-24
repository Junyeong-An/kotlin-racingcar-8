package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.controller.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    try {
        val inputView = InputView()
        val outputView = OutputView()
        val racingGame = RacingGame(inputView, outputView)
        racingGame.run()
    } finally {
        Console.close()
    }
}
