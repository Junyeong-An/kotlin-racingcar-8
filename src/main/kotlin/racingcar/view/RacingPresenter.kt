package racingcar.view

import racingcar.model.Car

class RacingPresenter {

    fun formatProgressLine(car: Car): String{
        return "${car.name} : ${SYMBOL_MOVEMENT.repeat(car.distance)}"
    }

    fun formatWinnersNames(winners: List<Car>): String{
        return winners.joinToString(separator = ",") { it.name }
    }

    companion object {
        private const val SYMBOL_MOVEMENT = "-"
    }
}
