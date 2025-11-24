package racingcar.view

class OutputView {
    fun printCarNameMessage() {
        println(CARNAME_MESSAGE)
    }

    fun printCountMessage() {
        println(COUNT_MESSAGE)
    }

    fun printResultMessage() {
        println(RESULT_MESSAGE)
    }

    fun printWinnersMessage(winnersNames: String) {
        println(WINNER_MESSAGE + winnersNames)
    }

    fun printLineMessage(line: String){
        println(line)
    }

    fun printEmptyMessage(){
        println("")
    }


    companion object {
        const val CARNAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        const val RESULT_MESSAGE = "실행 결과"
        const val WINNER_MESSAGE = "최종 우승자 : "
    }
}
