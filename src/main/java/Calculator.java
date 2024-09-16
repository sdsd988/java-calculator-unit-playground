public class Calculator {



    // 더하기
    public int plus(int a, int b) {
        return a + b;
    }

    // 빼기
    public int minus(int a, int b) {
        return a - b;
    }

    // 곱하기
    public int multiply(int a, int b) {
        return a * b;
    }

    // 나누기 - 예외 상황
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("0 으로 나눌 수 없습니다.");
        }
        return a / b;
    }

}