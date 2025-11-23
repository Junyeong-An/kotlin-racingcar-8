# kotlin-racingcar-pair-programming

# 개요
Kotlin을 활용하여 우테코 프리코스에서 수행했던 미션(racingcar)을 기반으로 페어 프로그래밍 실습을 진행한다.

# 구현할 기능 목록
## Model
1. Car
- 자동차 전진 or 멈춤
- 우승자 계산
- 랜덤 숫자 생성
2. Random
- 랜덤 숫자 생성

## View
1. Input
- 자동차의 이름 입력
- 시도할 횟수 입력
2. Output
- 입출력 안내문
- 각 차수별 실행 결과 출력
- 단독 또는 공동 우승자 안내 출력

## Controller
1. RacingGame
- 입력받은 자동차 목록과 시도 횟수를 기반으로 경주를 진행
- 각 라운드마다 모든 자동차를 한 번씩 이동
- 경주가 종료되면 최종 우승자를 계산
