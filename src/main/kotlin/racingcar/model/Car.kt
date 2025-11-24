package racingcar.model

class Car(name: String) {
    lateinit var name: String
    var distance: Int = 0

    init {
        val trimmed = name.trim()
        validateName(trimmed)
        this.name = trimmed
    }

    fun carMove() {
        distance++
    }

    private fun validateName(name: String) {
        require(name.length <= 5) {
            ERROR_NAME_TOO_LONG
        }
        require(name.isNotEmpty()) {
            ERROR_NAME_EMPTY
        }
    }

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(other !is Car) return false
        return name == other.name
    }

    override fun hashCode(): Int = name.hashCode()

    companion object {
        private const val ERROR_NAME_TOO_LONG = "자동차 이름은 5자 이하만 가능합니다."
        private const val ERROR_NAME_EMPTY = "자동차 이름은 1자 이상이어야 합니다."
    }
}
