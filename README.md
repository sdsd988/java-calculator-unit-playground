# java-calculator

계산기 미션 저장소

## 1. calculator.calculator(사칙연산 계산기)

기능 요구 사항

- 인자 2개를 받아 사칙연산을 할 수 있는 계산기 구현
- 사친연산과 대응하는 4개의 메서드를 제공
- 계산된 결과는 정수 반환


## 2. calculator.StringCalculator(문자열 계산기)

기능 요구 사항

- 클론 또는 쉼표를 구분자로 가지는 문자열을 전달하면, 구분자를 기준으로 분리한 각 숫자의 합 반환
- 앞의 구분자 외에 커스텀 구분자를 가질 수 있다.
- 문자열 계산기에 음수 혹은 숫자 이외의 문자열이 들어오면 RuntimeException 반환

## 3. 움직이는 자동차

### 기능 요구사항

1. 자동차는 `이름`을 갖는다.
2. 자동차는 움직일 수 있다.
   - 0 ~ 9 사이의 random 값을 구한 후, 4이상일 경우 전진

### 테스트 코드 작성 과정에서 고민한 내용

1. 파라미터를 어떻게 다룰 것인가. -> Random Number 누가 다룰 것인가.
2. 반환값을 어떻게 다룰 것인가.  -> 반환값이 없다면, 결과의 검증을 어떻게 해야하나.


### 2024 - 10 - 13 

1. Random Number - 내부 생성, 외부 주입
   - 클라이언트에게 받는 것으로 결정 : 자동차를 움직이는 것의 결정은 인스턴스 생성한 쪽에서 하는게 맞다고 생각.

## 4. 우승 자동차 구하기

1. Indicator Refactoring (생성자 추가) 
2. Indicator 객체 테스트 코드 추가
3. Cargame 생성


