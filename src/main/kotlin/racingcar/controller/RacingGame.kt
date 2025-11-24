package racingcar.controller

import racingcar.model.AttemptCount
import racingcar.model.Cars
import racingcar.model.MoveDecider
import racingcar.model.RandomMoveDecider
import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.view.RacingPresenter

class RacingGame(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    private lateinit var cars: Cars
    private val presenter = RacingPresenter()

    fun run() {
        startGame()
        gameProcess()
        winner()
    }

    fun startGame() {
        outputView.printCarNameMessage()
        val carNamesLine = inputView.carNameInput()
        cars = Cars.fromCommaSeparated(carNamesLine)
    }

    fun gameProcess() {
        outputView.printCountMessage()
        var rawCount: String = inputView.attemptCountInput()
        var count = AttemptCount.from(rawCount).value()

        outputView.printResultMessage()

        val decider: MoveDecider = RandomMoveDecider(RANDOM_MIN,RANDOM_MAX,MOVEABLE_NUMBER)

        repeat(count){
            playOneRound(decider)
        }

    }

    private fun playOneRound(decider: MoveDecider){
        cars.moveOnce(decider)

        cars.values().forEach { car->
            outputView.printLineMessage(presenter.formatProgressLine(car))
        }

        outputView.printEmptyMessage()
    }

    private fun winner(){
        val winners = cars.winners()
        val names = presenter.formatWinnersNames(winners)
        outputView.printWinnersMessage(names)
    }


    companion object {
        const val RANDOM_MIN: Int = 0
        const val RANDOM_MAX: Int = 9
        const val MOVEABLE_NUMBER: Int = 4
    }
}
