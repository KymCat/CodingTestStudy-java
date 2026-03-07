package 열거형.확장;

enum Operation {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    MULTI("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private String symbol;
    Operation(String symbol) {
        this.symbol = symbol;
    }

    // 열거형 매핑된 문자열을 반환하도록 오버라이딩
    @Override
    public String toString() {
        return symbol;
    }

    // 열거형 객체의 메소드에 사용될 추상 메서드 정의
    public abstract double apply(double x, double y);
}
