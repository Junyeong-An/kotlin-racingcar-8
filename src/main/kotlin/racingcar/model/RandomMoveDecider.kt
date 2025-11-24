package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RandomMoveDecider(
    private val min: Int,
    private val max: Int,
    private val threshold: Int
) : MoveDecider {

    override fun canMove(): Boolean {
        val value = Randoms.pickNumberInRange(min, max)
        return value >= threshold
    }
}
