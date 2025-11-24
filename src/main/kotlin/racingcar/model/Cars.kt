package racingcar.model

class Cars private constructor(
    private val values: List<Car>
) {

    init {
        validateUniqueNames(values)
    }

    fun values(): List<Car> = values.toList()

    fun moveOnce(decider: MoveDecider) {
        values.forEach { car ->
            if (decider.canMove()) {
                car.carMove()
            }
        }
    }

    fun winners(): List<Car> {
        val max = values.maxOf { it.distance }
        return values.filter { it.distance == max }
    }

    companion object {
        private const val ERROR_INPUT_NULL = "자동차 이름 입력이 비어있습니다."
        private const val ERROR_INPUT_EMPTY = "자동차 이름을 한 개 이상 입력해야 합니다."
        private const val ERROR_DUPLICATE_NAME = "같은 자동차가 입력되었습니다."

        fun fromNames(names: List<String>): Cars {
            val cars = names.map { Car(it) }
            return Cars(cars)
        }

        fun fromCommaSeparated(input: String?): Cars {
            requireNotNull(input) { ERROR_INPUT_NULL }

            val names = input.split(",")
                .map { it.trim() }
                .filter { it.isNotEmpty() }

            if (names.isEmpty()) {
                throw IllegalArgumentException(ERROR_INPUT_EMPTY)
            }

            return fromNames(names)
        }

        private fun validateUniqueNames(cars: List<Car>) {
            val seen = HashSet<String>()
            for (car in cars) {
                if (!seen.add(car.name)) {
                    throw IllegalArgumentException(ERROR_DUPLICATE_NAME)
                }
            }
        }
    }
}
