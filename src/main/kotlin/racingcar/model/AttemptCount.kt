package racingcar.model

class AttemptCount private constructor(
    private val value: Int
) {

    fun value(): Int = value

    companion object {
        const val ERROR_ATTEMPT_COUNT_MIN = "시도할 횟수는 1이상이여야 합니다."
        const val ERROR_ATTEMPT_COUNT_NUMERIC_ONLY = "숫자만 입력해주세요."

        fun from(raw: String?): AttemptCount {
            requireNotNull(raw) { ERROR_ATTEMPT_COUNT_MIN }
            require(raw.matches(Regex("\\d+"))) { ERROR_ATTEMPT_COUNT_NUMERIC_ONLY }

            val parsed = raw.toInt()
            require(parsed >= 1) { ERROR_ATTEMPT_COUNT_MIN }

            return AttemptCount(parsed)
        }
    }
}
